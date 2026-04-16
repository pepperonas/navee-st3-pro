#!/usr/bin/env python3
"""Patch a Navee BLDC firmware: change region byte and recompute the
header CRC-16/XMODEM that the Navee dashboard uses to validate uploads.

DISCOVERED 2026-04-16: the dashboard's BLDC firmware integrity check is
CRC-16/XMODEM (poly 0x1021, init 0x0000, no refl, no xor_out) over the
file from the first non-padding byte after the header (typically offset
0x80) to end-of-file, stored big-endian at header offset 0x13-0x14.

Verified across 26/32 known BLDC firmware files in tools/firmware/.

USAGE
-----
  python3 tools/patch_bldc_region.py INPUT.bin OUTPUT.bin --region 0xB7

Examples:
  # Minimal patch: only flip DE -> Global region marker
  python3 tools/patch_bldc_region.py \\
      tools/firmware/navee_bldc_v0.0.1.5_ST3_PRO_DE_22km_h,_pid=23452.bin \\
      tools/firmware/navee_bldc_v0.0.1.5_DE_to_GLOBAL_minimal.bin \\
      --region 0xB7

  # Same but also bump version digit so it doesn't trip downgrade-protection
  python3 tools/patch_bldc_region.py INPUT.bin OUTPUT.bin --region 0xB7 \\
      --version-digit 6   # patches the '5' in 'v0.0.1.5' -> '6' (-> v0.0.1.6)
"""
from __future__ import annotations
import argparse
import struct
import sys
from pathlib import Path


def crc16_xmodem(data: bytes) -> int:
    """CRC-16/XMODEM: poly 0x1021, init 0x0000, no refl, no xor_out."""
    crc = 0
    for b in data:
        crc ^= b << 8
        for _ in range(8):
            crc = ((crc << 1) ^ 0x1021) & 0xFFFF if (crc & 0x8000) else (crc << 1) & 0xFFFF
    return crc


def first_code_offset(data: bytes, header_end: int = 0x15) -> int:
    """Find offset of first non-0xFF byte after the header."""
    for i in range(header_end, len(data)):
        if data[i] != 0xFF:
            return i
    return len(data)


def parse_int(s: str) -> int:
    """Accept 0xCF, 0xb7, 207, 183 — also 'B7'/'CF' (raw hex)."""
    s = s.strip()
    if s.lower().startswith("0x"):
        return int(s, 16)
    try:
        return int(s, 10)
    except ValueError:
        return int(s, 16)


def main() -> int:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawDescriptionHelpFormatter)
    p.add_argument("input", type=Path, help="Source BLDC firmware (.bin)")
    p.add_argument("output", type=Path, help="Output patched firmware (.bin)")
    p.add_argument("--region", type=parse_int, default=None,
                   help="New region byte (e.g. 0xB7 = Global, 0xCF = DE). "
                        "Default: keep original.")
    p.add_argument("--version-digit", type=int, default=None,
                   help="Bump the '0.0.1.X' minor digit at offset 0x0E "
                        "(useful to bypass downgrade protection).")
    p.add_argument("--show", action="store_true",
                   help="Show before/after header dump only, do not write.")
    p.add_argument("--force-crc", type=parse_int, default=None,
                   help="Override the computed CRC with a specific value (debug only).")
    args = p.parse_args()

    if not args.input.exists():
        print(f"ERROR: input not found: {args.input}", file=sys.stderr)
        return 2

    data = bytearray(args.input.read_bytes())

    # ---- diagnose original ----
    orig_region = data[0x11]
    orig_crc_be = struct.unpack_from(">H", data, 0x13)[0]
    code_offset = first_code_offset(data)
    computed_orig = crc16_xmodem(bytes(data[code_offset:]))

    print(f"INPUT:  {args.input.name}  ({len(data)} bytes)")
    print(f"  Header[0:24]:        {bytes(data[:24]).hex()}")
    print(f"  Tag (T-prefix):      {bytes(data[:6]).rstrip(b'\\x00').decode('ascii', 'replace')}")
    print(f"  Category bytes:      {bytes(data[6:8]).hex()}  (0002 = BLDC, 0001 = Meter)")
    print(f"  Version ASCII:       {bytes(data[8:16]).rstrip(b'\\x00\\xFF').decode('ascii', 'replace')!r}")
    print(f"  Region byte (0x11):  0x{orig_region:02X}")
    print(f"  Marker  byte (0x12): 0x{data[0x12]:02X}")
    print(f"  Stored CRC (BE):     0x{orig_crc_be:04X}")
    print(f"  Computed CRC:        0x{computed_orig:04X}  "
          f"({'OK' if orig_crc_be == computed_orig else 'MISMATCH — header format may differ'})")
    print(f"  Code starts at:      0x{code_offset:X}")
    print()

    if orig_crc_be != computed_orig and args.force_crc is None:
        print("WARNING: original CRC does not match expected algorithm — this firmware "
              "may use a different header format. Patching may produce a non-uploadable file.",
              file=sys.stderr)

    # ---- apply patches ----
    changes = []
    if args.region is not None and args.region != orig_region:
        data[0x11] = args.region & 0xFF
        changes.append(f"region 0x{orig_region:02X} -> 0x{args.region:02X}")

    if args.version_digit is not None:
        # Version is ASCII at offset 0x08-0x0F, e.g. "00151010"
        # Layout: digits 2-3 = minor (e.g. '15' = 0.0.1.5)
        # We bump only the second digit of the minor pair (offset 0x0B).
        old_byte = data[0x0B]
        new_char = str(args.version_digit & 0xF).encode("ascii")[0]
        data[0x0B] = new_char
        changes.append(f"version digit @0x0B '0x{old_byte:02X}' -> "
                       f"'0x{new_char:02X}' (now '{bytes(data[8:16]).rstrip(bytes([0xFF])).decode('ascii', 'replace')}')")

    # ---- recompute CRC over the (possibly unchanged) body ----
    # Region byte and version are BEFORE code start — they don't affect the body CRC.
    # But for safety we always recompute.
    new_crc = crc16_xmodem(bytes(data[code_offset:])) if args.force_crc is None else args.force_crc
    struct.pack_into(">H", data, 0x13, new_crc)
    if new_crc != orig_crc_be:
        changes.append(f"CRC 0x{orig_crc_be:04X} -> 0x{new_crc:04X} (BE @0x13)")

    print("PATCHES:")
    if not changes:
        print("  (no changes — output identical to input)")
    for c in changes:
        print(f"  - {c}")
    print()

    print(f"OUTPUT: {args.output.name}")
    print(f"  Header[0:24]:        {bytes(data[:24]).hex()}")
    print(f"  Region byte (0x11):  0x{data[0x11]:02X}")
    print(f"  Stored CRC (BE):     0x{struct.unpack_from('>H', data, 0x13)[0]:04X}")

    if not args.show:
        args.output.write_bytes(bytes(data))
        print(f"\n✓ Wrote {len(data)} bytes to {args.output}")
        print(f"\nNext steps:")
        print(f"  1. Inspect with hexdump:")
        print(f"     hexdump -C {args.output} | head")
        print(f"  2. Try OTA flash:")
        print(f"     python3 tools/ota_flasher.py {args.output}")
        print(f"  3. If dashboard NAKs -> the validation does more than just CRC check.")
        print(f"     Check dashboard SPI flash dump (navee_full_flash_dump.bin) for")
        print(f"     additional checks (PID match, version compare, etc).")
    return 0


if __name__ == "__main__":
    sys.exit(main())

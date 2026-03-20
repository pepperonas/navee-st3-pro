#!/usr/bin/env python3
"""
Navee ST3 Pro — Automatic Firmware Patcher

Patches the speed limit in any Navee meter firmware and recalculates
the RTL8762C SHA-256 checksum for valid OTA installation.

Usage:
    python3 patch_firmware.py firmware.bin
    python3 patch_firmware.py firmware.bin -o output.bin
    python3 patch_firmware.py firmware.bin --dry-run

The patch:
    BLS instruction (02 D9) -> NOP (00 BF) in lift_speed_limit function
    Activates custom speed mode, settable via BLE CMD 0x6E

(c) 2026 Martin Pfeffer | celox.io
"""

import argparse
import hashlib
import struct
import sys
from pathlib import Path

# Speed limit patch: BLS (branch if less/same) -> NOP
PATCH_PATTERN = bytes([0x0E, 0x2D, 0x02, 0xD8, 0x04, 0xE0, 0x0A, 0x2D, 0x02, 0xD9])
PATCH_OFFSET_IN_PATTERN = 8  # Position of 02 D9 within the pattern
PATCH_OLD = bytes([0x02, 0xD9])  # BLS
PATCH_NEW = bytes([0x00, 0xBF])  # NOP

# RTL8762C Image Header constants
IMG_HEADER_OFFSET = 0x400   # Navee OTA header is 1024 bytes before image header
IMG_HEADER_SIZE = 1024      # RTL8762C image header size
DFU_HEADER_SIZE = 12        # ctrl_header size
SHA256_OFFSET = 372         # SHA-256 field offset within image header
SHA256_SIZE = 32


def find_patch_location(data: bytes) -> int:
    """Find the BLS instruction to patch by searching for the surrounding context."""
    idx = data.find(PATCH_PATTERN)
    if idx < 0:
        return -1
    # The actual patch bytes (02 D9) are at offset 8 within the pattern
    return idx + PATCH_OFFSET_IN_PATTERN


def compute_sha256(data: bytes, img_off: int, payload_len: int) -> bytes:
    """Compute SHA-256 over the 3 regions defined by RTL8762C SDK.

    Region 1: Header[12:372]       (360 bytes — after ctrl_header, before SHA field)
    Region 2: Header[404:752]      (348 bytes — after SHA field, before RSA area)
    Region 3: Header[1008:1024] + Payload  (16 + payload_len bytes)

    Source: Realtek Bee2 SDK, silent_dfu_flash.c, slient_dfu_check_sha256()
    """
    r1 = data[img_off + DFU_HEADER_SIZE : img_off + SHA256_OFFSET]
    r2 = data[img_off + SHA256_OFFSET + SHA256_SIZE : img_off + 752]
    r3 = data[img_off + IMG_HEADER_SIZE - 16 : img_off + IMG_HEADER_SIZE + payload_len]

    ctx = hashlib.sha256()
    ctx.update(r1)
    ctx.update(r2)
    ctx.update(r3)
    return ctx.digest()


def patch_firmware(input_path: str, output_path: str = None, dry_run: bool = False) -> bool:
    """Patch a Navee firmware binary and fix the SHA-256 checksum."""

    fw = Path(input_path).read_bytes()
    print(f"Firmware: {input_path} ({len(fw)} Bytes)")

    # --- Validate Navee OTA header ---
    model = fw[:5].decode('ascii', errors='replace')
    if not model.startswith('T'):
        print(f"FEHLER: Kein Navee OTA-Header (erwartet 'Txxxx', bekam '{model}')")
        return False
    print(f"Model: {model}")

    fw_type = fw[6]
    version = fw[7:15].decode('ascii', errors='replace').rstrip('\x00')
    print(f"Type: 0x{fw_type:02X} ({'Meter' if fw_type == 1 else 'Unknown'})")
    print(f"Version: {version}")

    # --- Validate RTL8762C image header ---
    img_off = IMG_HEADER_OFFSET
    ic_type = fw[img_off]
    image_id = struct.unpack('<H', fw[img_off + 4 : img_off + 6])[0]
    crc16_field = struct.unpack('<H', fw[img_off + 6 : img_off + 8])[0]
    payload_len = struct.unpack('<I', fw[img_off + 8 : img_off + 12])[0]

    print(f"\nImage Header bei 0x{img_off:03X}:")
    print(f"  ic_type: 0x{ic_type:02X}")
    print(f"  image_id: 0x{image_id:04X} ({'App' if image_id == 0x2793 else 'Patch' if image_id == 0x2792 else '?'})")
    print(f"  crc16: 0x{crc16_field:04X} ({'SHA-256 Modus' if crc16_field == 0 else 'CRC-16 Modus'})")
    print(f"  payload_len: {payload_len}")

    if crc16_field != 0:
        print(f"WARNUNG: crc16 != 0 — dieses Image nutzt CRC-16 statt SHA-256!")
        print(f"  Der Patch-Algorithmus unterstützt nur SHA-256 Modus (crc16=0).")
        return False

    # --- Verify original SHA-256 ---
    sha_stored = fw[img_off + SHA256_OFFSET : img_off + SHA256_OFFSET + SHA256_SIZE]
    sha_calc = compute_sha256(fw, img_off, payload_len)

    if sha_calc != sha_stored:
        print(f"\nWARNUNG: Original SHA-256 stimmt nicht!")
        print(f"  Gespeichert: {sha_stored.hex()}")
        print(f"  Berechnet:   {sha_calc.hex()}")
        print(f"  Die Firmware-Datei könnte beschädigt sein.")
        return False

    print(f"\nOriginal SHA-256 verifiziert: {sha_stored.hex()[:16]}...")

    # --- Find patch location ---
    patch_off = find_patch_location(fw)
    if patch_off < 0:
        print(f"\nFEHLER: Patch-Pattern nicht gefunden!")
        print(f"  Gesucht: {PATCH_PATTERN.hex()}")
        print(f"  Diese Firmware-Version hat möglicherweise eine andere Code-Struktur.")
        return False

    if fw[patch_off:patch_off + 2] != PATCH_OLD:
        if fw[patch_off:patch_off + 2] == PATCH_NEW:
            print(f"\nFirmware ist bereits gepatcht! (0x{patch_off:04X}: 00 BF)")
            return True
        print(f"\nFEHLER: Unerwartete Bytes bei 0x{patch_off:04X}: "
              f"0x{fw[patch_off]:02X} 0x{fw[patch_off+1]:02X}")
        return False

    print(f"\nPatch-Stelle gefunden: Offset 0x{patch_off:04X}")
    print(f"  Aktuell: 0x{fw[patch_off]:02X} 0x{fw[patch_off+1]:02X} (BLS)")
    print(f"  Neu:     0x00 0xBF (NOP)")

    if dry_run:
        print(f"\n[DRY RUN] Keine Datei geschrieben.")
        return True

    # --- Apply patch ---
    patched = bytearray(fw)
    patched[patch_off] = 0x00
    patched[patch_off + 1] = 0xBF

    # --- Recalculate SHA-256 ---
    new_sha = compute_sha256(bytes(patched), img_off, payload_len)
    patched[img_off + SHA256_OFFSET : img_off + SHA256_OFFSET + SHA256_SIZE] = new_sha

    # --- Verify ---
    verify_sha = compute_sha256(bytes(patched), img_off, payload_len)
    stored_sha = bytes(patched[img_off + SHA256_OFFSET : img_off + SHA256_OFFSET + SHA256_SIZE])
    if verify_sha != stored_sha:
        print(f"\nFEHLER: SHA-256 Verifikation fehlgeschlagen!")
        return False

    # --- Save ---
    if output_path is None:
        stem = Path(input_path).stem
        suffix = Path(input_path).suffix
        output_path = str(Path(input_path).parent / f"{stem}_PATCHED_OTA{suffix}")

    Path(output_path).write_bytes(patched)

    diffs = sum(1 for i in range(len(fw)) if fw[i] != patched[i])
    print(f"\nGespeichert: {output_path}")
    print(f"Änderungen:  {diffs} Bytes (32 SHA-256 + 2 NOP)")
    print(f"SHA-256 neu: {new_sha.hex()}")
    print(f"\nFlash-Befehl:")
    print(f"  python3 ota_flasher.py {output_path}")
    return True


def main():
    parser = argparse.ArgumentParser(
        description="Navee ST3 Pro Firmware Patcher — Speed Limit Unlock via OTA",
        epilog="(c) 2026 Martin Pfeffer | celox.io"
    )
    parser.add_argument("firmware", help="Navee firmware binary (.bin)")
    parser.add_argument("-o", "--output", help="Output file (default: *_PATCHED_OTA.bin)")
    parser.add_argument("--dry-run", action="store_true", help="Nur prüfen, nicht patchen")
    args = parser.parse_args()

    if not Path(args.firmware).exists():
        print(f"FEHLER: Datei nicht gefunden: {args.firmware}")
        sys.exit(1)

    success = patch_firmware(args.firmware, args.output, args.dry_run)
    sys.exit(0 if success else 1)


if __name__ == "__main__":
    main()

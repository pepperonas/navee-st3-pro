#!/usr/bin/env python3
"""
se_scan.py — Static analysis: scan firmware dumps for Secure Element
indicators (Apple FMN, ATECC608, SE050, OPTIGA, etc.)

Usage:
    python3 tools/se_scan.py [firmware.bin ...]

Default scans tools/firmware/navee_full_flash_dump.bin and ROM dumps.

Detects:
  - Vendor strings (ATECC, SE050, OPTIGA, fmna, fm_crypto, secure_element)
  - Crypto-primitive strings (secp256r1, AES-256-GCM, SHA256, etc.)
  - ATECC608 command opcodes embedded as Thumb MOVS imm8 patterns
  - Common I2C addresses for SE chips (0x60 ATECC, 0x48 SE050, 0x30 OPTIGA)
  - RTL8762C peripheral base address references (where I2C/SPI traffic goes)
"""
from __future__ import annotations

import argparse
import re
import struct
import sys
from pathlib import Path

# ---------- defaults ----------
SCRIPT_DIR = Path(__file__).resolve().parent
DEFAULT_FILES = [
    SCRIPT_DIR / "firmware" / "navee_full_flash_dump.bin",
    SCRIPT_DIR / "firmware" / "rom_0x600000_16k.bin",
    SCRIPT_DIR / "firmware" / "bootloader_dump.bin",
]
DASHBOARD_BASE = 0x00800000  # RTL8762C XIP mapping for the full flash dump

# ---------- ANSI ----------
def _c(t, code):
    return f"\033[{code}m{t}\033[0m" if sys.stdout.isatty() else t

def red(t): return _c(t, "31")
def green(t): return _c(t, "32")
def yellow(t): return _c(t, "33")
def cyan(t): return _c(t, "36")
def bold(t): return _c(t, "1")


# ---------- keyword catalogue ----------
SE_VENDOR_STRINGS = [
    # Microchip / Atmel
    b"ATECC", b"ATECC608", b"ATSHA204", b"cryptoauth", b"hal_atca",
    # NXP
    b"SE050", b"SE051", b"sss_", b"PlugAndTrust",
    # Infineon
    b"OPTIGA", b"Trust_M", b"OPTIGA Trust",
    # Apple MFi
    b"MFi", b"MFI Auth", b"Apple Auth",
    # Generic
    b"secure_element", b"sec_elem", b"se_init", b"se_open",
    b"se_send", b"se_recv", b"se_reset", b"se_wake",
    b"crypto_engine", b"hw_crypto", b"trust_anchor", b"root_of_trust",
]

# Apple FMN (Find My Network) symbols
FMN_STRINGS = [
    b"fmna_", b"fm_crypto_", b"FMNA_SM",
    b"ServerSharedSecret", b"PairingSession",
    b"SerialNumberProtection",
    b"key_rotate", b"keyroll",
]

# Crypto-primitive strings
CRYPTO_STRINGS = [
    b"secp224r1", b"secp256r1", b"prime256v1",
    b"SHA224", b"SHA256", b"SHA512", b"HMAC",
    b"AES-128-ECB", b"AES-128-CTR", b"AES-128-GCM", b"AES-192-GCM", b"AES-256-GCM",
    b"ECDSA", b"ECDH", b"ECC", b"RSA",
    b"mbedtls_", b"PSA_", b"psa_crypto",
]

# I2C addresses commonly used by SEs (raw 7-bit form)
SE_I2C_ADDRS = {
    0x60: "ATECC608A (default)",
    0x6A: "ATECC608A (alt)",
    0x6C: "ATECC608A (alt 2)",
    0x48: "SE050 / SE051",
    0x49: "SE050 / SE051 (alt)",
    0x30: "OPTIGA Trust X",
    0x31: "OPTIGA Trust X (alt)",
    0x64: "ATSHA204A",
    0x66: "ATSHA204A (alt)",
    0x10: "Apple MFi Auth IC 3.0 (typical)",
}

# ATECC608 command opcodes (when encoded as MOVS Rn,#imm8)
ATECC_OPCODES = {
    0x16: "GenKey",        0x17: "Info",          0x18: "Lock",
    0x1B: "Random",        0x1C: "Read",          0x1E: "Sign (T2)",
    0x40: "GenDig",        0x41: "Sign",          0x43: "GenDivKey",
    0x45: "Verify",        0x46: "PrivWrite",     0x47: "Nonce",
    0x48: "MAC",           0x4C: "ECDH",          0x52: "DeriveKey",
}

# RTL8762C peripheral base addresses (subset relevant for SE comm)
RTL_PERIPHERAL_BASES = {
    0x40001000: "GPIO/Timer (high-priority)",
    0x40002000: "I2C0 / UART0",
    0x40004000: "SPI flash controller",
    0x40005000: "SPI0",
    0x40006000: "UART2 / I2C alt",
    0x40009000: "SPI1",
    0x4000F000: "SPI master / DMA-attached",
    0x40050000: "I2C2 (alt mapping)",
    0x40058000: "SPI0 (alt)",
}


# ---------- helpers ----------
def search_strings(data: bytes, needles: list[bytes]) -> dict[bytes, list[int]]:
    out = {}
    for n in needles:
        poses = [m.start() for m in re.finditer(re.escape(n), data)]
        if poses:
            out[n] = poses
    return out


def dedupe_mirrored_offsets(poses: list[int], mirror_step: int = 0x36000) -> list[int]:
    """Remove offsets that are mirror duplicates (Bank A vs Bank B in dual-bank flash)."""
    seen = set()
    out = []
    for p in poses:
        # Bucketize by mirror step
        bucket = p % mirror_step
        if bucket in seen:
            continue
        seen.add(bucket)
        out.append(p)
    return out


def file2mem(off: int, base: int = DASHBOARD_BASE) -> int:
    return off + base


def hexdump_line(data: bytes, off: int, width: int = 32, base: int = DASHBOARD_BASE) -> str:
    chunk = data[off:off + width]
    asc = "".join(chr(b) if 32 <= b < 127 else "." for b in chunk)
    return f"  @0x{file2mem(off, base):08X}: {asc!r}"


# ---------- scan modules ----------
def scan_strings(data: bytes, label: str, base: int = DASHBOARD_BASE) -> int:
    """Scan for SE vendor / FMN / crypto strings. Returns total hit count."""
    print(bold(cyan(f"\n=== STRING SCAN: {label} ===")))
    total = 0

    for category, needles in [
        ("SE Vendor", SE_VENDOR_STRINGS),
        ("Apple FMN", FMN_STRINGS),
        ("Crypto Primitives", CRYPTO_STRINGS),
    ]:
        hits = search_strings(data, needles)
        if not hits:
            print(f"  [{category}] no hits")
            continue
        print(f"  [{category}] {len(hits)} keywords matched:")
        for needle, poses in sorted(hits.items()):
            unique = dedupe_mirrored_offsets(poses)
            total += len(unique)
            print(f"    {needle.decode():<28} {len(unique):>3} unique:")
            for p in unique[:3]:
                print(hexdump_line(data, max(0, p - 4), 32, base))
    return total


def scan_atecc_opcodes(data: bytes, code_start: int, code_end: int,
                        base: int = DASHBOARD_BASE) -> None:
    """Find Thumb 'MOVS Rn, #opcode' patterns in code region.

    Thumb MOVS Rn, #imm8 encoding: 0010 0Rrr iiii iiii  (LE: imm,opbyte)
    Where opbyte = 0x20 + (Rrr << 0).
    """
    print(bold(cyan("\n=== ATECC OPCODE PATTERN SCAN ===")))
    print(f"  Searching for Thumb MOVS Rn, #imm in 0x{base+code_start:08X}-0x{base+code_end:08X}")

    found = {}
    for opcode, name in ATECC_OPCODES.items():
        for reg in range(4):
            opbyte = 0x20 + reg
            count = 0
            for off in range(code_start, code_end - 1):
                if data[off] == opcode and data[off + 1] == opbyte:
                    count += 1
            if count > 0:
                found.setdefault(opcode, []).append((reg, count))

    if not found:
        print(yellow("  no ATECC opcode patterns found"))
        return

    print(f"  Possible ATECC opcode loads:")
    for opcode in sorted(found.keys()):
        regs = found[opcode]
        regs_str = ", ".join(f"R{r}={c}" for r, c in regs)
        print(f"    0x{opcode:02X} {ATECC_OPCODES[opcode]:<12} → {regs_str}")
    print(yellow("  NOTE: noisy without context. Use Ghidra to verify each match."))


def scan_peripheral_refs(data: bytes, code_start: int, code_end: int,
                          base: int = DASHBOARD_BASE) -> None:
    """Find pool entries pointing to RTL8762C peripheral bases."""
    print(bold(cyan("\n=== PERIPHERAL BASE-ADDR REFERENCES ===")))
    print(f"  Scanning literal pools in 0x{base+code_start:08X}-0x{base+code_end:08X}")

    refs = {}
    for off in range(code_start, code_end - 4, 4):
        v = struct.unpack_from("<I", data, off)[0]
        block = v & 0xFFFFF000  # round to 4 KB block
        if block in RTL_PERIPHERAL_BASES:
            refs.setdefault(block, []).append((off, v))

    if not refs:
        print(yellow("  no peripheral references found"))
        return

    for block in sorted(refs.keys()):
        entries = refs[block]
        offsets_within = sorted({e[1] - block for e in entries})
        name = RTL_PERIPHERAL_BASES[block]
        print(f"  0x{block:08X}  {name:<30} {len(entries):>3} refs  "
              f"(within-block: {offsets_within[:8]})")


def scan_i2c_address_loads(data: bytes, code_start: int, code_end: int,
                            base: int = DASHBOARD_BASE) -> None:
    """Find Thumb 'MOVS Rn, #addr' for known SE I2C addresses."""
    print(bold(cyan("\n=== SE I2C ADDRESS LOAD PATTERN ===")))
    print(f"  Searching for MOVS Rn, #i2c_addr in 0x{base+code_start:08X}-0x{base+code_end:08X}")

    for addr, name in SE_I2C_ADDRS.items():
        for reg in range(4):
            opbyte = 0x20 + reg
            hits = []
            for off in range(code_start, code_end - 1):
                if data[off] == addr and data[off + 1] == opbyte:
                    hits.append(off)
            if hits:
                print(f"  0x{addr:02X} ({name}) loaded into R{reg}: {len(hits)} hits")
                for h in hits[:3]:
                    print(hexdump_line(data, max(0, h - 6), 16, base))


# ---------- entry point ----------
def main() -> int:
    p = argparse.ArgumentParser(description=__doc__,
                                formatter_class=argparse.RawDescriptionHelpFormatter)
    p.add_argument("files", nargs="*", type=Path,
                   help="firmware .bin files (default: full_flash_dump + ROMs)")
    p.add_argument("--app-only", action="store_true",
                   help="only scan App-image region (FILE 0x0E000-0x040000)")
    args = p.parse_args()

    files = args.files if args.files else DEFAULT_FILES

    for f in files:
        if not f.exists():
            print(yellow(f"\nSKIP (not found): {f}"))
            continue
        data = f.read_bytes()
        print()
        print(bold("=" * 78))
        print(bold(f"  {f.name}  ({len(data)} bytes = 0x{len(data):X})"))
        print(bold("=" * 78))

        scan_strings(data, f.name)

        # Code-region for opcode + peripheral scans
        if "full_flash" in f.name:
            cs, ce = (0x00E400, 0x0082F69C - 0x00800000) if args.app_only else (0, len(data))
            scan_atecc_opcodes(data, cs, ce)
            scan_peripheral_refs(data, cs, ce)
            scan_i2c_address_loads(data, cs, ce)

    print()
    print(bold(cyan("=" * 78)))
    print(bold(cyan("  Scan complete. See docs/secure_element_analysis.md for context.")))
    print(bold(cyan("=" * 78)))
    return 0


if __name__ == "__main__":
    sys.exit(main())

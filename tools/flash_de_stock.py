#!/usr/bin/env python3
"""
flash_de_stock.py — Flash original (stock) DE BLDC firmware via BLE OTA.

Recovery / restore tool. Flashes the unmodified
`navee_bldc_v0.0.1.5_ST3_PRO_DE_22km_h,_pid=23452.bin` firmware
back to the BLDC controller via the dashboard's OTA path.

Usage:
  python3 flash_de_stock.py                 # Flash with confirmation prompt
  python3 flash_de_stock.py -y              # Skip confirmation
  python3 flash_de_stock.py --dry-run       # Show plan, no BLE activity
  python3 flash_de_stock.py --device-id <ID>  # Override saved device ID

Wraps `ota_flasher.py` with hardcoded firmware path + integrity check.
The device ID is read from / saved to `ota_config.json`.
"""
from __future__ import annotations

import argparse
import hashlib
import math
import subprocess
import sys
from pathlib import Path

# --- Hardcoded paths (relative to this script) -----------------------------
SCRIPT_DIR = Path(__file__).resolve().parent
FIRMWARE = SCRIPT_DIR / "firmware" / "navee_bldc_v0.0.1.5_ST3_PRO_DE_22km_h,_pid=23452.bin"
EXPECTED_MD5 = "b98998dca86db3efd8eb69977d6eac62"
EXPECTED_SIZE = 53376  # bytes
OTA_FLASHER = SCRIPT_DIR / "ota_flasher.py"


# --- Tiny ANSI helpers -----------------------------------------------------
def _c(t: str, code: str) -> str:
    return f"\033[{code}m{t}\033[0m" if sys.stdout.isatty() else t

def red(t: str)    -> str: return _c(t, "31")
def green(t: str)  -> str: return _c(t, "32")
def yellow(t: str) -> str: return _c(t, "33")
def cyan(t: str)   -> str: return _c(t, "36")
def bold(t: str)   -> str: return _c(t, "1")


def verify_firmware() -> bool:
    """Check firmware file exists, has correct size + MD5."""
    if not FIRMWARE.exists():
        print(red(f"ERROR: firmware file not found:"))
        print(red(f"  {FIRMWARE}"))
        return False

    size = FIRMWARE.stat().st_size
    if size != EXPECTED_SIZE:
        print(red(f"ERROR: firmware size mismatch: expected {EXPECTED_SIZE}, got {size}"))
        return False

    md5 = hashlib.md5(FIRMWARE.read_bytes()).hexdigest()
    if md5 != EXPECTED_MD5:
        print(red(f"ERROR: firmware MD5 mismatch — file has been modified!"))
        print(red(f"  expected {EXPECTED_MD5}"))
        print(red(f"  got      {md5}"))
        print(red(f"  This tool only flashes the unmodified stock DE firmware."))
        return False

    return True


def show_summary() -> None:
    blocks = math.ceil(EXPECTED_SIZE / 128)
    print()
    print(bold(cyan("─" * 64)))
    print(bold(cyan("  NAVEE ST3 PRO DE — STOCK BLDC FIRMWARE RESTORE")))
    print(bold(cyan("─" * 64)))
    print()
    print(f"  Firmware:  {FIRMWARE.name}")
    print(f"  Size:      {EXPECTED_SIZE:,} bytes ({EXPECTED_SIZE/1024:.1f} KB) — {blocks} XMODEM blocks")
    print(f"  MD5:       {EXPECTED_MD5}  ✓ verified")
    print(f"  Type:      BLDC controller firmware (DFU type 2)")
    print(f"  Region:    DE (0xCF) — 22 km/h limit")
    print(f"  Version:   v0.0.1.5  build 1010")
    print(f"  CRC-16:    0x83C4 (XMODEM, header @ 0x13-0x14, big-endian)")
    print()


def show_warnings() -> None:
    print(yellow("  ┌─ Pre-flight checklist ─────────────────────────────────────┐"))
    print(yellow("  │  • Battery > 30%, scooter switched ON                      │"))
    print(yellow("  │  • No other BLE clients connected (close Navee app, etc.)  │"))
    print(yellow("  │  • Do NOT power-cycle during transfer                      │"))
    print(yellow("  │  • Device ID configured (read from ota_config.json)        │"))
    print(yellow("  └────────────────────────────────────────────────────────────┘"))
    print()
    print(yellow("  Historical note: BLDC OTA via this BLE path has NAK'd Block 1"))
    print(yellow("  in 35+ prior sessions (see ANALYSIS.md). This tool is here as"))
    print(yellow("  a baseline / recovery option — try it before assuming damage."))
    print()


def confirm() -> bool:
    answer = input(bold(f"  Type {green('YES')} to proceed (anything else aborts): "))
    return answer.strip() == "YES"


def main() -> int:
    p = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    p.add_argument("-y", "--yes", action="store_true",
                   help="skip the YES confirmation prompt")
    p.add_argument("--dry-run", action="store_true",
                   help="show plan only, no BLE activity")
    p.add_argument("--device-id", type=str, default=None,
                   help="override the saved BLE device ID (12 hex chars)")
    args = p.parse_args()

    if not OTA_FLASHER.exists():
        print(red(f"ERROR: ota_flasher.py not found at {OTA_FLASHER}"))
        return 2

    if not verify_firmware():
        return 2

    show_summary()

    if args.dry_run:
        print(yellow("  [DRY RUN] Would invoke:"))
        print(f"    python3 {OTA_FLASHER.name} \\")
        print(f"      {FIRMWARE}")
        if args.device_id:
            print(f"      --device-id {args.device_id}")
        print()
        print(green("  Dry run complete — no BLE activity, no flash performed."))
        print()
        return 0

    show_warnings()

    if not args.yes and not confirm():
        print(red("\n  Aborted.\n"))
        return 1
    print()

    # Build subprocess call to ota_flasher.py
    cmd = [sys.executable, str(OTA_FLASHER), str(FIRMWARE)]
    if args.device_id:
        cmd += ["--device-id", args.device_id]

    print(cyan("  ─── ota_flasher.py output below ───"))
    print()
    sys.stdout.flush()  # ensure our header is visible before subprocess takes stdout

    # ota_flasher.py has its own YES prompt — pre-feed YES via stdin
    try:
        result = subprocess.run(
            cmd, input="YES\n", text=True, cwd=str(SCRIPT_DIR))
    except KeyboardInterrupt:
        print(red("\n\n  Interrupted by user.\n"))
        return 130

    print()
    print(cyan("  ─── result ───"))
    print()
    if result.returncode == 0:
        print(green(bold("  ✓ Stock DE firmware flash completed successfully.")))
        print()
        print("  Next steps:")
        print("    1. Power-cycle the scooter to apply the new firmware.")
        print("    2. Verify the BLDC firmware version:")
        print(f"       python3 {OTA_FLASHER.name} --read-info")
        print("       Should report BLDC v0.0.1.5 (build 1010).")
    else:
        print(red(bold(f"  ✗ Flash failed (exit code {result.returncode}).")))
        print()
        print("  This matches the prior session pattern (Block 1 NAK).")
        print("  See ANALYSIS.md and ota_flash_log.json for diagnostics.")
        print("  No data was written to the BLDC controller — it remains on its")
        print("  current firmware. Direct UART flash via ESC board (TX0/RX0) is")
        print("  the alternative path; see uart_direct_flasher.py.")
    print()
    return result.returncode


if __name__ == "__main__":
    sys.exit(main())

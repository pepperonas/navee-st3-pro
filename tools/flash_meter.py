#!/usr/bin/env python3
"""
flash_meter.py — Flash dashboard (METER) firmware via BLE OTA.

The METER firmware is the dashboard's own RTL8762C application code.
This OTA path has been verified working (see git commit 1b0889d:
"OTA-Flash VERIFIZIERT — 1080/1080 Blöcke, 0 Fehler, 34s").

Usage:
  python3 flash_meter.py                       # Flash STOCK ORIGINAL meter FW
  python3 flash_meter.py custom_meter.bin      # Flash specified METER firmware
  python3 flash_meter.py custom.bin --dry-run  # Show plan, no BLE activity
  python3 flash_meter.py -y                    # Skip confirmation
  python3 flash_meter.py custom.bin --device-id <ID>

The tool refuses to flash anything that isn't a valid METER firmware
(header type byte at offset 0x06 must be 0x01). Custom files must use
the same Navee meter firmware format.
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
FW_DIR = SCRIPT_DIR / "firmware"
DEFAULT_FW = FW_DIR / "navee_meter_v2.0.3.1_ORIGINAL.bin"

ORIGINAL_MD5  = "07ef6eeba20727ce9e042752b9923331"
ORIGINAL_SIZE = 138240  # bytes (0x21C00)
METER_TYPE_BYTE = 0x01  # header[0x06] must be 0x01 for METER firmware

OTA_FLASHER = SCRIPT_DIR / "ota_flasher.py"


# --- Tiny ANSI helpers -----------------------------------------------------
def _c(t: str, code: str) -> str:
    return f"\033[{code}m{t}\033[0m" if sys.stdout.isatty() else t

def red(t: str)    -> str: return _c(t, "31")
def green(t: str)  -> str: return _c(t, "32")
def yellow(t: str) -> str: return _c(t, "33")
def cyan(t: str)   -> str: return _c(t, "36")
def grey(t: str)   -> str: return _c(t, "90")
def bold(t: str)   -> str: return _c(t, "1")


def analyze(path: Path) -> dict | None:
    """Open the firmware, validate format, return metadata."""
    if not path.exists():
        print(red(f"ERROR: firmware file not found: {path}"))
        return None

    size = path.stat().st_size
    data = path.read_bytes()
    if size < 32:
        print(red(f"ERROR: firmware too small ({size} bytes)"))
        return None

    md5 = hashlib.md5(data).hexdigest()
    type_byte = data[6]
    tag = data[:6].rstrip(b"\x00").decode("ascii", "replace")
    version = data[7:15].rstrip(b"\x00\xFF").decode("ascii", "replace")

    is_original = (md5 == ORIGINAL_MD5 and size == ORIGINAL_SIZE)
    is_meter = (type_byte == METER_TYPE_BYTE)

    pad = 0
    for b in reversed(data):
        if b == 0xFF: pad += 1
        else: break

    return {
        "path": path,
        "size": size,
        "md5": md5,
        "tag": tag,
        "type_byte": type_byte,
        "version": version,
        "is_original": is_original,
        "is_meter": is_meter,
        "padding": pad,
        "blocks": math.ceil(size / 128),
    }


def show_summary(info: dict, is_default: bool) -> None:
    print()
    print(bold(cyan("─" * 64)))
    if is_default:
        print(bold(cyan("  DASHBOARD (METER) FIRMWARE FLASH — STOCK ORIGINAL")))
    else:
        print(bold(cyan("  DASHBOARD (METER) FIRMWARE FLASH — CUSTOM")))
    print(bold(cyan("─" * 64)))
    print()
    print(f"  File:      {info['path'].name}")
    print(f"  Size:      {info['size']:,} bytes ({info['size']/1024:.1f} KB) — {info['blocks']} XMODEM blocks")
    print(f"  MD5:       {info['md5']}", end="")
    if info["is_original"]:
        print(green("  ✓ matches stock ORIGINAL"))
    elif is_default:
        print(red("  ✗ stock file modified! (expected " + ORIGINAL_MD5 + ")"))
    else:
        print(grey("  (custom build)"))
    print(f"  Tag:       {info['tag']}")
    print(f"  Type byte: 0x{info['type_byte']:02X}", end="")
    if info["is_meter"]:
        print(green("  ✓ METER"))
    else:
        print(red(f"  ✗ NOT METER (must be 0x01, refused)"))
    print(f"  Version:   {info['version']!r}")
    print(f"  0xFF tail: {info['padding']} bytes")
    print()


def show_warnings(is_custom: bool) -> None:
    print(yellow("  ┌─ Pre-flight checklist ─────────────────────────────────────┐"))
    print(yellow("  │  • Battery > 20% (app refuses below)                       │"))
    print(yellow("  │  • Scooter switched ON, not riding (speed = 0)             │"))
    print(yellow("  │  • No other BLE clients (close Navee app etc.)             │"))
    print(yellow("  │  • Do NOT power-cycle during the ~35s transfer             │"))
    print(yellow("  └────────────────────────────────────────────────────────────┘"))
    if is_custom:
        print()
        print(yellow("  ⚠  Custom firmware. The dashboard validates the firmware after"))
        print(yellow("     all blocks are received; modified images may be rejected at"))
        print(yellow("     the bootloader stage (you'll see all 1080 ACKs followed by"))
        print(yellow("     no `rsq dfu_ok`). Stock firmware then remains active."))
    print()


def confirm() -> bool:
    answer = input(bold(f"  Type {green('YES')} to proceed (anything else aborts): "))
    return answer.strip() == "YES"


def main() -> int:
    p = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    p.add_argument("firmware", nargs="?", default=None,
                   help=f"path to a METER .bin (default: {DEFAULT_FW.name})")
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

    fw_path = Path(args.firmware) if args.firmware else DEFAULT_FW
    is_default = (args.firmware is None)

    # Resolve relative paths against firmware dir if not absolute
    if not fw_path.is_absolute() and not fw_path.exists():
        alt = FW_DIR / fw_path.name
        if alt.exists():
            fw_path = alt

    info = analyze(fw_path)
    if info is None:
        return 2

    show_summary(info, is_default)

    if not info["is_meter"]:
        print(red("  Refusing to flash: file is not a METER firmware (type byte != 0x01)."))
        print(red("  This tool only flashes meter/dashboard firmware."))
        print(red("  For BLDC firmware, use flash_de_stock.py (won't work via BLE — see ANALYSIS.md)."))
        return 2

    if is_default and not info["is_original"]:
        print(red("  Refusing to flash: default file MD5 mismatch (file modified)."))
        print(red("  Restore the original or pass an explicit firmware path."))
        return 2

    if args.dry_run:
        print(yellow("  [DRY RUN] Would invoke:"))
        print(f"    python3 {OTA_FLASHER.name} \\")
        print(f"      {fw_path}")
        if args.device_id:
            print(f"      --device-id {args.device_id}")
        print()
        print(green("  Dry run complete — no BLE activity, no flash performed."))
        print()
        return 0

    show_warnings(is_custom=not info["is_original"])

    if not args.yes and not confirm():
        print(red("\n  Aborted.\n"))
        return 1
    print()

    cmd = [sys.executable, str(OTA_FLASHER), str(fw_path)]
    if args.device_id:
        cmd += ["--device-id", args.device_id]

    print(cyan("  ─── ota_flasher.py output below ───"))
    print()
    sys.stdout.flush()

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
        print(green(bold("  ✓ Meter firmware flash completed.")))
        print()
        if info["is_original"]:
            print("  Stock firmware was already on the dashboard; if the bootloader")
            print("  responds with `rsq dfu_ok`, it is committed and the dashboard")
            print("  reboots. Otherwise the existing image stays active.")
        else:
            print("  Custom firmware: check whether `rsq dfu_ok` was received.")
            print("  If not, the bootloader rejected the image at validation;")
            print("  the previously installed firmware remains active.")
        print()
        print("  Power-cycle and verify:")
        print(f"    python3 {OTA_FLASHER.name} --read-info")
    else:
        print(red(bold(f"  ✗ Flash failed (exit code {result.returncode}).")))
        print()
        print("  See ota_flash_log.json for details.")
    print()
    return result.returncode


if __name__ == "__main__":
    sys.exit(main())

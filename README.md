# Navee ST3 Pro — Reverse Engineering Archive

Research record and tooling for the **Navee ST3 Pro** e-scooter (PID 23452, DE
market, 22 km/h). The original goal was a software-based removal of the speed
limit. **It is not feasible** in this firmware version — see
[`docs/FAILED.md`](docs/FAILED.md) for the empirical record of what was tried
and where each path is blocked.

This repository is published as a reference for anyone continuing the work
(physical controller swap, SWD via ST-Link) and as a complete protocol
description of the Navee BLE / internal UART stack.

## What's here

- **Android app** — independent BLE controller (Kotlin / Compose). Reads
  telemetry, sends speed/mode commands, includes a manual speed slider that
  exposes the same BLE command (`0x6E`) the official app uses behind a
  PID-restricted UI. Does not bypass the firmware-internal cap.
- **Python tooling** — firmware grabber, BLE OTA flasher (works for stock
  meter FW), patcher (correct algorithm; OTA delivery blocked by a 2nd
  validator), Ghidra automation, UART sniffers, ESC scanners.
- **Arduino sketches** — UART MitM for the Yellow wire (Dashboard → Controller),
  bootloader-entry probes, USB-to-Yellow bridge, dashboard replacement.
- **Docs** — full protocol reference, hardware map, LKS32MC081 datasheet
  extract, post-mortem.

## Why software unlock fails

The 22 km/h limit is enforced inside the BLDC motor controller (LKS32MC081C8T8)
firmware, gated by region byte `0xCF` at offset `0x0011`. Patching the byte is
trivial; delivering the patched binary is not:

- BLE OTA `dfu_start 2` has no handler in the dashboard FW (36+ NAK sessions).
- The dashboard does not relay XMODEM blocks to the controller on any wire.
- The LKS32MC081 has no UART ISP bootloader — flash programming is SWD-only.
- The meter OTA path works for stock FW but a second validator silently rejects
  any modification, even with correctly recomputed SHA-256.

Realistic remaining paths are physical only: SWD via ST-Link v2 (~10 €, blocker
is locating SWD pads on the epoxy-potted ESC PCB) or a Global-variant controller
swap (~30–50 €). See [`docs/FAILED.md`](docs/FAILED.md).

## Layout

```
android/                   Custom controller app (Kotlin / Jetpack Compose)
docs/                      Protocol, hardware, datasheet, post-mortem
reverse-engineering/       Decompiled APK + analysis notes
tools/                     Python tools (OTA, patching, Ghidra)
tools/arduino/             UART MitM, bootloader probes, USB bridge
tools/firmware/            Stock firmware dumps
tools/sigrok_decoders/     PulseView decoders
```

## Documentation

- [`docs/FAILED.md`](docs/FAILED.md) — research post-mortem (start here)
- [`docs/HARDWARE.md`](docs/HARDWARE.md) — MCUs, PCB, cable pinout, flash layout
- [`docs/PROTOCOL.md`](docs/PROTOCOL.md) — BLE + internal UART protocol
- [`docs/LKS32MC081.md`](docs/LKS32MC081.md) — datasheet facts (SWD, protection)

## Build

### Android app
```bash
cd android/
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Python tools
```bash
pip3 install --user --break-system-packages bleak pyserial capstone pyghidra
python3 tools/ota_flasher.py --read-info     # works
python3 tools/flash_meter.py                  # works for stock meter FW
python3 tools/patch_firmware.py firmware.bin  # correct algorithm; OTA-rejected
```

## Safety

Do **not** connect the Red (53 V battery) or Blue (52 V dashboard supply) wires
to any MCU or USB adapter — instant destruction. Yellow (3.8 V idle) requires
a level shifter for 3.3 V tools. See [`docs/HARDWARE.md`](docs/HARDWARE.md).

## License

MIT. See `LICENSE`.

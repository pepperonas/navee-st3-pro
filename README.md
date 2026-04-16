# Navee ST3 Pro — Reverse Engineering Toolkit

Reverse engineering, firmware analysis, and an independent Android controller app for
the **Navee ST3 Pro** e-scooter (PID 23452, DE market, 22 km/h).

**Primary research goal:** understand whether the DE 22 km/h speed limit can be removed
via software. Current honest answer: **not reliably** — the limit lives inside the BLDC
motor-controller firmware (region byte `0xCF`), and every software-only path tested so
far either fails at the dashboard-to-controller UART relay (which doesn't exist in this
FW version) or at an undocumented OTA-time validator that rejects modified firmware.

## Status snapshot

| Capability | State |
|---|---|
| Read BLDC/meter/BMS FW version via BLE | Works |
| Meter OTA flash of stock firmware | Works (1080/1080 blocks, `rsq dfu_ok`) |
| Meter OTA flash of patched firmware | Rejected silently (SHA-256 correct, 2nd validator in PATCH image) |
| BLDC OTA flash (any variant) | Always NAK on block 1 (36+ sessions) |
| SPI-direct flash of dashboard | Works (rtltool, commit `e4178ec`) |
| Dashboard-to-controller BLDC relay | Not present in this FW version |

See [`docs/STATUS.md`](docs/STATUS.md) for the full empirical record.

## Repository layout

```
android/                   Custom controller app (Kotlin / Jetpack Compose, min SDK 26)
docs/                      Protocol, hardware, status documentation (see below)
reverse-engineering/       Decompiled APK + analysis notes
tools/                     Python/shell tools (OTA flasher, patcher, Ghidra automation)
tools/firmware/            Stock firmware dumps (downloaded from Navee API)
tools/sigrok_decoders/     PulseView protocol decoders
```

## Documentation

- [`docs/HARDWARE.md`](docs/HARDWARE.md) — MCUs, PCB, cable pinout, flash layout
- [`docs/PROTOCOL.md`](docs/PROTOCOL.md) — BLE + internal UART protocol, command table
- [`docs/STATUS.md`](docs/STATUS.md) — empirical research status, what works, what fails
- [`docs/SECURE_ELEMENT.md`](docs/SECURE_ELEMENT.md) — Apple FMNA findings in dashboard FW
- [`CLAUDE.md`](CLAUDE.md) — concise working context (shared with AI assistants)

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
python3 tools/ota_flasher.py --read-info         # read device info
python3 tools/flash_meter.py                      # flash stock meter FW (verified)
python3 tools/header_crc_search.py                # verify BLDC header CRC algorithm
python3 tools/se_scan.py                          # scan dashboard FW for SE indicators
GHIDRA_INSTALL_DIR=~/ghidra/ghidra_12.0.4_PUBLIC python3 tools/ghidra_se_analyze.py
```

## Safety

Do **not** connect the Red (53 V battery) or Blue (52 V dashboard supply) wires to any
MCU or USB adapter — instant destruction. Yellow (3.8 V idle) requires a level shifter
for 3.3 V tools. See `docs/HARDWARE.md` for full cable reference.

## License

MIT. See `LICENSE`.

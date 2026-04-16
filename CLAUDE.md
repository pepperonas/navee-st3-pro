# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Navee ST3 Pro Scooter Toolkit — Reverse engineering, firmware analysis, and Android controller app for the Navee ST3 Pro e-scooter (PID 23452, DE market). The project documents the proprietary BLE and UART protocols, provides an independent controller app, and includes tools for firmware download, patching, OTA flashing, and hardware debugging.

**Primary goal:** Remove the 22 km/h speed limit enforced by the BLDC motor controller firmware (region byte `0xCF` = DE).

**Current status (April 2026):** Speed limit is hardcoded in the BLDC controller firmware (region byte `0xCF` @ offset `0x0011`). All software-only paths via BLE and UART are exhausted:
- Meter OTA with stock FW works (`rsq dfu_ok`), with patched FW is silently rejected after EOT (SHA-256 correct, an undocumented 2nd validator in the dashboard PATCH image blocks it).
- BLDC OTA via BLE: 36+ sessions, 0 ACKs — the dashboard FW has no `dfu_start 2` handler and no UART XMODEM relay to the controller.
- Dashboard contains an Apple FMNA (Find My) stack with crypto symbols (`fmna_*`, `fm_crypto_*`, `secp256r1`, `AES-256-GCM`) — likely HW Secure Element present but not yet physically identified.

Remaining paths: (1) decompile the PATCH image at `0x003000-0x00CFFF` to understand the OTA 2nd validator, (2) UART bootloader via TX0/RX0 or TX2/RX2 on the ESC board (LKS32MC081 ROM bootloader, not yet probed), (3) physical controller swap to Global variant. No SWD pads exist on the ESC board (epoxy potting).

See `docs/STATUS.md` for the full empirical record and `docs/SECURE_ELEMENT.md` for FMNA findings.

## Build Commands

### Android App
```bash
cd android/
./gradlew assembleDebug                                    # Debug APK (~16 MB)
./gradlew assembleRelease                                  # Release APK (~1.3 MB, ProGuard, unsigned)
adb install app/build/outputs/apk/debug/app-debug.apk     # Install on device
```

Sign release APK:
```bash
APKSIGNER=~/Library/Android/sdk/build-tools/35.0.0/apksigner
ZIPALIGN=~/Library/Android/sdk/build-tools/35.0.0/zipalign
$ZIPALIGN -p -f 4 app/build/outputs/apk/release/app-release-unsigned.apk /tmp/aligned.apk
$APKSIGNER sign --ks ~/.android/debug.keystore --ks-pass pass:android --ks-key-alias androiddebugkey --key-pass pass:android --out /tmp/signed.apk /tmp/aligned.apk
```

### Python Tools (no venv needed, requires `pyserial` and `bleak`)
```bash
python3 tools/firmware_grabber.py           # Download meter firmware from Navee API
python3 tools/firmware_grabber_bldc.py      # Download ALL firmware types (Google OAuth)
python3 tools/ota_flasher.py firmware.bin   # Flash firmware via BLE OTA
python3 tools/patch_firmware.py firmware.bin # Patch speed byte + recalculate SHA-256
python3 tools/esc_uart_scan.py              # Scan ESC board UART baudrates
python3 tools/uart_direct_flasher.py --detect  # Listen for XMODEM bootloader on UART
```

### Arduino Sketches (upload via Arduino IDE)
```
tools/arduino/navee_uart_mitm_yellow/    # MitM v2.4: intercept Yellow wire (0x51/0xAE protocol)
tools/arduino/navee_bootloader_probe/    # Probe all bootloader entry methods on Yellow+Green
tools/arduino/navee_uart_bridge/         # USB-to-Yellow UART bridge for Mac-based flashing
tools/arduino/navee_yellow_sniffer/      # Dashboard replacement: generate own 0x51 frames
```

No automated test suite — all tests are manual BLE/UART integration scripts.

## Architecture

### Android App Data Flow
```
Scooter ←BLE→ NaveeBleManager → ScooterViewModel (StateFlow) → DashboardScreen (Compose)
```

- `NaveeBleManager` handles scanning, GATT, notifications, and frame reassembly
- `NaveeProtocol` builds/parses binary frames — `data[0]` is always a version byte, payload starts at `data[1]`
- `ScooterViewModel` exposes `StateFlow<ScooterState>` + `StateFlow<ScooterTelemetry>`
- PID from BLE scan record bytes 6-8 determines speed options via `getMaxSpeedOptionsForPID()`
- Manual speed slider (5-60 km/h) sends BLE CMD `0x6E` — same as official app but with free value selection

### Hardware Architecture (two-wire full-duplex UART)
```
Phone ←BLE→ Dashboard (RTL8762C) ←UART→ Controller (MCU unknown, markings sanded)
                                   ↑              ↑
                              Yellow=RX       Green=TX
                              3.8V idle       4.12V idle
                              0x51/0xAE       0x61/0x9E + 0x64/0x9B
```

### Two UART Protocols (different on each wire!)

| Wire | Direction | Header/Footer | Frame Length | Key Bytes |
|------|-----------|---------------|-------------|-----------|
| Yellow | Dashboard→Controller | `0x51`/`0xAE` | 14 bytes | Byte 3=Mode, Byte 10=Speed Limit (0x16=22) |
| Green | Controller→Dashboard | `0x61`/`0x9E` + `0x64`/`0x9B` | 15/14/18 bytes | Frame A/B/C |

Checksum for both: `SUM(all bytes before checksum) & 0xFF`. Header + Footer always = `0xFF`.

### Speed Limit Architecture (in BLDC controller firmware)
Three layers, all inside the controller — UART bytes are telemetry only:
1. **Region byte** at firmware offset `0x0011`: `0xCF`=DE (22 km/h), `0xB7`=Global (30 km/h)
2. **PWM scaling table**: DE values 10-12% lower than Global
3. **Speed progression table**: identical in both, limit comes from PWM scaling

### Key Protocol Details
- **BLE Service UUID**: `0000d0ff-3c17-d293-8e48-14fe2e4da212`
- **Write Char**: `0000b002-...`, **Notify Char**: `0000b003-...`
- **BLE Frame**: `[55 AA] [Flag] [CMD] [LEN] [DATA...] [Checksum] [FE FD]`
- **Auth**: AES-128-ECB, 5 keys (`NaveeAUTHKEY001!` to `005!`), device ID from BT HCI snoop
- **DFU**: `dfu_start X` → `ble_rand` → `ble_key` → XMODEM (128B blocks, CRC-16) → EOT → `rsq dfu_ok`
- **Navee API**: `POST https://lj.naveetech.com/tundra-api/vehicle/modelSoftware`

### ESC Board Connectors (from physical board inspection)
```
Far left:   12V-Y · ACC · TX2 · RX2 · GND     ← Secondary UART, possibly bootloader
Center:     WC · 12V · RT · LT / K · GND · B+
Center-R:   TX · GND · 12V / RX · GND · 12V   ← UART1
Far right:  ACC · TX0 · RX0 · TM2              ← Primary UART, bootloader candidate
```

## Critical Safety Rules
- **NEVER** connect Red (53V) or Blue (52V) wires to any MCU/adapter — instant destruction
- **NEVER** work on dashboard while scooter is powered — short circuit risk (learned the hard way)
- Yellow wire at 3.8V — CP2102 (3.3V) is too low, Arduino (5V) works with current limiting
- Always disconnect battery before making electrical connections to dashboard/wiring harness
- RTL8762C download mode requires **3.3V logic level only** (not 5V)

## Key Files

### Documentation (4 files, minimal set)
- `docs/HARDWARE.md` — MCUs, PCB, cable pinout, flash layout
- `docs/PROTOCOL.md` — BLE + internal UART protocol, command table
- `docs/STATUS.md` — empirical research status (verified pass/fail matrix)
- `docs/SECURE_ELEMENT.md` — Apple FMNA findings in dashboard FW
- `reverse-engineering/APK_ANALYSIS.md` — decompiled APK reference

### Firmware Files (`tools/firmware/`)
- DE BLDC: `navee_bldc_v0.0.1.5_ST3_PRO_DE_22km_h,_pid=23452.bin` (53,376 bytes)
- Global BLDC: `navee_bldc_v0.0.1.1_ST3_Global,_pid=24012.bin` (47,232 bytes)
- Region byte diff: offset `0x0011`, `0xCF` (DE) vs `0xB7` (Global)

## Android Requirements
- Min SDK 26, Target SDK 35, Java 17, Kotlin 2.1.0, Compose BOM 2024.12.01
- Release builds use ProGuard minification
- Signing keystore: `~/.android/debug.keystore` (debug key, pass: `android`)

## Attack Vector Summary

| # | Approach | Result |
|---|----------|--------|
| 1 | BLE commands (`0x6E` max speed, `0x6B` custom limit) | ACKed, controller still caps at 22 km/h |
| 2 | UART MitM (Green wire) | Controller ignores manipulated frames |
| 3 | Meter OTA stock firmware | Works (1080/1080 blocks, `rsq dfu_ok`) — proves OTA path functional |
| 4 | Meter OTA patched firmware (correct SHA-256) | Silent rejection after EOT — 2nd validator in PATCH image blocks it |
| 5 | SPI-flash direct patch (rtltool) | Write verified via read-back (commit `e4178ec`) — boot validator only does SHA-256 |
| 6 | BLDC OTA (`dfu_start 2`, type=0x02) | NAK on block 1 in 36+ sessions — no relay code in dashboard FW |
| 7 | BLDC-as-meter OTA (type=0x01 header) | 369/369 blocks ACKed, rejected at end; written to meter flash, not BLDC |
| 8 | Yellow wire MitM + dashboard replacement | Controller continues to enforce internal limit |
| 9 | ESC board UART scan (TX0/RX0, TX2/RX2) | **Pending — LKS32MC081 ROM bootloader probe** |
| 10 | Physical BLDC controller swap (Global variant) | Community-verified, not yet attempted here |

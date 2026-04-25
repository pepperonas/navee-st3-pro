# CLAUDE.md

Working context for the Navee ST3 Pro reverse-engineering archive.

## Project state

Research-complete archive for the Navee ST3 Pro (PID 23452, DE, 22 km/h).
Software-based removal of the speed limit was the goal — it is not feasible in
this firmware version. See `docs/FAILED.md` for the post-mortem; `docs/HARDWARE.md`
and `docs/PROTOCOL.md` are the durable technical reference.

The 22 km/h cap is enforced inside the BLDC controller firmware (region byte
`0xCF` at offset `0x0011`). Software paths to deliver a patched binary are all
blocked:

- BLE OTA `dfu_start 2` → no handler in dashboard FW (36+ NAK sessions)
- Dashboard does not relay XMODEM to controller on any wire
- LKS32MC081 has no UART ISP bootloader (datasheet-confirmed; SWD-only)
- Meter OTA: stock works, patched is silently rejected after EOT by a 2nd validator

Remaining paths are physical: SWD via ST-Link v2 or Global-variant controller swap.

## Build

### Android app
```bash
cd android/
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```

Sign release APK with `~/.android/debug.keystore` (pass: `android`).

### Python tools (`pyserial`, `bleak`, optional `pyghidra`)
```bash
python3 tools/ota_flasher.py --read-info        # works
python3 tools/flash_meter.py                     # stock meter FW only
python3 tools/patch_firmware.py firmware.bin    # patch + SHA-256 (correct algo, OTA-rejected)
python3 tools/firmware_grabber.py                # download from Navee API
```

### Arduino sketches (Arduino IDE)
- `tools/arduino/navee_uart_mitm_yellow/` — Yellow-wire MitM
- `tools/arduino/navee_uart_bridge/` — USB-to-Yellow bridge
- `tools/arduino/navee_yellow_sniffer/`, `navee_bootloader_probe/`

No automated tests — all are manual BLE/UART integration scripts.

## Architecture

### BLE
- Service `0000d0ff-3c17-d293-8e48-14fe2e4da212`
- Write `0000b002-...`, Notify `0000b003-...`
- Frame: `[55 AA] [Flag] [CMD] [LEN] [DATA] [SUM] [FE FD]`
- Auth: AES-128-ECB, 5 keys (`NaveeAUTHKEY001!` … `005!`)
- DFU: `dfu_start X` → `ble_rand` → `ble_key` → XMODEM(128 B + CRC-16) → EOT → `rsq dfu_ok`

### Internal UART (Dashboard ↔ Controller)
19200 8N1, two wires, each unidirectional:

| Wire | Direction | Header/Footer | Length | Notes |
|---|---|---|---|---|
| Yellow | Dash → Ctrl | `0x51`/`0xAE` | 14 B | Byte 10 = speed limit |
| Green | Ctrl → Dash | `0x61`/`0x9E` + `0x64`/`0x9B` | 15/14/18 B | A/B/C frame variants |

Checksum: `SUM(prev) & 0xFF`. Header XOR Footer = `0xFF`.

### Speed-limit gating (controller-side)
1. Region byte `0x0011`: `0xCF`=DE / `0xB7`=Global
2. PWM scaling table (DE 10–12 % lower)
3. Speed progression table (identical in both)

UART speed bytes are telemetry-only; the controller ignores manipulated values.

## Hardware

- **Dashboard:** Realtek RTL8762C BLE SoC (RB8762-35A1), 512 KB SPI flash @ `0x00800000`
- **Controller:** LKS32MC081C8T8 (Cortex-M0, 64 KB flash, TQFP48). SWD on pins 47/48, RSTN on pin 2. No hardware RDP.
- **Cable:** 5-wire — Black GND, Red 53 V battery, Blue 52 V supply, Yellow Ctrl-RX (3.8 V), Green Ctrl-TX (4.12 V)

## Safety

- **NEVER** connect Red (53 V) or Blue (52 V) to any MCU/adapter — instant destruction
- **NEVER** work on the dashboard while powered
- Yellow at 3.8 V — CP2102 (3.3 V) needs level shifting; Arduino (5 V) works with current limit
- RTL8762C download mode is 3.3 V logic only

## Key files

- `docs/FAILED.md` — research post-mortem (entry point)
- `docs/HARDWARE.md` — MCUs, PCB, cable, flash layout, FMNA notes
- `docs/PROTOCOL.md` — full BLE + UART protocol
- `docs/LKS32MC081.md` — datasheet facts (SWD, protection, programming)
- `reverse-engineering/APK_ANALYSIS.md` — decompiled APK reference
- `tools/firmware/navee_bldc_v0.0.1.5_ST3_PRO_DE_22km_h,_pid=23452.bin` — DE BLDC stock
- `tools/firmware/navee_bldc_v0.0.1.1_ST3_Global,_pid=24012.bin` — Global BLDC stock

## Android specifics

Min SDK 26, Target SDK 35, Java 17, Kotlin 2.1.0, Compose BOM 2024.12.01, ProGuard
on release. PID from BLE scan record bytes 6–8 selects speed options via
`getMaxSpeedOptionsForPID()`. Manual slider sends BLE `0x6E` directly.

## Cloud API

`POST https://lj.naveetech.com/tundra-api/vehicle/modelSoftware` — returns firmware
URLs (meterList, bldcList, bmsList, screenList). JSESSION cookie auth, no signed
requests.

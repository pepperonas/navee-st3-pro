# Navee ST3 Pro — Reverse Engineering & Custom Firmware

<p align="center">
  <img src="docs/banner.png" alt="Navee ST3 Pro Scooter Toolkit" width="100%">
</p>

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](android/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1-purple.svg)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Jetpack-Compose-4285F4.svg)]()
[![BLE](https://img.shields.io/badge/BLE-Custom%20Protocol-informational.svg)](docs/PROTOCOL.md)
[![MCU](https://img.shields.io/badge/MCU-RTL8762C-FF6F00.svg)](docs/HARDWARE.md)
[![Firmware](https://img.shields.io/badge/Firmware-1--Byte%20Patch-00C853.svg)](docs/REVERSE_ENGINEERING.md#der-patch-1-byte)
[![Auth](https://img.shields.io/badge/Auth-AES--128--ECB-9C27B0.svg)](docs/AUTHENTICATION.md)

---

Reverse Engineering, Firmware-Analyse und Android Controller-App for the **Navee ST3 Pro** E-Scooter (PID 23452, DE market).

This project has fully reverse-engineered the proprietary BLE protocol, developed an independent controller app, analyzed the meter firmware with Ghidra, built a working OTA flasher, and identified a **1-byte firmware patch** that unlocks custom speed settings. The patch has been verified in disassembly but **cannot be installed via OTA** due to the bootloader's cryptographic integrity check.

**Status: Work in Progress** — Speed unlock not yet achieved. Next step: direct SPI flash programming via rtltool.

---

## Attack Vectors

| # | Approach | Result |
|---|----------|--------|
| 1 | BLE CMD `0x6E` (Max Speed) | :x: ACK'd but ignored |
| 2 | UART MitM (Arduino) | :x: Controller ignores manipulated frames |
| 3 | **Firmware Patch (Ghidra)** | :white_check_mark: **1-byte NOP enables custom speed mode** |
| 4 | OTA Flash (BLE XMODEM) | :warning: Transfer OK, bootloader rejects any modification |
| 5 | **SPI Flash Direct (rtltool)** | :hourglass_flowing_sand: **Next step** — bypasses bootloader |
| 6 | Controller Swap (AliExpress) | :white_check_mark: Proven by community |

> Full analysis: [`docs/ATTACK_VECTORS.md`](docs/ATTACK_VECTORS.md)

---

## Hardware

**Dashboard MCU:** Realtek RTL8762C BLE SoC (Module RB8762-35A1)
- ARM Cortex-M4F, integrated BLE radio
- External SPI flash (firmware stored here)
- UART download mode via P0_3 pin (no SWD needed)

**Internal wiring:** 5-wire cable (GND, 53V battery, 52V dashboard, unknown, UART 19200 baud)

> Full details: [`docs/HARDWARE.md`](docs/HARDWARE.md)

---

## The Patch

The meter firmware contains a `lift_speed_limit` function (FUN_0800ad02):

```c
if (sys_stc[0x4a] == 0x02) {                // lift_speed_limit flag
    return sys_stc[0x47] * 10 + 5;           // Custom Speed (BLE CMD 0x6E)
} else {
    return PID_DEFAULT_TABLE[area_code];      // 22.5 km/h (Germany)
}
```

**1-byte patch** at file offset `0xF848`: `02 D9` (BLS) to `00 BF` (NOP)
- Forces the code to always use the custom speed path
- Speed then settable via BLE CMD `0x6E [0x01, km/h]`

> Full analysis: [`docs/REVERSE_ENGINEERING.md`](docs/REVERSE_ENGINEERING.md)

---

## OTA Flasher

The OTA flasher implements the complete DFU protocol reverse-engineered from the official Navee APK:

```
Step 1: BLE Connect + AES-128-ECB Auth
Step 2: "down dfu_start 1\r"      -> "ok\r"
Step 3: "down ble_rand\r"         -> Status 0x00 + 16-byte cipher
Step 4: XOR decrypt with AES Key  -> "down ble_key <decrypted>\r" -> "ok\r"
Step 5: Wait for 0x43 ('C')       -> XMODEM Ready
Step 6: 1080 x 128-byte blocks    -> SOH + Seq + ~Seq + Data + CRC-16
Step 7: EOT (0x04)                -> "rsq dfu_ok\r"
```

**Verified:** 1080/1080 blocks, 0 errors, ~34s, 4049 bytes/s. Original firmware installs successfully (2/2). Patched firmware is rejected by bootloader integrity check (0/10 attempts with various checksum compensations).

---

## Android Controller App

- BLE auto-connect, AES-128 auth, real-time telemetry
- Controls: Lock, headlight, cruise, TCS, turn sound, ECO/SPORT, ERS
- Material Design 3 dark theme, keep-screen-on

---

## Project Structure

```
navee/
├── android/                     <- Controller App (Kotlin/Compose)
│   └── app/src/main/java/de/pepperonas/navee/
│       ├── ble/                 <- BLE Manager, Protocol, Auth
│       ├── ui/                  <- Dashboard UI
│       └── viewmodel/          <- State Management
├── docs/
│   ├── PROTOCOL.md              <- BLE protocol (commands, status, telemetry, DFU)
│   ├── AUTHENTICATION.md        <- AES-128 auth flow
│   ├── REVERSE_ENGINEERING.md   <- Ghidra analysis, patch details, OTA attempts
│   ├── HARDWARE.md              <- Wiring, MCU identification, flash layout
│   ├── INTERNAL_UART_PROTOCOL.md <- Dashboard <-> controller UART protocol
│   ├── ATTACK_VECTORS.md        <- All attempted approaches with honest results
│   └── SWD_FLASH_GUIDE.md       <- Direct flash guide (RTL8762C/rtltool)
├── tools/
│   ├── firmware/
│   │   ├── navee_meter_v2.0.3.1_ORIGINAL.bin
│   │   └── navee_meter_v2.0.3.1_PATCHED.bin
│   ├── firmware_grabber.py      <- Download firmware from Navee API
│   ├── ota_flasher.py           <- BLE OTA flasher (macOS/bleak)
│   └── ghidra_analysis/         <- 10 Ghidra headless scripts
└── archive/                     <- UART MitM (failed approach #2)
    ├── INTERNAL_UART_PROTOCOL.md
    ├── UART_MITM_GUIDE.md
    └── navee_uart_mitm_nano/    <- Arduino MitM sketch
```

---

## Quick Start

### Build & install the Android app

```bash
cd android/
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Download firmware from Navee servers

```bash
pip3 install requests
python3 tools/firmware_grabber.py
```

### OTA flash (macOS — original firmware only)

```bash
pip3 install bleak pycryptodome
cd tools/
python3 ota_flasher.py --read-info
python3 ota_flasher.py firmware/navee_meter_v2.0.3.1_ORIGINAL.bin
```

> Note: Only the unmodified original firmware can be installed via OTA.
> The bootloader rejects any modified binary. See [docs/ATTACK_VECTORS.md](docs/ATTACK_VECTORS.md).

---

## Legal Notice

> Modifying the speed limit of an e-scooter may void its type approval (ABE) and insurance coverage. Operating a modified e-scooter on public roads may be illegal in your jurisdiction. This project is for research and protocol documentation purposes only. Use at your own risk and only on private property.

---

## Author

**Martin Pfeffer** — [celox.io](https://celox.io) · [GitHub](https://github.com/pepperonas)

## License

[MIT](LICENSE)

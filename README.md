# Navee ST3 Pro — Custom Firmware & Controller App

<p align="center">
  <img src="docs/banner.png" alt="Navee ST3 Pro Scooter Toolkit" width="100%">
</p>

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](android/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1-purple.svg)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Jetpack-Compose-4285F4.svg)]()
[![BLE](https://img.shields.io/badge/BLE-Custom%20Protocol-informational.svg)](docs/PROTOCOL.md)
[![Firmware](https://img.shields.io/badge/Firmware-1--Byte%20Patch-00C853.svg)](docs/REVERSE_ENGINEERING.md#der-patch-1-byte)
[![Ghidra](https://img.shields.io/badge/Ghidra-ARM%20Cortex--M-FFA726.svg)](tools/ghidra_analysis/)
[![Auth](https://img.shields.io/badge/Auth-AES--128--ECB-9C27B0.svg)](docs/AUTHENTICATION.md)
[![Made with](https://img.shields.io/badge/Made%20with-%E2%9D%A4-red.svg)]()

---

Reverse Engineering, Custom Firmware und Android Controller-App für den **Navee ST3 Pro** E-Scooter.

Dieses Projekt hat das proprietäre BLE-Protokoll vollständig reverse-engineered, eine unabhängige Controller-App entwickelt und die Meter-Firmware (Dashboard) mit Ghidra analysiert. Ergebnis: ein **1-Byte Firmware-Patch** der das `lift_speed_limit`-Flag aktiviert und benutzerdefinierte Geschwindigkeitswerte über BLE CMD `0x6E` ermöglicht.

---

## Highlights

### 1-Byte Firmware-Patch
- **File Offset `0xF848`**: `02 D9` (bls) → `00 BF` (NOP)
- Aktiviert das eingebaute `lift_speed_limit`-Flag im Dashboard-Controller
- Geschwindigkeit danach frei setzbar via BLE CMD `0x6E [0x01, km/h]`
- Rollback jederzeit durch Flashen der Original-Firmware

### Android Controller-App
- BLE Auto-Connect, AES-128 Auth, Echtzeit-Telemetrie
- Steuerung: Sperre, Licht, Tempomat, TCS, Blinker-Ton, ECO/SPORT, ERS
- Material Design 3 Dark Theme, Keep-Screen-On

### Reverse Engineering Chronologie
| # | Ansatz | Ergebnis |
|---|--------|----------|
| 1 | BLE CMD `0x6E` (Max Speed) | ❌ ACK'd aber ignoriert |
| 2 | UART MitM (Arduino Nano) | ❌ Controller ignoriert externe Frame-Manipulation |
| 3 | **Firmware-Patch (Ghidra)** | ✅ **1-Byte NOP aktiviert Custom-Speed-Modus** |

---

## Projektstruktur

```
navee/
├── android/                     ← Controller-App (Kotlin/Compose)
│   └── app/src/main/java/de/pepperonas/navee/
│       ├── ble/                 ← BLE Manager, Protokoll, Auth
│       ├── ui/                  ← Dashboard UI
│       └── viewmodel/           ← State Management
├── docs/
│   ├── PROTOCOL.md              ← BLE-Protokoll (Commands, Status, Telemetrie, DFU)
│   ├── AUTHENTICATION.md        ← AES-128 Auth-Flow
│   └── REVERSE_ENGINEERING.md   ← Ghidra-Analyse, Patch-Details, alle 3 Ansätze
├── tools/
│   ├── firmware/
│   │   ├── navee_meter_v2.0.3.1_ORIGINAL.bin  ← Original-Firmware (135 KB)
│   │   └── navee_meter_v2.0.3.1_PATCHED.bin   ← Gepatchte Firmware (1 Byte Diff)
│   ├── firmware_grabber.py      ← Firmware von Navee-API herunterladen
│   ├── ota_flasher.py           ← BLE OTA Flasher (macOS/bleak)
│   └── ghidra_analysis/         ← Ghidra Headless Scripts
└── archive/                     ← UART MitM (gescheiterter Ansatz 2)
```

---

## Schnellstart

### App bauen & installieren

```bash
cd android/
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Firmware flashen (macOS)

```bash
# 1. Nur Info lesen (kein Risiko)
python3 tools/ota_flasher.py --read-info

# 2. Dry-Run (simuliert Flash)
python3 tools/ota_flasher.py --dry-run --firmware tools/firmware/navee_meter_v2.0.3.1_ORIGINAL.bin

# 3. Original flashen (OTA-Test)
python3 tools/ota_flasher.py --firmware tools/firmware/navee_meter_v2.0.3.1_ORIGINAL.bin

# 4. Gepatchte Firmware flashen
python3 tools/ota_flasher.py --firmware tools/firmware/navee_meter_v2.0.3.1_PATCHED.bin

# 5. Rollback
python3 tools/ota_flasher.py --firmware tools/firmware/navee_meter_v2.0.3.1_ORIGINAL.bin
```

### Firmware herunterladen

```bash
python3 tools/firmware_grabber.py
```

---

## Technische Details

### Der Patch im Detail

Die Meter-Firmware enthält eine `lift_speed_limit`-Funktion (FUN_0800ad02):

```c
if (sys_stc[0x4a] == 0x02) {                // lift_speed_limit Flag
    return sys_stc[0x47] * 10 + 5;           // → Custom Speed!
} else {
    return PID_DEFAULT_TABLE[area_code];      // → 22.5 km/h (DE)
}
```

Das Flag wird bei File Offset `0xF848` bedingt gesetzt. Der Patch (NOP statt bls) sorgt dafür, dass das Flag **immer** auf Custom steht. Danach bestimmt `sys_stc[0x47]` — setzbar via BLE — die Geschwindigkeit.

→ Vollständige Analyse: [`docs/REVERSE_ENGINEERING.md`](docs/REVERSE_ENGINEERING.md#ghidra-analyse-ergebnisse-detailliert)

### BLE-Protokoll

| Element | Wert |
|---------|------|
| Service UUID | `0000d0ff-3c17-d293-8e48-14fe2e4da212` |
| Frame-Format | `[55 AA] [Flag] [CMD] [LEN] [DATA] [Checksum] [FE FD]` |
| Auth | AES-128-ECB, 5 Schlüssel, Device-ID aus BT-Capture |
| DFU | XMODEM, 128-Byte Blöcke, CRC-16 |

→ Vollständige Referenz: [`docs/PROTOCOL.md`](docs/PROTOCOL.md)

---

## Rechtlicher Hinweis

> Geschwindigkeitsänderungen am E-Scooter können zum Erlöschen der Betriebserlaubnis führen. Dieses Projekt dient der Forschung und Protokoll-Dokumentation. Nutzung auf eigene Verantwortung.

---

## Autor

**Martin Pfeffer** — [celox.io](https://celox.io) · [GitHub](https://github.com/pepperonas)

## Lizenz

[MIT](LICENSE)

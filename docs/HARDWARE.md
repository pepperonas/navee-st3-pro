# Hardware

## Dashboard

| Component | Value | Source |
|---|---|---|
| Main MCU | Realtek RTL8762C (BLE SoC) | FW strings, pyocd ID |
| Module marking | RB8762-35A1 | Physical inspection |
| SPI flash | 512 KB, memory-mapped @ `0x00800000` | Full dump verified (524 288 B) |
| Crypto coprocessor | Likely present, not physically identified | Apple FMNA code in FW requires HW SE |
| Notable secondary buses | `0x4000F000` (28 literal-pool refs, SPI master), `0x40002000` (15 refs, I2C0/UART0) | Ghidra `se_scan.py` |

## Motor controller (ESC)

| Component | Value | Source |
|---|---|---|
| MCU | LKS32MC081 (LinkSemi, ARM Cortex-M0) | Commit `29783b4`, FW header byte layout |
| Flash | 64 KB internal | LKS datasheet |
| SWD | **No pads accessible**, epoxy potting | Physical inspection |

## Dashboard ↔ Controller cable (5-wire)

| Color | Function | Idle voltage | Notes |
|---|---|---|---|
| Black | GND | 0 V | |
| Red | Battery (53 V) | 53.04 V | **Do NOT connect to MCU** |
| Blue | Dashboard supply | 52.2 V | **Do NOT connect to MCU** |
| Yellow | Controller RX (dashboard → controller) | 3.8 V | Level-shifter required for 3.3 V tools |
| Green | Controller TX (controller → dashboard) | 4.12 V | CP2102 RX tolerant |

Protocol: 19200 8N1, full-duplex, two independent wires (each wire is unidirectional).

## ESC board connectors (physical inspection)

```
Far left:   12V-Y · ACC · TX2 · RX2 · GND
Center:     WC · 12V · RT · LT / K · GND · B+
Center-R:   TX · GND · 12V / RX · GND · 12V   (UART1 — routes to cable harness)
Far right:  ACC · TX0 · RX0 · TM2              (Primary UART, bootloader candidate)
```

`TX0/RX0` and `TX2/RX2` are the two candidate UART bootloader ports — not yet tested.

## Dashboard flash layout (bee2 dual-bank)

```
File off    MEM addr        Contents
──────────────────────────────────────────────────────────
0x003000   0x00803000      PATCH image (bee2 id 0x2792, 40 KB)
0x00E000   0x0080E000      APP Bank A header
0x00E174   0x0080E174      SHA-256 hash (32 B)
0x00E400   0x0080E400      APP Bank A code (Reset_Handler @ 0x0080E590)
0x02F69C   0x0082F69C      End of APP Bank A
0x044000   0x00844000      APP Bank B (OTA staging)
0x065700   0x00865700      End of Bank B
```

SHA-256 regions covered: `header[12..372)`, `[404..752)`, `[1008..1024+payload_len)`. The `[372..404]` SHA field itself and `[752..1008]` are excluded.

Pointers in code appear both as `0x008XXXXX` (uncached XIP) and `0x088XXXXX` (cached XIP) — both resolve to the same flash data.

## RTL8762C recovery access

`rtltool` (https://github.com/wuwbobo2021/rtltool) can read/write the SPI flash via UART download mode. Requires Arduino UNO on 3.3 V + CP2102 bridge. Commit `e4178ec` documents a verified full flash dump + sector write round-trip.

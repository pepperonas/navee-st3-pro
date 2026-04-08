# BLDC Controller — SWD Flash Guide

## Overview

Based on research from robocoffee.de (Brightway/NAVEE scooter reverse engineering), the BLDC motor controller MCU can be flashed directly via SWD debug interface, bypassing all OTA restrictions.

## MCU Identification

### Confirmed for Brightway 3 Lite
- **Chip:** LKS32MC081C8T8 (Linkosemi)
- **Core:** ARM Cortex-M0 (ARMv6-M)
- **Flash:** 64KB
- **RAM:** 8KB
- **Read Protection:** NONE — SWD is open!

### Our ST3 Pro D (to be confirmed)
- **Manufacturer ID in firmware:** `SZMC-ES-ZM-02831` (at offset 0x90)
- **Vector Table SP:** 0x20001C08 (Global), 0x20003E70 (DE)
  - Global SP suggests 8KB RAM (LKS32MC081 compatible)
  - DE SP suggests larger RAM (possible different/newer chip)
- **Firmware size:** 47KB (Global), 52KB (DE) — both fit in 64KB flash
- **SWD pads:** Expected on controller board (needs physical inspection)

### Memory Map (LKS32MC081)
| Region | Start | End | Size |
|--------|-------|-----|------|
| Flash (NVR) | 0x00000000 | 0x000003FF | 1KB |
| Flash (Main) | 0x00000000 | 0x0000FFFF | 64KB |
| RAM | 0x20000000 | 0x20001FFF | 8KB |
| Peripherals | 0x40000000 | — | — |

## Firmware Layout

```
Navee BLDC Firmware File (.bin):
┌──────────────────┐ 0x0000
│ Navee OTA Header │ 21 bytes (model, type, version, size, checksum)
├──────────────────┤ 0x0015
│ Config/Metadata  │ "SZMC-ES-ZM-02831" at 0x90
│ (mostly 0xFF)    │
├──────────────────┤ 0x0100
│ ARM Vector Table │ SP=0x20001C08, Reset=0x000000D5
│ Application Code │ Motor control firmware
│ Speed tables     │ PWM scaling, region config
│ Country codes    │ "CNESDEITAUEUUSJPFR..."
└──────────────────┘ 0xB880 (47232 bytes)
```

### Vector Table (at file offset 0x0100, flash address 0x0100)
| Vector | Address | Function |
|--------|---------|----------|
| Initial SP | 0x20001C08 | Top of stack (7KB into 8KB RAM) |
| Reset | 0x000000D5 | Reset handler (early boot code at 0xD4) |
| NMI | 0x0000448D | Non-maskable interrupt |
| HardFault | 0x000000DB | Hard fault handler |
| SVCall | 0x00004629 | Supervisor call |
| PendSV | 0x000000DF | Pending supervisor |
| SysTick | 0x0000462D | System tick timer |

## Hardware Required

- **ST-Link V2 clone** (~5€ Amazon/AliExpress)
- **4x Dupont cables** (female-female)
- **Soldering iron** (for connecting to SWD pads on controller board)

## SWD Connection

```
ST-Link V2              Controller Board
  SWDIO  ──────────────  SWDIO pad
  SWCLK  ──────────────  SWCLK pad
  GND    ──────────────  GND
  3.3V   ──────────────  VCC (only if not powered by battery)
```

**WARNING:** If the controller is powered by the scooter battery, do NOT connect ST-Link 3.3V. Only connect SWDIO, SWCLK, and GND.

## Procedure

### Step 1: Access the controller board
- Remove the controller from the deck
- The controller is in a metal box with a removable lid (not potted!)
- Locate SWD pads (SWDIO, SWCLK) on the PCB
- Note: The board may have conformal coating — scrape it off the SWD pads

### Step 2: Install OpenOCD
```bash
brew install openocd    # macOS
apt install openocd     # Linux
```

### Step 3: Backup current firmware
```bash
openocd -f interface/stlink.cfg \
    -c "transport select swd" \
    -c "adapter speed 1000" \
    -c "source [find target/swj-dp.tcl]" \
    -c "swd newdap chip cpu -irlen 0 -expected-id 0" \
    -c "target create chip.cpu cortex_m -dap chip.cpu" \
    -c init \
    -c "reset halt" \
    -c "flash read_bank 0 bldc_backup.bin 0 0x10000" \
    -c "reset" \
    -c shutdown
```

If the above fails, try generic Cortex-M0:
```bash
openocd -f interface/stlink.cfg \
    -c "transport select swd" \
    -c "set WORKAREASIZE 0x1000" \
    -f target/cortex_m.cfg \
    -c init \
    -c "reset halt" \
    -c "dump_image bldc_backup.bin 0x0 0x10000" \
    -c shutdown
```

### Step 4: Flash Global firmware
```bash
# Strip the 256-byte header (Navee OTA header + config)
# Flash only from vector table onwards
dd if=navee_bldc_v0.0.1.1_ST3_Global.bin of=bldc_global_flash.bin bs=1 skip=256

openocd -f interface/stlink.cfg \
    -c "transport select swd" \
    -f target/cortex_m.cfg \
    -c init \
    -c "reset halt" \
    -c "flash write_image erase bldc_global_flash.bin 0x100" \
    -c "verify_image bldc_global_flash.bin 0x100" \
    -c "reset" \
    -c shutdown
```

**Alternative: Flash entire file (including bootloader/header)**
```bash
openocd -f interface/stlink.cfg \
    -c "transport select swd" \
    -f target/cortex_m.cfg \
    -c init \
    -c "reset halt" \
    -c "flash write_image erase navee_bldc_v0.0.1.1_ST3_Global.bin 0x0" \
    -c "verify_image navee_bldc_v0.0.1.1_ST3_Global.bin 0x0" \
    -c "reset" \
    -c shutdown
```

### Step 5: Verify
- Reconnect controller to scooter
- Power on and check firmware version via BLE (`--read-info`)
- BLDC version should change from `0015` (v0.0.1.5 DE) to `0011` (v0.0.1.1 Global)

## Risk Assessment

| Risk | Level | Notes |
|------|-------|-------|
| Bricking controller | Low | Backup taken first; can always re-flash |
| Wrong MCU identified | Medium | Backup first, then check chip markings |
| SWD pads damaged | Low | Use fine tip, don't force |
| Read protection set | Low | RoboCoffee confirmed SWD is open on Brightway |
| Firmware incompatible | Low | Both DE and Global use same hardware T2324 |
| Conformal coating | Expected | Scrape off with knife/IPA before soldering |

## Key Insight from RoboCoffee

> "The manufacturer left the content of both SOCs unprotected!"
> "Custom firmware can be flashed to LKS32MC081 MCU without limitations using the SWD port"

The MCU firmware is **not signed** and **not read-protected**. SWD flash is the most reliable way to change the controller firmware.

## References

- [RoboCoffee: Hacking Brightway scooters](https://robocoffee.de/?p=436)
- [LKS32MC081 Datasheet](http://www.linkosemi.com) (Chinese)
- Navee uses Brightway-manufactured controllers (same hardware platform)

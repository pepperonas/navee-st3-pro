# UART BLDC DFU Analysis

## Status: COMPLETE — Dashboard does NOT relay XMODEM to BLDC

## Goal

Determine what the dashboard sends over UART when BLDC DFU (MCU type 2) is active.
The BLE→UART relay is a black box — we need to see the actual bytes on the wire.

## Setup

```
Mac (BLE) ──BLE──> Dashboard (RTL8762C) ──UART──> BLDC Controller
                          │
                    CP2102 RXD (sniffing)
                    CP2102 GND ── black wire
```

### Wiring
- CP2102 RXD → green wire (UART data line, parallel tap — do NOT cut)
- CP2102 GND → black wire (scooter ground)
- CP2102 TXD → NOT connected (read-only sniffing)

### UART Parameters
- Baud: 19200
- Data: 8 bits, no parity, 1 stop bit
- Logic level: ~4V (non-standard, but CP2102 tolerates it)

## Procedure

### Step 1: Baseline Capture
```bash
python3 tools/uart_bldc_sniffer.py --baseline 10
```
Record 10 seconds of normal UART traffic. Expected: Frame A (~5/s), Frame B (~3/s), Frame C (~1/s).

### Step 2: BLDC DFU Capture
Terminal 1:
```bash
python3 tools/uart_bldc_sniffer.py
```

Terminal 2:
```bash
python3 tools/ota_flasher.py \
    "firmware/navee_bldc_v0.0.1.1_ST3_Global,_pid=24012.bin" \
    --device-id 880002982db1
```

### Step 3: Analysis

Compare baseline vs DFU capture:
- New frame types?
- XMODEM bytes on UART?
- DFU text commands on UART?
- Data volume change?
- Timing changes?

## Known UART Frame Format

| Direction | Header | Footer | XOR |
|-----------|--------|--------|-----|
| Dashboard → Controller | 0x61 | 0x9E | 0xFF |
| Controller → Dashboard | 0x64 | 0x9B | 0xFF |

### Normal Frames
- **Frame A** (0x30): Dashboard status, 15 bytes, ~5x/sec
- **Frame B** (0x31): Dashboard telemetry, 14 bytes, ~3x/sec  
- **Frame C** (0x26): Controller telemetry, 18 bytes, ~1x/sec
- **Mode ACK** (0x23): Controller FW version + temp

Checksum: SUM(all bytes before checksum) & 0xFF

## Hypotheses

1. **Dashboard relays XMODEM blocks raw** → We should see SOH (0x01) on UART
2. **Dashboard wraps in Navee UART frame** → New CMD byte with XMODEM data inside
3. **Dashboard sends nothing** → UART is silent during DFU (relay not implemented)
4. **Dashboard uses different protocol** → Completely new frame format
5. **Baud rate changes** → Dashboard switches to higher baud for DFU transfer

## Results

### Capture performed: 2026-04-05

**Baseline (no DFU):** Normal Frame A/B/C traffic at expected rates.

**During BLDC DFU:** Normal Frame A/B/C traffic continues UNINTERRUPTED. No XMODEM bytes on UART. No new frame types. No DFU-related commands.

### Key Finding: No UART Relay

The sniffer detected many "XMODEM SOH" and "XMODEM NAK" alerts, but ALL were **false positives** — the bytes `0x01` and `0x15` appear naturally within Frame A data fields:

```
Frame A data: ... CF 30 80 01 15 00 00 32 9E ...
                        ^^  ^^
                        |   └── 0x15 = data byte, NOT XMODEM NAK
                        └────── 0x01 = data byte, NOT XMODEM SOH
```

No actual XMODEM blocks (133 bytes starting with SOH) appeared on UART at any point.

### Conclusion

1. **The NAK comes from the dashboard itself**, not relayed from the BLDC controller
2. The BLDC motor controller is **never contacted** during our DFU attempt
3. The dashboard's application firmware **cannot process XMODEM blocks for BLDC DFU** — only the RTL8762C bootloader (meter DFU) handles XMODEM correctly
4. The official Navee app likely uses a **different mechanism** for BLDC updates:
   - The dashboard may store the firmware in flash first, then flash the BLDC internally via its own UART protocol
   - Or BLDC updates require a specific dashboard firmware version that supports the relay
   - Or the BLDC DFU uses a completely different BLE command sequence we haven't discovered

### Hypothesis: Two-Phase BLDC Update

The Navee app probably does BLDC updates in two phases:
1. **Phase 1:** Upload firmware to dashboard storage (different from XMODEM — perhaps a Navee-specific upload command)
2. **Phase 2:** Dashboard independently flashes BLDC via internal UART in its own format/timing

Our OTA flasher only implements Phase 1 using XMODEM (which works for meter but not for BLDC upload to dashboard storage).

## Meter OTA Patch — Also Blocked

### SHA-256 is correct but bootloader rejects ALL modifications

The meter firmware NOP patch and speed-byte patch were both correctly implemented:
- SHA-256 verified: our calculation matches the stored hash in the original firmware
- SHA-256 regions confirmed identical to Bee2 SDK `slient_dfu_check_sha256()`
- Even a 1-byte change in padding area (0x00→0x01) with correct SHA-256 is rejected

| Flash Attempt | Modification | SHA-256 | rsq dfu_ok |
|---|---|---|---|
| Original firmware (unmodified) | None | Original | **YES** |
| NOP patch only (0xF848) | 2 bytes + SHA | Recomputed ✓ | **NO** |
| Speed patch only (0xF074: 22→40) | 1 byte + SHA | Recomputed ✓ | **NO** |
| NOP + Speed patch | 3 bytes + SHA | Recomputed ✓ | **NO** |
| 1-byte padding change | 1 byte + SHA | Recomputed ✓ | **NO** |

### UART Speed Bytes Discovery

UART Frame A captures revealed the speed limit bytes sent to the BLDC controller:
```
Frame A: 61 30 0A 35 00 88 17 15 01 00 00 00 00 85 9E
                            ^^ ^^
                            SPD_A=0x17(23) SPD_B=0x15(21) → 22 km/h
```

The Ghidra-identified `lift_speed_limit` function (patched at 0xF848) controls the BLE speed report, NOT the UART speed bytes. The UART speed comes from a **separate PID speed table** at offset 0xF074 where `MOV R0, #22` hardcodes the DE limit.

### New UART Frame Types Discovered

During meter firmware reboot, three new controller→dashboard frames appeared:
- **CMD 0x29** (28 bytes): Serial number `T234554RDE4J00638`
- **CMD 0x24** (12 bytes): Meter firmware version `"0003"` (v2.0.3.1)
- **CMD 0x21** (12 bytes): BLDC firmware version `"0015"` (v0.0.1.5)

### Root Cause

This dashboard (replacement unit) has a **newer bootloader or additional integrity check** beyond SHA-256 that the Bee2 SDK source does not document. The original dashboard (short-circuited) may have had a different bootloader that accepted SHA-256-only validation. The SHA-256 algorithm from `silent_dfu_flash.c` is mathematically verified correct for this firmware, but the bootloader performs an additional undocumented check that rejects any modification.

## Next Steps

1. **MITM Proxy** — intercept Navee app firmware download, serve patched binary; the app handles all checksums correctly
2. **SPI Flash Direct** — rtltool via UART download mode, write patched sector directly to Bank A, bypass bootloader
3. **Bootloader ROM Dump** — dump mask ROM at 0x601B9C via rtltool to reverse-engineer the actual validation algorithm
4. **Navee App Triggered Update** — use official app to flash, then patch via SPI flash

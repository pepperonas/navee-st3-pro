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

## Next Steps

**BLDC DFU is a dead end for now.** The working path is the **Meter firmware NOP patch**:

1. `patch_firmware.py` — patches `lift_speed_limit` function (BLS → NOP)
2. `ota_flasher.py` — flashes patched meter firmware via BLE OTA (verified working: 1080/1080 blocks)
3. After reboot: BLE CMD `0x6E [0x01, speed_kmh]` sets custom max speed

This approach modifies the **dashboard firmware** (which we CAN flash via OTA) to bypass the speed limit check, regardless of what the BLDC controller firmware says.

```bash
# Patch and flash
python3 tools/patch_firmware.py tools/firmware/navee_meter_v2.0.3.1.bin
python3 tools/ota_flasher.py tools/firmware/navee_meter_v2.0.3.1_PATCHED_OTA.bin --device-id 880002982db1
```

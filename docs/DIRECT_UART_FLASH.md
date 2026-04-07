# Direct UART Flash — BLDC Controller

Flash the BLDC motor controller directly via UART, bypassing the dashboard entirely.
Based on the Navee service tool "Download_Tool_S" discovered in a YouTube service video.

## How It Works

The BLDC controller has its own UART bootloader. The Navee service tool connects a USB-UART adapter directly to the controller (dashboard disconnected) and sends firmware via XMODEM.

## Hardware Setup

```
CP2102 USB-UART          Scooter Cable Harness
  TX  ──┬──────────────  Green wire (UART, half-duplex)
  RX  ──┘
  GND ─────────────────  Black wire (GND)
  
  DO NOT CONNECT:
  - Red wire (53V battery!)
  - Blue wire (52V battery!)
  - Yellow wire (signal)
```

**CRITICAL:** Disconnect the dashboard from the cable harness before connecting the CP2102. The green wire is half-duplex — both TX and RX go on the same wire.

## Procedure

### Step 1: Disconnect Dashboard
Unsolder or cut the dashboard's connection to the 5-wire cable harness. The controller needs to see NO dashboard to enter its bootloader.

### Step 2: Connect CP2102
- CP2102 TX + RX → Green wire
- CP2102 GND → Black wire
- Connect CP2102 to Mac via USB

### Step 3: Power On Scooter
Turn on the scooter (battery must be connected). The controller powers up and, without a dashboard responding, should enter its UART bootloader.

### Step 4: Detect Controller
```bash
python3 tools/uart_direct_flasher.py --detect
```
This listens for 30 seconds. Expected: the controller sends 'C' (0x43) repeatedly, requesting XMODEM CRC mode.

### Step 5: Flash Firmware

**Safe test (same firmware that's already installed):**
```bash
python3 tools/uart_direct_flasher.py \
    tools/firmware/navee_bldc_v0.0.1.5_ST3_PRO_DE_22km_h,_pid=23452.bin
```

**Speed unlock (Global firmware):**
```bash
python3 tools/uart_direct_flasher.py \
    tools/firmware/navee_bldc_v0.0.1.1_ST3_Global,_pid=24012.bin
```

### Step 6: Reconnect Dashboard
Resolder/reconnect the dashboard to the cable harness. Power cycle the scooter.

## Protocol Details

Based on "Download_Tool_S" screenshots:

| Parameter | Value |
|-----------|-------|
| Baud Rate | 19200 (possibly 115200) |
| Data Bits | 8 |
| Parity | None |
| Stop Bits | 1 |
| Protocol | XMODEM-CRC (128-byte blocks) |
| Block Format | SOH + seq + ~seq + 128 data + CRC-16 BE |
| File | Complete .bin including 16-byte Navee header |

### XMODEM Flow
1. Controller sends `'C'` (0x43) when ready for CRC mode
2. Tool sends blocks: `[01] [seq] [~seq] [128 bytes] [CRC-HI] [CRC-LO]`
3. Controller responds: ACK (0x06) or NAK (0x15) per block
4. After last block: EOT (0x04)
5. Controller confirms completion

### Block Count Verification
| Firmware Size | Blocks | Models |
|--------------|--------|--------|
| 41,088 bytes | 321 | S40, S60, V50i Pro, V25/V25i |
| 43,136 bytes | 337 | N65i |
| 45,184 bytes | 353 | E20, E25, V40i Pro II |
| 47,232 bytes | 369 | ST3, GT3, G5, V3 Pro |
| 49,280 bytes | 385 | UT3 Max |
| 53,376 bytes | 417 | ST3 PRO DE, GT5 Max |

The service tool showed "Total Data Blocks: 321" for an S40 firmware (41,088 bytes / 128 = 321). Confirms complete file is sent including header.

## Half-Duplex Notes

The green UART wire is half-duplex (single wire for both directions). When sending, the CP2102 will receive its own transmitted data as echo. The flasher script handles this by:
1. Sending the block
2. Reading back echo + response
3. Looking for ACK/NAK after the echo bytes

If echo causes issues, insert a 1kΩ resistor between CP2102 TX and the green wire.

## Baudrate

Try 19200 first (normal UART speed). If no response, try:
```bash
python3 tools/uart_direct_flasher.py --detect --baud 115200
python3 tools/uart_direct_flasher.py --detect --baud 57600
python3 tools/uart_direct_flasher.py --detect --baud 9600
```

## Troubleshooting

| Symptom | Cause | Fix |
|---------|-------|-----|
| No 'C' signal | Dashboard still connected | Disconnect dashboard |
| No 'C' signal | Wrong baud rate | Try 115200 |
| No 'C' signal | Controller not powered | Check battery, turn on scooter |
| NAK on blocks | Wrong baud or CRC | Check baud, try checksum mode |
| Echo issues | Half-duplex | Add 1kΩ resistor on TX |
| Navee frames (0x61/0x64) | Dashboard still connected | Disconnect dashboard! |

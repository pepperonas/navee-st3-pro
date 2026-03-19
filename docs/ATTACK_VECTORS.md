# Attack Vectors — Navee ST3 Pro Speed Limit

Honest assessment of all attempted approaches to modify the 22 km/h speed limit (PID 23452, German market).

## Summary Table

| # | Vector | Status | Effort | Risk |
|---|--------|--------|--------|------|
| 1 | BLE CMD 0x6E (Max Speed) | Failed | Low | None |
| 2 | UART MitM (Arduino) | Failed | Medium | Low |
| 3 | Firmware Patch (Ghidra) | Patch Found | High | N/A |
| 4 | OTA Flash (BLE XMODEM) | Blocked | Very High | Low |
| 5 | SPI Flash Direct (rtltool) | Next Step | Medium | Medium |
| 6 | Controller Swap (AliExpress) | Proven | Low | Low |
| 7 | Speed Limiter Wire | N/A (new revision) | Low | Low |

## Detailed Analysis

### 1. BLE Command 0x6E — Max Speed Setting
**Status: Failed**

The official Navee app sends CMD 0x6E with payload [0x01, speed_kmh] to set the maximum speed. The scooter ACKs the command but completely ignores it. The `lift_speed_limit` flag in the firmware (at sys_stc[0x4A]) must be set to 0x02 for CMD 0x6E to take effect. Without the firmware patch, this flag is never set for PID 23452.

**Why it fails:** The speed limit function (FUN_0800ad02) checks the area code (derived from PID). For Germany (area code 3), it returns 22.5 km/h regardless of the CMD 0x6E value. Only when `lift_speed_limit == 0x02` does it use the custom speed from sys_stc[0x47].

### 2. UART MitM — Arduino Interceptor
**Status: Failed**

An Arduino UNO was placed as man-in-the-middle on the green UART wire between dashboard and motor controller. The Arduino parsed Frame A (dashboard status, 15 bytes) and modified bytes 6-7 (speed values) from 0x17/0x15 to 0x1E/0x1E (30 km/h), recalculating the checksum.

Over 1168 frames were successfully modified with correct checksums. The motor controller received and processed these frames. **But the scooter still rode at exactly 22 km/h.**

**Why it fails:** The speed bytes in Frame A (bytes 6-7) are NOT speed limits — they are telemetry/display values that the dashboard sends to the controller. The actual speed limit is computed inside the dashboard firmware and enforced through a different mechanism (likely the motor PWM/current limit parameters, not these specific bytes).

**Key insight:** The controller does NOT accept externally manipulated frames for speed limit changes. The speed limit must come from the dashboard firmware itself, sent as an authentic calculation result.

### 3. Firmware Patch — Ghidra Analysis
**Status: Patch Identified (not yet installed)**

Using Ghidra headless analysis on the downloaded meter firmware (v2.0.3.1, 138240 bytes), the speed limit function was identified:

```
FUN_0800ad02 (File offset: 0xAD02):
  if (sys_stc[0x4A] == 0x02) {        // lift_speed_limit flag
      return sys_stc[0x47] * 10 + 5;  // Custom speed from BLE CMD 0x6E
  } else {
      return PID_DEFAULT_TABLE[area_code];  // 22.5 km/h for Germany
  }
```

**The Patch (1 byte):**
- File Offset 0xF848: `02 D9` (BLS — branch if less/same) → `00 BF` (NOP)
- This removes the conditional branch, making the code always fall through to the custom speed path
- After patching, CMD 0x6E can set any speed value

### 4. OTA Flash — BLE XMODEM Transfer
**Status: Blocked by Bootloader**

The OTA flasher was fully developed and verified:
- Complete DFU protocol: `dfu_start` → `ble_rand` → `ble_key` → XMODEM → EOT
- APK-exact state machine (asyncio.Event, ACK block validation)
- 1080/1080 blocks transferred successfully (135 KB, 34-68 seconds)
- Original firmware: `rsq dfu_ok` received, firmware installed (2/2 attempts)
- **ANY modified firmware: rejected (0/10 attempts)**

Even changing a single byte in the 0xFF padding area causes rejection. The bootloader has a cryptographic integrity check that cannot be bypassed via OTA.

**Checksums tested (all failed to match):**
CRC-16/XMODEM, CRC-16/CCITT, CRC-16/ARC, CRC-16/MODBUS, CRC-32 (standard), CRC-32 (STM32), XOR-32 (word), XOR-8 (byte), SUM-8, SUM-16, SUM-32, Fletcher-16, Fletcher-32, Adler-32, MD5, SHA-1, SHA-256, HMAC-MD5 (with all 5 AES keys), Brute-force CRC-32 at every 4-byte position, Brute-force CRC-16 at every 2-byte position.

### 5. SPI Flash Direct — rtltool via UART
**Status: Next Step**

The dashboard MCU is a Realtek RTL8762C which can be programmed via UART when pin P0_3 is held LOW during boot. Using [rtltool](https://github.com/cyber-murmel/rtltool), the entire SPI flash can be read and written, bypassing the OTA bootloader's integrity check.

**Approach:**
1. Open dashboard, connect USB-UART adapter (3.3V!) to UART pads
2. Bridge P0_3 to GND, power on → download mode
3. Dump entire flash (backup)
4. Locate firmware in flash (search for "T2202" header)
5. Patch the 2 bytes (02 D9 → 00 BF) in the relevant flash sector
6. Write patched sector back
7. Normal boot, test CMD 0x6E

**Complication:** Dashboard was damaged by short circuit during PCB removal (scooter was ON). Replacement dashboard needed, or use damaged board for flash dump experiments.

### 6. Controller Swap — Global Version
**Status: Proven (by community)**

Replacing the motor controller with a "Global" version (without DE speed limit) removes the 22 km/h restriction. Controllers are available on AliExpress for ~30-50 EUR.

**Pros:** Proven to work, no firmware knowledge needed
**Cons:** Cost, voiding warranty, different controller behavior possible

Source: rollerplausch.com community

### 7. Speed Limiter Wire — Hardware Disconnect
**Status: Not Applicable (new revision)**

Older hardware revisions had a dedicated white wire that, when cut, removed the speed limit. Current revisions (2024+) no longer have this wire. The speed limit is now entirely firmware-enforced.

Source: rollerplausch.com community

## Recommendations

**For most users:** Controller swap (Vector 6) is the simplest proven solution.

**For reverse engineers:** SPI flash direct programming (Vector 5) is the most promising technical approach. It requires opening the dashboard and accessing the UART/P0_3 pads, but avoids the bootloader's integrity check entirely.

**Not recommended:** Further OTA checksum attempts. After 10 failed attempts with exhaustive algorithm testing, the bootloader's integrity check is almost certainly cryptographic (SHA-256 signature, HMAC, or Realtek-proprietary). Without the signing key or algorithm from the bootloader ROM, OTA patching is not feasible.

# Protocol

BLE and internal UART protocol. Verified via APK decompilation, HCI captures, and live test sessions.

## BLE

### GATT

| UUID | Property | Purpose |
|---|---|---|
| `0000d0ff-3c17-d293-8e48-14fe2e4da212` | Service | Navee custom service |
| `0000b002-0000-1000-8000-00805f9b34fb` | Write-no-response | App → Dashboard |
| `0000b003-0000-1000-8000-00805f9b34fb` | Notify | Dashboard → App |

### Frame format (regular commands)

```
[55 AA] [encFlag] [cmd] [len] [data...] [SUM(prev) & 0xFF] [FE FD]
         ^ 0 = plain, 1 = encrypted (not observed in practice)
```

Builders in APK `_ble_manager/a.java`:
- `j(cmd, enc)` — READ: `[55 AA][f][cmd]`
- `k(cmd, val, enc)` — WRITE 1 byte: `[55 AA][f][cmd][1][val]`
- `l(cmd, byte[], enc)` — WRITE N bytes: `[55 AA][f][cmd][len][data]`

Auth frame (cmd `0x30`) and encrypted tunnel (cmd `0x31`) wrap payloads differently.

### Auth

- AES-128-ECB, 5 hardcoded keys in `_ble_manager/a.java:61` (`f1923l`)
- Key index 0..4 chosen per session by `SecureRandom`, sent as byte 5 of auth frame
- Key 0 = `A0 A1 A2 ... AF` (sequential — factory default)
- Keys 1-4 = random production keys
- AES impl: `utils/f.java::f()` = encrypt, `utils/f.java::g()` = XOR (not AES — name is misleading)

### Command set (decoded from APK notify handler `_ble_manager/a.java::e.e()`)

| Hex | Dec | Chinese | Meaning | Payload |
|---|---|---|---|---|
| 0x30 | 48 | 下发身份信息 | Auth | challenge/response |
| 0x31 | 49 | 下发加密数 | Encrypted tunnel | encrypted bytes |
| 0x50 | 80 | 解绑车辆 | Read / unbind | `[1]` |
| 0x51 | 81 | 车锁控制 | Lock control | `[0/1]` |
| 0x52 | 82 | 定速巡航 | Cruise control | `[0/1]` |
| 0x53 | 83 | 能量回收 | Energy recovery | `[v]` |
| 0x54 | 84 | 车灯控制 | Light control | `[...]` |
| 0x59 | 89 | 还原车辆 | **RESTORE VEHICLE** (never triggered from app UI — dead code path) | ? |
| 0x6B | 107 | 自定义限速 | Custom speed limit | `int` (`v\|0x80`=on, `0`=off) |
| 0x6E | 110 | 设置速度或模式 | Set speed/mode | sub `[1,kmh]` = max speed, sub `[2,1]` = DualDrive |
| 0x6F | 111 | 设置滑板车参数 | Scooter params | sub `[8,country]` = region (only at bind) |
| 0x70 | 112 | 读取车辆 | Read vehicle status (39 fields) | – |
| 0x73 | 115 | 读取固件版本 | Read FW version (4× 4-byte ASCII: meter/bldc/bms/screen) | – |
| 0x74 | 116 | 读取车辆SN | Read vehicle SN (17 B) | – |
| 0x90 | 144 | 首页信息上报 | Homepage telemetry push | continuous |

The controller does **not** report its region byte via BLE. `Vehicle.areaCode()` in the app is derived client-side from `carNo[8..10]` — string metadata, not a live device read.

### DFU sequence

```
1. CMD 0x30 (Auth)                    → status 0x00
2. "down dfu_start X\r" (X = 1-4)     → "ok\r"
   1=meter, 2=BLDC, 3=BMS, 4=screen
3. "down ble_rand\r"                  → "ok " + cipher (16 B)
4. "down ble_key " + decrypted + "\r" → "ok\r"
5. Wait for 0x43 ('C')                → XMODEM ready
6. XMODEM blocks (128 B + CRC-16 BE)  → ACK per block
7. EOT (0x04)                         → "rsq dfu_ok\r" or "rsq dfu_error\r"
```

Only `dfu_start 1` (meter) reliably produces `rsq dfu_ok` with unmodified firmware. See `STATUS.md` for detailed OTA success/failure matrix.

## Internal UART (Dashboard ↔ Controller)

19200 8N1, two independent wires. Both headers + footers sum to `0xFF` (header XOR footer = 0xFF).

### Yellow wire (Dashboard → Controller)

```
[0x51] [?] [mode] [?] [?] [?] [?] [?] [?] [?] [speed_limit] [?] [checksum] [0xAE]
```

- 14 bytes per frame
- Byte 10 = speed limit (DE builds send `0x16` = 22)
- Frame rate: continuous (multiple per second)

### Green wire (Controller → Dashboard)

Three frame types multiplexed:

| Type | Header | Length | Footer | Content |
|---|---|---|---|---|
| A | `0x61` | 15 | `0x9E` | Controller telemetry (speed, current, temp) |
| B | `0x61` | 14 | `0x9E` | Shorter telemetry variant |
| C | `0x64` | 18 | `0x9B` | Extended controller status |

Checksum rule for all frames (both wires): `SUM(all bytes before checksum) & 0xFF`.

### Key empirical finding

When the dashboard sends modified speed values on Yellow wire (tested via MitM Arduino), the controller **ignores them** and continues to enforce its internal limit (see commits `ab1c622`, `cd532c9`). The 22 km/h cap is enforced inside the controller firmware, not via UART commands.

## Cloud API (`https://lj.naveetech.com/tundra-api`)

Relevant endpoints (observed via HCI/mitmproxy):

| Method | Path | Purpose |
|---|---|---|
| POST | `/login`, `/loginByPhone`, `/loginByOther` | Auth |
| POST | `/vehicle/bind` | Bind — response contains `latlngCountryValue` (1 B) used in BLE cmd `[0x6F, 0x08, value]` |
| POST | `/vehicle/unbind` | Unbind |
| GET | `/vehicle/model` | Vehicle metadata |
| POST | `/vehicle/modelSoftware` | Returns firmware URLs (meterList, bldcList, bmsList, screenList) |
| GET | `/area?area=<code>` | Country list for region UI |

Auth via JSESSION cookie, no HMAC, no signed requests.

## APK source reference

Decompiled at `reverse-engineering/navee-apk-decompiled/`. Key files:

```
_ble_manager/a.java       BLE manager (obfuscated b4.a), AES keys at line 61
dfu/DFUProcessor.java     DFU state machine, XMODEM sender
bean/Vehicle.java         areaCode() = parse carNo[8..10], client-side only
ble/AreaCode.java         24 enum values (CN, UK, IT, DE, US, FR, ...)
ui/device/MaxSpeedActivity.java          CMD 0x6E sender with PID-based options
ui/device/SpeedLimitActivity.java        CMD 0x6B sender
ui/device/DeviceBindActivity.java:319    The only place CMD [0x6F, 0x08, X] is sent
ui/device/DeviceFirmwareUpdateActivity.java  DFU orchestration (screen→BMS→BLDC→meter)
```

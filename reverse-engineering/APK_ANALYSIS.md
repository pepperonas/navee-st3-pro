# Navee APK Decompilation & Analysis

Decompiled from `com.navee.ucaret.apk` (official Navee Android app) using jadx.
Date: 2026-04-05

## Directory Structure

```
navee-apk-decompiled/
  ble/                  # AreaCode, SKUVersion enums
  bean/                 # Data models (DeviceCarInfo, UserSession, DfuVerInfo, etc.)
  dfu/                  # DFUProcessor — complete OTA state machine
  network/              # API exceptions, DownloadUtils
  ui/
    login/              # LoginActivity, RegisterActivity, LoginLaunchActivity
    device/             # 40+ device control activities
    mine/               # Account settings, feedback
    mall/               # Shopping integration
    data/               # UserVehicleHelper, WeatherUpdater
    web/                # WebView integration
    wheel/              # Custom UI components
  utils/                # Crypto (f.java), SharedPrefs (g0.java), Area (y.java)
  base/                 # BaseActivity, adapters
  _ble_manager/         # b4/a.java — main BLE communication class (obfuscated name)
  _http_client/         # d4/ — OkHttp client, interceptors
  _config/              # e4/ — base URL configuration
  _session/             # g4/ — session/token management (e1.java)
  _callbacks/           # c4/ — DFU callbacks
  _sharesdk/            # cn/sharesdk/ — Google/Facebook OAuth via MobTech ShareSDK
```

## API Endpoints

Base URL: `https://lj.naveetech.com/tundra-api`

### Authentication
| Method | Path | Description |
|--------|------|-------------|
| POST | `/login` | Email/password login |
| POST | `/loginByPhone` | Phone + SMS code login |
| POST | `/loginByOther` | Social login (loginType: 1=Facebook, 2=Google) |
| POST | `/sendCode` | Send verification code |
| POST | `/checkCode` | Verify code |
| POST | `/resetPasswd` | Reset password |

### Vehicle
| Method | Path | Description |
|--------|------|-------------|
| GET | `/vehicle/model` | List all vehicle models |
| GET | `/vehicle/getVehicle` | Get user's bound vehicles |
| POST | `/vehicle/bind` | Bind device to account |
| POST | `/vehicle/unbind` | Unbind device |
| POST | `/vehicle/modelSoftware` | Check firmware updates (meter, bldc, bms, screen) |
| POST | `/vehicle/updateVehicle` | Update device settings |

### Sharing
| Method | Path | Description |
|--------|------|-------------|
| POST | `/shareVehicle/bindShareVehicleByUser` | Share vehicle |
| GET | `/shareVehicle/getMyShareVehicle` | Get vehicles shared with me |
| GET | `/shareVehicle/getShareUsers` | Search users for sharing |

### Other
| Method | Path | Description |
|--------|------|-------------|
| GET | `/getUser` | User profile |
| GET | `/area?area=...` | Region configuration |
| GET | `/weather/get` | Weather data |
| GET | `/configKey/google_third_login` | Google login config |
| POST | `/feedback` | Submit feedback |

### HTTP Headers (every request)
```
platform: "android"
language: <app language>
systemVersion: <android version>
model: <device model>
appVersion: "2.5.0"
Authorization: <bearer token>
area: <region code>
```

### Response Codes
- 200: Success
- 401: Token expired → re-login
- 410: App version deprecated → force exit

## BLE Protocol

### UUIDs
| UUID | Purpose |
|------|---------|
| `0000d0ff-3c17-d293-8e48-14fe2e4da212` | Service |
| `0000b002-0000-1000-8000-00805f9b34fb` | Write (TX) |
| `0000b003-0000-1000-8000-00805f9b34fb` | Notify (RX) |

### Frame Format
```
[0x55] [0xAA] [Flag] [CMD] [LEN] [DATA...] [Checksum] [0xFE] [0xFD]
```
- Flag: 0x00=plain, 0x01=encrypted
- Checksum: sum of all bytes before checksum, & 0xFF
- MTU: Requested 148 bytes (default 20)

### Command Codes

#### Write Commands
| Cmd | Hex | Description |
|-----|-----|-------------|
| Lock | 0x51 | Lock/unlock (0/1) |
| Cruise | 0x52 | Cruise control on/off |
| ERS | 0x53 | Energy recovery on/off |
| Light | 0x54 | Light control |
| TCS | 0x5F | Traction control on/off |
| Turn Sound | 0x60 | Turn signal beep on/off |
| Proximity Key | 0x61 | NFC unlock on/off |
| Start Speed | 0x6A | Initial throttle limit (km/h) |
| Speed Limit | 0x6B | Max speed limiter (km/h) |
| Sound | 0x6C | Volume/tone settings |
| Light Config | 0x6D | Light mode configuration |
| Speed/Mode | 0x6E | Drive mode (eco/std/sport) |
| Params | 0x6F | General settings |

#### Read Commands
| Cmd | Hex | Description | Response |
|-----|-----|-------------|----------|
| Vehicle Settings | 0x70 | All settings | 39+ bytes |
| Driving Stats | 0x71 | Current trip | 8-18 bytes |
| Battery | 0x72 | Battery detail | 35+ bytes |
| Firmware | 0x73 | MCU versions | 16 bytes (4x4) |
| Serial | 0x74 | Vehicle SN | 17 bytes |
| Battery SN | 0x75 | Battery serial | variable |
| Drive History | 0x76 | Trip records | 8n bytes |

#### Telemetry (unsolicited)
| Cmd | Hex | Description |
|-----|-----|-------------|
| Home Page | 0x90 | Battery, range, voltage, lock status |
| Drive v0 | 0x91 | Speed, distance, trip (1-byte fields) |
| Drive v1 | 0x92 | Speed, distance, trip (2-byte fields, extended) |

### Authentication
1. Send CMD 0x30 with device ID → device returns encrypted challenge
2. Decrypt with regional AES-128-ECB key (5 keys for different regions)
3. Send CMD 0x31 with decrypted response

**AES Keys (5 regional variants):**
```
Key[0]: A0 A1 A2 A3 A4 A5 A6 A7 A8 A9 AA AB AC AD AE AF
Key[1]: 44 6D 10 72 6D BE 05 F6 62 DF AA F0 13 27 30 3F
Key[2]: A2 85 CC EC 81 4F E9 61 74 29 95 E8 EB A9 22 47
Key[3]: 3F EE 80 FF 96 DF 5C F5 42 EA AC 93 28 1F E5 29
Key[4]: 4E B4 D4 64 D6 EF 53 ED 6C E9 45 58 DE 9A 5E E3
```

Key selection based on region: CN=0, UK=1, EU=2, US=3, etc.

## DFU / OTA Firmware Update

### MCU Types
| ID | Type | Description |
|----|------|-------------|
| 1 | meter | Dashboard/instrument cluster |
| 2 | bldc | Motor controller |
| 3 | bms | Battery management system |
| 4 | screen | LCD display |

### DFU Protocol Flow
```
1. Send "down dfu_start <MCU_ID>\r"    → "ok\r"
2. Send "down ble_rand\r"               → "ok <encrypted_random>\r"
3. Decrypt random, compute key
4. Send "down ble_key <key>\r"           → "ok\r"
5. XMODEM transfer (128-byte blocks)
   Block: [SOH=0x01] [seq] [~seq] [128 bytes] [CRC-16]
   ACK=0x06, NAK=0x15
6. Send EOT (0x04) x5 at 500ms intervals
7. Wait for "rsq dfu_ok\r" or "rsq dfu_error\r"
```

### DFU State Machine
```
none → sendStart → requestRand → sendRand → xmodemReady
     → xmodemSendPack → xmodemSendPackWaiting → xmodemSendPackSending
     → xmodemSendPackSuccess → xmodemSendEOT → xmodemFinished
     → success / failure
```

### Timeouts
- DFU start handshake: 11 seconds
- Random exchange: 6 seconds
- Block transfer: 500ms wait + 6 sec total
- Retries per block: 10
- DFU start retry: every 3 seconds

### CRC-16 (polynomial 0x1021)
```python
def crc16(data):
    crc = 0
    for byte in data:
        crc ^= byte << 8
        for _ in range(8):
            if crc & 0x8000:
                crc = (crc << 1) ^ 0x1021
            else:
                crc <<= 1
            crc &= 0xFFFF
    return crc
```

## Vehicle Settings Data (CMD 0x70 Response)

```
Offset  Field              Values
0       bindingStatus      0/1
1       drivingMode        1=eco, 2=normal, 3=sport
2       lockStatus         0=unlocked, 1=locked
3       ccsStatus          cruise control
4       tailIsOn           tail light
5       ersStatus          energy recovery
6       mileageAlgorithm   odometer mode
7       mileageUnit        0=km, 1=mi
8       autoSensor         light sensor
9       tyreSwitch         tire monitor
10      ambientLight       ambient LED mode
11      tcsSwitch          traction control
12      turnSound          turn signal beep
13      proximityKey       NFC unlock
14      nightMode          auto headlight
15      mileageAlgoMode    algo variant
16      lightE             front light level
17      lightD             rear light level
18      lightS             side light level
19      startSpeed         km/h
20      limitSpeed         km/h
21      volume             0-100
22      reportLanguage     lang code
23      logoLight          logo LED
24      dayRunLight        DRL
25      maxSpeed           max speed km/h
26      driveMode          motor mode enum
27-30   startChargeTime    unix timestamp (LE)
31      chargeLimit        80/90/100%
32      lowPower           low power mode
33      timedChargeOn      timer enabled
34      lockTime           auto-lock seconds
35      breakSpeed         regen brake level
36      weather            weather display
37      slopeSup           hill assist
38      longRange          long range mode
```

## Region System

### Area Codes (24 regions)
CN, UK, ID, IN, IT, NL, NZ, SG, ES, TH, SE, JP, EU, US, CA, KR, FR, DE, AT, AU, RU, NE, PL, WE

### SKU Variants
| SKU | Regions | Notes |
|-----|---------|-------|
| EUR | Default for most | Standard EU limits |
| ITA | IT, DE, NL, EU | Stricter limits (22 km/h DE) |
| USA | US, CN, RU | Different speed limits |

SKU determines AES key index and speed limit enforcement.

## Google Login Flow (from LoginActivity.java)

```
1. ShareSDK.getPlatform(GooglePlus.NAME).authorize()
2. onComplete → extract userId, userName, userIcon, rawData
3. POST /loginByOther {
     loginType: "2",
     uid: <google_user_id>,
     raw: <sharesdk_export_json>,
     nickName: <display_name>,
     icon: <photo_url>
   }
4. Response: { code: 200, data: { token: "...", userId: ... } }
```

## Key Files Reference

| What | File |
|------|------|
| BLE Manager | `_ble_manager/a.java` (1200+ lines, main protocol handler) |
| DFU Processor | `dfu/DFUProcessor.java` |
| AES Encryption | `utils/f.java` (method `f()`) |
| Byte Utilities | `utils/f.java` |
| Session Manager | `_session/e1.java` |
| HTTP Client | `_http_client/d.java` |
| HTTP Interceptor | `_http_client/a.java` |
| Base URL Config | `_config/a.java` |
| Area Codes | `ble/AreaCode.java` |
| SKU Versions | `ble/SKUVersion.java` |
| Device Settings | `bean/DeviceCarInfo.java` |
| Battery Info | `bean/DeviceBatteryInfo.java` |
| Dashboard Data | `bean/DeviceHomePageInfo.java` |
| Driving Data | `bean/DeviceSubPageInfo.java` |
| FW Version | `bean/DfuVerInfo.java` |
| FW Response | `bean/DfuResponseData.java` |
| User Session | `bean/UserSession.java` |
| Speed Settings | `ui/device/MaxSpeedActivity.java` |
| FW Update UI | `ui/device/DeviceFirmwareUpdateActivity.java` |

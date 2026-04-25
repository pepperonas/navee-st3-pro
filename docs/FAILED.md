# Why this didn't work — research post-mortem

The original goal was to remove the 22 km/h speed limit on the Navee ST3 Pro DE
(PID 23452) by software. After ~4 weeks of reverse engineering across BLE, UART,
firmware analysis (Ghidra), and OTA experiments, every software-only path is dead.
This file is the honest record of what was tried and what blocks each path.

The limit lives in the BLDC motor-controller firmware, gated by a single region
byte at offset `0x0011`: `0xCF` = DE (22 km/h), `0xB7` = Global (30 km/h). Patching
that one byte is trivial; getting the patched binary onto the controller is not.

## What works

| Capability | Evidence |
|---|---|
| BLE pairing + auth (5 AES-128-ECB keys) | `tools/ota_flasher.py --read-info` |
| Read BLDC/meter/BMS/screen FW versions (CMD `0x73`) | Many sessions |
| Send speed commands `0x6E`, `0x6B` | ACKed (also via the Android app's manual slider, free 5–60 km/h), controller still caps at 22 km/h |
| **Meter OTA flash of stock firmware** | 1080/1080 blocks, `rsq dfu_ok` (2026-04-16) |
| SPI-direct read/write on dashboard flash via rtltool | 512 KB dump + sector write verified (commit `e4178ec`) |
| BLDC header CRC-16/XMODEM algorithm | Verified on 26 of 32 BLDC firmware files |
| Meter SHA-256 recomputation algorithm | `tools/patch_firmware.py` matches stock hash exactly |

## What fails

| Attempt | Symptom | Sessions |
|---|---|---|
| BLDC OTA via BLE (`dfu_start 2`, type=0x02 header) | NAK on block 1, 0 ACKs | 36+ |
| Patched meter OTA (correct SHA-256) | Blocks ACKed, then silence — no `rsq dfu_ok` / `rsq dfu_error` | 2026-04-16 |
| Yellow-wire MitM injecting modified speed byte | Controller ignores, internal limit holds | 1168 frames |
| Dashboard replacement | New dashboard → same 22 km/h cap | Vector 11/12 |
| String scan for `down dfu_start 2` in dashboard FW | Not present — falls through to silent_dfu (writes to dashboard's own flash) | – |
| UART sniff during BLDC OTA | Zero XMODEM bytes flow dashboard → controller on any wire | – |

## Why the meter OTA path is closed

For app image (`image_id 0x2793`), the **boot validator** (`FUN_0080d400`) only
runs `func_0x00601b9c` (SHA-256). The "loading check" gated by header bit 2 is
skipped. So patches written via SPI-direct *should* boot — and they do.

But **OTA-time validation** invokes `func_0x0000C880(0x2793)`, which lives outside
the app image — likely in the PATCH image at file offset `0x003000-0x00CFFF` (not
yet decompiled) or in the BootROM (not dumped). This second check silently rejects
any modification, even a 1-byte change with correctly recomputed SHA-256.

## Why the BLDC OTA path is closed

The dashboard binary contains literal strings only for `"down dfu_start"` (default
→ silent_dfu) and `"down dfu_start 3"` (BMS-specific relay). `dfu_start 1/2/4` all
fall through to silent_dfu, which writes to the dashboard's *own* flash. There is
no UART-XMODEM relay code in this firmware version, and the LKS32MC081 controller
has no UART ISP bootloader (datasheet v1.93 confirms — flash programming is
SWD-only).

## Why the UART path is closed

The LKS32MC081C8T8 datasheet (`docs/LKS32MC081.md`, full PDF in `docs/`) describes
no UART ISP bootloader and no system-memory programming region. Flash is
programmed exclusively via SWD. UART probing of TX0/RX0 or TX2/RX2 pads on the
ESC board for bootloader entry would therefore fail by design.

## Apple Find My Network (FMNA) in the dashboard

The dashboard FW contains a complete FMNA stack: 33 `fmna_*` symbols, 5
`fm_crypto_*` symbols, `secp256r1`, `AES-256-GCM`, `ServerSharedSecret`,
`PairingSession`, `SerialNumberProtection`. Apple's FMNA certification requires
a hardware Secure Element. Boot-time validation does **not** invoke the SE
(only SHA-256), so a SPI-direct patch should boot. Whether the OTA-time
validator (`func_0x0000C880`) involves the SE is unknown. No SE chip has been
physically identified on the PCB; strongest candidate is the SPI peripheral
at `0x4000F000` (28 literal-pool refs, the most active non-BLE bus).

## Remaining paths (hardware only)

| Path | Cost | Realistic success | Effort |
|---|---|---|---|
| **Physical BLDC controller swap (Global variant)** | 30–50 € | ~60 % | 2–4 h + shipping |
| **SWD flash via ST-Link v2 on LKS32MC081** | ~10 € | ~40 % | 2–8 h hardware setup |
| Combined: SWD first, swap on failure | 10–50 € | ~75 % | 4–12 h |
| Decompile PATCH image to understand 2nd OTA validator | 0 € | low value (won't help BLDC anyway) | 4–10 h |

The LKS32MC08x has no hardware RDP fuse — only soft "last-word anti-theft" and
optional SWD-pin GPIO muxing. RoboCoffee dumped the same chip on the Xiaomi 3
Lite (same OEM, Brightway) without protection bypass. The blocker is purely
mechanical: SWD pads (MCU pins 2, 47, 48) need to be located on an epoxy-potted
ESC PCB.

## Empirical summary

| # | Vector | Result |
|---|---|---|
| 1 | BLE `0x6E` max-speed (incl. Android-app slider, free value selection) | ACK, no effect |
| 2 | BLE `0x6B` custom limit | ACK, no effect |
| 3 | UART MitM (Green wire) | Controller ignores |
| 4 | Meter OTA stock | Works |
| 5 | Meter OTA patched (correct SHA-256) | Silent rejection after EOT |
| 6 | SPI-flash direct write (rtltool) | Write verified, OTA validator bypassed at boot |
| 7 | BLDC OTA (`dfu_start 2`) | 0 ACKs in 36+ sessions |
| 8 | BLDC-as-meter OTA (type=0x01 header) | 369/369 blocks ACKed → written to meter flash |
| 9 | Yellow-wire MitM + dashboard replacement | Same internal limit |
| 10 | ESC UART scan (TX0/RX0, TX2/RX2) for bootloader | Excluded by datasheet |
| 11 | Physical controller swap (Global variant) | Not attempted; community-verified |
| 12 | SWD on LKS32MC081 | Not attempted; pads not located |

## Commit references

- `1b0889d` — Meter OTA verified 1080/1080 blocks
- `e4178ec` — SPI flash dump + patch write verified via rtltool
- `e24f021` — SHA-256 algorithm reverse-engineered
- `8099a7c` — Second validator blocks modified FW with correct SHA-256
- `f28d5a7` — BLDC OTA investigation concluded
- `ab1c622` — Controller ignores Yellow-wire injected speed bytes
- `cd532c9` — Yellow wire protocol decoded (0x51/0xAE frames)
- `b493d59` — LKS32MC081C8T8 datasheet added; UART ISP excluded

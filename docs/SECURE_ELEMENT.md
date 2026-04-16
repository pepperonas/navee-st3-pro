# Secure Element Analysis

## Finding

The dashboard contains a complete **Apple Find My Network Accessory (FMNA)** stack.
Apple's FMNA certification requires a hardware Secure Element to store the identity key
and perform ECDSA P-256 signing. The SE chip is therefore very likely present on the
dashboard PCB, but has not yet been physically identified.

## Evidence in firmware

All strings confirmed in Bank A (`0x0080E000 - 0x0082F69C`) of the 2026-04-16 dump:

| String | MEM offset | Count |
|---|---|---|
| `fmna_*` symbols | various | 33 unique |
| `fm_crypto_*` symbols | `0x0082ACF3 +` | 5 unique |
| `ServerSharedSecret` | `0x0082ACBA` | 1 |
| `PairingSession` | `0x0082ACCD` | 1 |
| `SerialNumberProtection` | `0x0082ACDC` | 1 |
| `secp256r1` | `0x0082BF58` | 1 |
| `AES-256-GCM` | `0x0082BF40` | 1 |
| `SHA256` | `0x0082BF68` | 1 |
| `FMNA_SM_*` state-machine symbols | `0x0082BF74 +` | 29 unique |

The exact chip has not been identified — no vendor strings (`ATECC`, `SE050`, `OPTIGA`,
`cryptoauth`, etc.) were found in the dump. The driver code is generic.

## Candidate bus location

| Peripheral base | Literal-pool refs | Likely function |
|---|---|---|
| `0x4000F000` | 28 | SPI master with DMA — strongest SE candidate |
| `0x40002000` | 15 | I2C0 / UART0 — secondary candidate |
| `0x40011000` | 12 | Bluetooth subsystem |
| `0x40001000` | 22 | GPIO/timer |

`0x4000F000` is the most active peripheral not accounted for by BLE, and matches the
typical SPI-connected SE pattern (e.g., SE050 via T=1).

## Relevant functions (Ghidra)

| Address | Name | Purpose |
|---|---|---|
| `0x00824AC4` | `fmna_crypto_init_dispatcher` | Initializes FMN crypto: loads two 0x58-byte curve parameter blocks, calls `fm_crypto_ckg_init_internal` |
| `0x00816AF8` | `fm_crypto_ckg_init_internal` | Apple's cryptographic key-generation init |
| `0x00816FCA` | `fmna_server_shared_secret` | HKDF-style shared-secret derivation |
| `0x00811B7C` | (candidate) | Called with 0x58-byte lengths — possible SE I/O wrapper |

## Impact on the speed-patch project

**Boot-time validation does not call the SE.** `FUN_0080d400` (the boot validator)
for app_image `0x2793` runs only `func_0x00601b9c` (SHA-256 check). No SE interaction.
A SPI-direct-written patch with correct SHA-256 should boot normally, regardless of
the SE.

**OTA-time validation may or may not call the SE.** The OTA post-EOT validator
(`func_0x0000C880`, in the PATCH image) has not yet been decompiled. Whether it checks
the SE is unknown; empirically it rejects any modification (even a 1-byte change with
recomputed SHA-256) without sending `rsq dfu_error`.

**Runtime re-validation of app code by the SE is unlikely but unverified.** Apple
FMNA spec uses the SE only for identity attestation and periodic key rotation, not
for general code integrity. A SPI-direct patch has been written once (commit `e4178ec`);
long-term stability under FMNA operation has not been measured systematically.

## Concrete next steps

1. **PCB photo inspection** (zero cost): photograph all SMD chips near the RTL8762C.
   Look for 6-pin SOT23-6 (Apple MFi Auth IC), 8-pin SOIC/XDFN (ATECC608), or
   QFN-4×4mm (SE050/OPTIGA).
2. **Logic-analyzer capture** on SPI pins from the RTL8762C to the candidate chip.
   Use `tools/sigrok_decoders/i2c_se/` or the SPI equivalent to classify frames.
3. **Decompile the PATCH image** at file offset `0x003000-0x00CFFF` (base `0x00803000`)
   to locate `func_0x0000C880` — that is the OTA-time validator that rejects modified
   firmware.

## Tools

- `tools/se_scan.py` — static FW scan for SE indicators (vendor strings, ATECC opcodes,
  I2C addresses, RTL8762C peripheral references)
- `tools/ghidra_se_analyze.py` — PyGhidra decompilation of the identified functions
- `tools/sigrok_decoders/i2c_se/` — PulseView protocol decoder that classifies
  ATECC608, SE050, OPTIGA, ATSHA204 frames on an I2C bus

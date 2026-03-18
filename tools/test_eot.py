#!/usr/bin/env python3
"""Test: Nach erfolgreichem XMODEM-Transfer nur EOT senden und ALLE Responses zeigen."""
import asyncio, sys, time
sys.path.insert(0, '.')
from ota_flasher import *

async def main():
    config = load_config()
    device_id = parse_device_id(config["device_id"])
    fw_path = Path("firmware/navee_meter_v2.0.3.1_ORIGINAL.bin")
    fw_info = analyze_firmware_file(fw_path)
    fw_data = fw_path.read_bytes()

    flasher = NaveeOTAFlasher()
    scooters = await flasher.scan()
    if not scooters: return
    if not await flasher.connect(scooters[0].address): return
    if not await flasher.authenticate(device_id): return
    await asyncio.sleep(0.5)

    # DFU Start
    print("\n[1] DFU Start...")
    dfu_ok = await flasher.enter_ota_mode(mcu_type=1)
    if not dfu_ok:
        print("  Versuche Typ 3...")
        await asyncio.sleep(5)
        flasher.last_responses.clear()
        dfu_ok = await flasher.enter_ota_mode(mcu_type=3)
    if not dfu_ok:
        print("FAIL"); return

    # Key Exchange
    print("\n[2] Key Exchange...")
    await asyncio.sleep(1.0)
    flasher.last_responses.clear()
    await flasher.client.write_gatt_char(WRITE_UUID, b"down ble_rand\r", response=False)
    await asyncio.sleep(2.0)
    for resp in flasher.last_responses:
        ok_idx = resp.find(b"ok ")
        if ok_idx >= 0:
            after_ok = resp[ok_idx+3:]
            if after_ok.endswith(b"\r"): after_ok = after_ok[:-1]
            status = after_ok[0]
            cipher = after_ok[1:17]
            key = AES_KEYS[1]
            decrypted = bytes(c ^ k for c, k in zip(cipher, key))
            flasher.last_responses.clear()
            await flasher.client.write_gatt_char(WRITE_UUID, b"down ble_key " + decrypted + b"\r", response=False)
            await asyncio.sleep(2.0)
            print(f"  Key Exchange: {'OK' if any(b'ok' in r for r in flasher.last_responses) else 'FAIL'}")
            break

    # Warte auf 0x43
    print("\n[3] Warte auf 0x43...")
    flasher.last_responses.clear()
    for _ in range(50):
        await asyncio.sleep(0.1)
        for r in flasher.last_responses:
            if 0x43 in r and len(r) <= 3:
                print("  XMODEM Ready!")
                break
        else: continue
        break

    # XMODEM Transfer
    print(f"\n[4] XMODEM Transfer ({fw_info['blocks']} Blöcke)...")
    total = fw_info['blocks']
    seq = 0
    for i in range(1, total + 1):
        offset = (i-1) * 128
        block = fw_data[offset:offset+128]
        if len(block) < 128: block += bytes([0x1A] * (128 - len(block)))
        seq = (seq + 1) % 256
        if seq == 0: seq = 1
        xb = bytearray([0x01, seq, (~seq) & 0xFF]) + block + struct.pack(">H", crc16_xmodem(block))
        await flasher.client.write_gatt_char(WRITE_UUID, bytes(xb), response=False)
        await asyncio.sleep(0.03)
        if i % 100 == 0: print(f"  Block {i}/{total}")
    print(f"  Alle {total} Blöcke gesendet!")

    # EOT — JETZT GENAU BEOBACHTEN
    print(f"\n[5] EOT Phase — beobachte ALLE Responses...")
    flasher.last_responses.clear()

    for eot_num in range(1, 6):
        print(f"\n  EOT #{eot_num}: Sende 0x04...")
        await flasher.client.write_gatt_char(WRITE_UUID, bytes([0x04]), response=False)

        # 3 Sekunden warten und JEDE Response zeigen
        for wait in range(30):
            await asyncio.sleep(0.1)
            while flasher.last_responses:
                resp = flasher.last_responses.pop(0)
                hex_r = " ".join(f"{b:02X}" for b in resp)
                try: text = resp.decode('ascii', errors='replace').strip()
                except: text = ""
                print(f"    RX [{wait*100}ms]: Hex={hex_r}")
                if text: print(f"              Text={text!r}")
                if b"dfu_ok" in resp:
                    print(f"    >>> DFU OK! <<<")
                if b"dfu_error" in resp:
                    print(f"    >>> DFU ERROR! <<<")
                if 0x06 in resp:
                    print(f"    >>> ACK (0x06)! <<<")

    print(f"\n[6] Warte noch 10s auf späte Responses...")
    for wait in range(100):
        await asyncio.sleep(0.1)
        while flasher.last_responses:
            resp = flasher.last_responses.pop(0)
            hex_r = " ".join(f"{b:02X}" for b in resp)
            print(f"  RX [{wait*100}ms]: {hex_r}")

    await flasher.disconnect()
    print("\nFertig.")

asyncio.run(main())

#!/usr/bin/env python3
"""Rohen Status-Dump vor und nach CMD 0x6E — zeigt ALLE Bytes die sich ändern."""
import asyncio, sys
sys.path.insert(0, '.')
from ota_flasher import *

async def dump_status(flasher, label):
    """Sendet CMD 0x70 und zeigt alle 37 Bytes."""
    flasher.last_responses.clear()
    frame = build_frame(0x70)
    await flasher.client.write_gatt_char(WRITE_UUID, frame, response=False)
    await asyncio.sleep(1.0)
    for r in flasher.last_responses:
        if len(r) > 30 and r[0] == 0x55 and r[1] == 0xAA:
            # Parse: 55 AA flag cmd len data... checksum FE FD
            data = r[5:5+r[4]]
            print(f"\n  [{label}] Status ({len(data)} Bytes):")
            for i in range(0, len(data), 16):
                hex_part = " ".join(f"{b:02X}" for b in data[i:i+16])
                print(f"    [{i:2d}] {hex_part}")
            return data
    return None

async def main():
    config = load_config()
    device_id = parse_device_id(config["device_id"])
    flasher = NaveeOTAFlasher()
    scooters = await flasher.scan()
    if not scooters:
        return
    if not await flasher.connect(scooters[0].address):
        return
    if not await flasher.authenticate(device_id):
        return
    await asyncio.sleep(1.0)

    # 1. Status VORHER
    before = await dump_status(flasher, "VORHER")

    # 2. CMD 0x6E senden: 30 km/h
    print("\n  >>> CMD 0x6E [0x01, 0x1E] (30 km/h) <<<")
    frame = build_frame(0x6E, bytes([0x01, 0x1E]))
    await flasher.client.write_gatt_char(WRITE_UUID, frame, response=False)
    await asyncio.sleep(1.0)

    # 3. Status NACHHER
    after = await dump_status(flasher, "NACHHER")

    # 4. Vergleich
    if before and after and len(before) == len(after):
        diffs = [(i, before[i], after[i]) for i in range(len(before)) if before[i] != after[i]]
        if diffs:
            print(f"\n  GEÄNDERTE BYTES ({len(diffs)}):")
            for i, b, a in diffs:
                print(f"    Byte [{i}]: 0x{b:02X} ({b}) → 0x{a:02X} ({a})")
        else:
            print(f"\n  KEINE ÄNDERUNG — Status ist identisch!")
            print(f"  → CMD 0x6E hat den Wert NICHT geändert")
            print(f"  → Entweder Firmware-Patch nicht aktiv oder Wert wird überschrieben")

    await flasher.disconnect()

asyncio.run(main())

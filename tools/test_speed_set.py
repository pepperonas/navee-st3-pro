#!/usr/bin/env python3
"""Test: CMD 0x6E direkt senden und prüfen ob max_speed sich ändert."""
import asyncio
import sys
sys.path.insert(0, '.')
from ota_flasher import *

async def main():
    config = load_config()
    device_id = parse_device_id(config["device_id"])

    flasher = NaveeOTAFlasher()
    scooters = await flasher.scan()
    if not scooters:
        print("Kein Scooter gefunden")
        return
    if not await flasher.connect(scooters[0].address):
        return
    if not await flasher.authenticate(device_id):
        return

    await asyncio.sleep(1.0)

    # 1. Aktuellen Wert lesen
    print("\n--- VORHER ---")
    await flasher.read_all_info()

    # 2. CMD 0x6E senden: [0x01, 0x1E] = 30 km/h
    print("\n--- SENDE CMD 0x6E [0x01, 0x1E] (30 km/h) ---")
    frame = build_frame(0x6E, bytes([0x01, 0x1E]))
    await flasher.client.write_gatt_char(WRITE_UUID, frame, response=False)
    print(f"  TX: {hex_str(frame)}")

    await asyncio.sleep(2.0)

    # Zeige alle Responses
    print(f"  Responses ({len(flasher.last_responses)}):")
    for r in flasher.last_responses[-5:]:
        print(f"    {hex_str(r)}")

    # 3. Nochmal lesen
    print("\n--- NACHHER ---")
    flasher.last_responses.clear()
    await flasher.read_all_info()

    # 4. Auch den rohen Status-Frame anzeigen
    print("\n--- RAW STATUS ---")
    frame = build_frame(0x70)
    await flasher.client.write_gatt_char(WRITE_UUID, frame, response=False)
    await asyncio.sleep(1.0)
    for r in flasher.last_responses[-3:]:
        if b"\x55\xaa" in r and len(r) > 30:
            data = r[5:-3] if len(r) > 40 else r
            print(f"  Status Byte 26 (max_speed): 0x{data[26]:02X} = {data[26]} km/h" if len(data) > 26 else f"  Raw: {hex_str(r)}")

    await flasher.disconnect()

asyncio.run(main())

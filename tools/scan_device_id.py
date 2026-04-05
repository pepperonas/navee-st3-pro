#!/usr/bin/env python3
"""
Navee BLE Scanner — Extract Device ID from advertising data.

Scans for Navee scooters and dumps all advertising/manufacturer data
to find the correct device ID for OTA flashing.
"""

import asyncio
import sys

try:
    from bleak import BleakScanner
except ImportError:
    print("ERROR: 'bleak' required. Install with: pip3 install bleak")
    sys.exit(1)


async def main():
    print("Scanning for Navee scooters (15s)...\n")

    devices = await BleakScanner.discover(
        timeout=15.0,
        return_adv=True,
    )

    for address, (device, adv_data) in devices.items():
        name = device.name or adv_data.local_name or ""
        if not name.upper().startswith("NAVEE"):
            continue

        print(f"  Device: {name}")
        print(f"  Address: {address}")
        print(f"  RSSI: {adv_data.rssi}")

        # Manufacturer data (key = company ID, value = bytes)
        if adv_data.manufacturer_data:
            print(f"  Manufacturer Data:")
            for company_id, data in adv_data.manufacturer_data.items():
                hex_str = " ".join(f"{b:02X}" for b in data)
                print(f"    Company 0x{company_id:04X}: {hex_str}")
                # Try to extract device ID from various positions
                if len(data) >= 6:
                    # Common positions for device ID
                    print(f"    Bytes 0-5 as ID: {data[0]:02x}{data[1]:02x}{data[2]:02x}{data[3]:02x}{data[4]:02x}{data[5]:02x}")
                if len(data) >= 8:
                    print(f"    Bytes 2-7 as ID: {data[2]:02x}{data[3]:02x}{data[4]:02x}{data[5]:02x}{data[6]:02x}{data[7]:02x}")

        # Service data
        if adv_data.service_data:
            print(f"  Service Data:")
            for uuid, data in adv_data.service_data.items():
                hex_str = " ".join(f"{b:02X}" for b in data)
                print(f"    {uuid}: {hex_str}")

        # Service UUIDs
        if adv_data.service_uuids:
            print(f"  Service UUIDs: {adv_data.service_uuids}")

        # Raw advertisement bytes (platform-specific)
        if hasattr(adv_data, 'platform_data'):
            pdata = adv_data.platform_data
            if pdata:
                print(f"  Platform data type: {type(pdata)}")

        print()

    if not any((d.name or "").upper().startswith("NAVEE")
               for _, (d, _) in devices.items()):
        print("  No Navee scooters found.")


if __name__ == "__main__":
    asyncio.run(main())

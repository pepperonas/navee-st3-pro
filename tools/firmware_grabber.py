#!/usr/bin/env python3
"""
Navee ST3 Pro Firmware Grabber
Lädt Firmware-Binaries von der Navee Server-API herunter.

API-Basis: https://lj.naveetech.com/tundra-api
Erkenntnisse aus APK-Dekompilierung (jadx) der offiziellen Navee App.

Usage: python3 firmware_grabber.py
"""

import json
import os
import re
import sys
import uuid
from datetime import datetime
from pathlib import Path

import requests

SCRIPT_DIR = Path(__file__).parent
LOG_FILE = SCRIPT_DIR / "navee_api_log.json"
FW_DIR = SCRIPT_DIR / "firmware"

BASE_URLS = [
    "https://lj.naveetech.com/tundra-api",
    "https://alb.chejiyou.com/tundra-api",
    "http://naveeap.chejiyou.com/tundra-api",
]

HEADERS_BASE = {
    "platform": "android",
    "language": "en",
    "systemVersion": "14",
    "model": "SM-S928B",
    "appVersion": "2.5.0",
    "Accept": "application/json",
    "Content-Type": "application/json; charset=utf-8",
    "User-Agent": "okhttp/3.14.9",
}

# Bekannte PIDs
PIDS = {
    23452: "ST3 Pro DE (22 km/h)",
    23451: "ST3 Pro Global (30 km/h)",
    23450: "ST3 Global (25 km/h)",
}

api_log = []
token = None
base_url = BASE_URLS[0]


def log_request(method, url, headers, body, response):
    entry = {
        "timestamp": datetime.now().isoformat(),
        "method": method,
        "url": url,
        "request_headers": {k: v for k, v in headers.items() if k != "Authorization"},
        "request_body": body,
        "status_code": response.status_code,
        "response_headers": dict(response.headers),
        "response_body": None,
    }
    try:
        entry["response_body"] = response.json()
    except Exception:
        entry["response_body"] = response.text[:2000]
    api_log.append(entry)
    save_log()


def save_log():
    with open(LOG_FILE, "w") as f:
        json.dump(api_log, f, indent=2, ensure_ascii=False)


def get_headers():
    h = dict(HEADERS_BASE)
    if token:
        h["Authorization"] = token
    return h


def api_get(path, params=None):
    url = f"{base_url}{path}"
    h = get_headers()
    print(f"\n→ GET {url}")
    if params:
        print(f"  Params: {params}")
    r = requests.get(url, headers=h, params=params, timeout=30)
    print(f"← {r.status_code}")
    log_request("GET", url, h, params, r)
    try:
        data = r.json()
        print(f"  Response: {json.dumps(data, indent=2, ensure_ascii=False)[:1000]}")
        return data
    except Exception:
        print(f"  Response (raw): {r.text[:500]}")
        return None


def api_post(path, body):
    url = f"{base_url}{path}"
    h = get_headers()
    print(f"\n→ POST {url}")
    print(f"  Body: {json.dumps(body, indent=2)}")
    r = requests.post(url, headers=h, json=body, timeout=30)
    print(f"← {r.status_code}")
    log_request("POST", url, h, body, r)
    try:
        data = r.json()
        print(f"  Response: {json.dumps(data, indent=2, ensure_ascii=False)[:1000]}")
        return data
    except Exception:
        print(f"  Response (raw): {r.text[:500]}")
        return None


def try_login(email, password):
    """Versucht Login mit verschiedenen Feld-Kombinationen und URLs."""
    global token, base_url

    device_uuid = str(uuid.uuid4())

    login_variants = [
        ("/login", {"email": email, "passwd": password, "uuid": device_uuid}),
        ("/loginByUserName", {"userName": email, "passwd": password, "uuid": device_uuid}),
        ("/login", {"email": email, "password": password, "uuid": device_uuid}),
        ("/login", {"account": email, "passwd": password, "uuid": device_uuid}),
        ("/login", {"phone": email, "passwd": password, "uuid": device_uuid}),
    ]

    for url_base in BASE_URLS:
        base_url = url_base
        print(f"\n{'='*60}")
        print(f"Versuche Base-URL: {base_url}")
        print(f"{'='*60}")

        for path, body in login_variants:
            print(f"\n--- Versuch: {path} mit Feldern {list(body.keys())[:3]} ---")
            try:
                data = api_post(path, body)
                if data and data.get("code") == 200 and data.get("data"):
                    d = data["data"]
                    token = d.get("token") or d.get("accessToken") or d.get("auth_token")
                    if token:
                        print(f"\n✅ LOGIN ERFOLGREICH!")
                        print(f"   Token: {token[:20]}...")
                        if d.get("userId"):
                            print(f"   User ID: {d['userId']}")
                        if d.get("naveeId"):
                            print(f"   Navee ID: {d['naveeId']}")
                        return True
                    # Token könnte auch im Top-Level sein
                    for key in ["token", "accessToken", "Authorization"]:
                        if key in data:
                            token = data[key]
                            print(f"\n✅ LOGIN ERFOLGREICH! Token: {token[:20]}...")
                            return True
                elif data:
                    print(f"   Code: {data.get('code')}, Msg: {data.get('msg', 'keine Nachricht')}")
            except requests.exceptions.ConnectionError as e:
                print(f"   Verbindungsfehler: {e}")
            except Exception as e:
                print(f"   Fehler: {e}")

    return False


def get_vehicles():
    """Listet alle gebundenen Geräte auf."""
    print(f"\n{'='*60}")
    print("GERÄTE ABRUFEN")
    print(f"{'='*60}")

    for path in ["/vehicle/getVehicle", "/vehicle/list", "/device/list"]:
        data = api_get(path)
        if data and data.get("code") == 200 and data.get("data"):
            vehicles = data["data"]
            if isinstance(vehicles, list):
                print(f"\n📱 {len(vehicles)} Gerät(e) gefunden:")
                for i, v in enumerate(vehicles):
                    print(f"\n  Gerät {i+1}:")
                    for key in ["mac", "pid", "vehicleName", "model", "sn", "firmwareVersion",
                                "vehicleModelId", "id", "carNo"]:
                        if key in v and v[key]:
                            print(f"    {key}: {v[key]}")
                    # PID-Info
                    pid = v.get("pid")
                    if pid and int(pid) in PIDS:
                        print(f"    → {PIDS[int(pid)]}")
                return vehicles
            elif isinstance(vehicles, dict):
                print(f"\n📱 Gerät gefunden:")
                print(f"  {json.dumps(vehicles, indent=2, ensure_ascii=False)[:500]}")
                return [vehicles]
    return []


def check_firmware(vehicle):
    """Prüft auf Firmware-Updates."""
    print(f"\n{'='*60}")
    print("FIRMWARE-CHECK")
    print(f"{'='*60}")

    vehicle_model_id = vehicle.get("vehicleModelId") or vehicle.get("modelId") or vehicle.get("pid")

    # Alte Versions-Strings um Update zu erzwingen
    old_versions = [
        {"meter": "1.0.0", "bldc": "1.0.0", "bms": "1.0.0", "screen": "1.0.0"},
        {"meter": "0.0.1", "bldc": "0.0.1", "bms": "0.0.1", "screen": "0.0.1"},
        {"meter": "1004", "bldc": "1004", "bms": "1004", "screen": "1004"},
        {"meter": "2031001510", "bldc": "2031001510", "bms": "2031001510", "screen": "2031001510"},
    ]

    firmware_urls = []

    for versions in old_versions:
        body = {"vehicleModelId": str(vehicle_model_id)}
        body.update(versions)

        print(f"\n--- Versuch mit Versionen: {versions['meter']} ---")
        data = api_post("/vehicle/modelSoftware", body)

        if data and data.get("code") == 200 and data.get("data"):
            fw_data = data["data"]
            for component in ["meterList", "bldcList", "bmsList", "screenList"]:
                items = fw_data.get(component, [])
                if items:
                    print(f"\n  🔧 {component}:")
                    for item in items:
                        version = item.get("version", "?")
                        url = item.get("fileUrl") or item.get("url") or item.get("downloadUrl")
                        size = item.get("fileSize", "?")
                        print(f"    Version: {version}, Size: {size}, URL: {url}")
                        if url:
                            firmware_urls.append({
                                "component": component.replace("List", ""),
                                "version": version,
                                "url": url,
                                "size": size,
                            })

        if firmware_urls:
            break

    # Fallback: direkte Firmware-Endpoints
    if not firmware_urls:
        print("\n--- Fallback: direkte Firmware-Endpoints ---")
        for path in ["/firmware/check", "/firmware/latest"]:
            params = {
                "pid": vehicle.get("pid", "23452"),
                "version": "1.0.0",
                "model": "ST3PRO",
            }
            data = api_get(path, params)
            if data and data.get("data"):
                url = None
                d = data["data"]
                if isinstance(d, dict):
                    url = d.get("fileUrl") or d.get("url") or d.get("downloadUrl")
                if url:
                    firmware_urls.append({"component": "firmware", "version": "?", "url": url, "size": "?"})

    return firmware_urls


def download_firmware(fw_list):
    """Lädt Firmware-Binaries herunter."""
    print(f"\n{'='*60}")
    print("FIRMWARE DOWNLOAD")
    print(f"{'='*60}")

    FW_DIR.mkdir(exist_ok=True)

    for fw in fw_list:
        url = fw["url"]
        component = fw["component"]
        version = fw["version"]
        filename = f"navee_{component}_v{version}.bin".replace("/", "_").replace(" ", "_")
        filepath = FW_DIR / filename

        print(f"\n⬇️  Lade {component} v{version}...")
        print(f"   URL: {url}")

        try:
            r = requests.get(url, timeout=60, stream=True)
            if r.status_code == 200:
                with open(filepath, "wb") as f:
                    for chunk in r.iter_content(chunk_size=8192):
                        f.write(chunk)
                size = filepath.stat().st_size
                print(f"   ✅ Gespeichert: {filepath} ({size} Bytes)")
                analyze_firmware(filepath)
            else:
                print(f"   ❌ Download fehlgeschlagen: HTTP {r.status_code}")
        except Exception as e:
            print(f"   ❌ Fehler: {e}")


def analyze_firmware(filepath):
    """Analysiert eine Firmware-Binary."""
    print(f"\n{'='*60}")
    print(f"ANALYSE: {filepath.name}")
    print(f"{'='*60}")

    data = filepath.read_bytes()
    size = len(data)
    print(f"Dateigröße: {size} Bytes ({size/1024:.1f} KB)")

    # Hex-Dump erste 256 Bytes
    print(f"\nErste 256 Bytes:")
    for i in range(0, min(256, size), 16):
        hex_part = " ".join(f"{b:02X}" for b in data[i:i+16])
        ascii_part = "".join(chr(b) if 32 <= b < 127 else "." for b in data[i:i+16])
        print(f"  {i:04X}: {hex_part:<48s} {ascii_part}")

    # String-Suche
    print(f"\nString-Suche:")
    search_strings = ["23452", "23451", "speed", "limit", "pid", "max", "ST3", "N65C", "NAVEE", "navee"]
    text = data.decode("latin-1")
    for s in search_strings:
        positions = [m.start() for m in re.finditer(re.escape(s), text, re.IGNORECASE)]
        if positions:
            print(f"  '{s}' gefunden an Offsets: {positions[:10]}")
            for pos in positions[:3]:
                ctx_start = max(0, pos - 8)
                ctx_end = min(size, pos + len(s) + 8)
                ctx_hex = " ".join(f"{b:02X}" for b in data[ctx_start:ctx_end])
                print(f"    Kontext: {ctx_hex}")

    # PID-Suche (23452 = 0x5B9C)
    print(f"\nPID 23452 (0x5B9C) Suche:")
    pid_be = bytes([0x5B, 0x9C])
    pid_le = bytes([0x9C, 0x5B])
    for label, pattern in [("Big-Endian", pid_be), ("Little-Endian", pid_le)]:
        pos = 0
        found = []
        while True:
            pos = data.find(pattern, pos)
            if pos == -1:
                break
            found.append(pos)
            pos += 1
        if found:
            print(f"  {label}: gefunden an Offsets {found[:10]}")
            for p in found[:3]:
                ctx = data[max(0, p-4):p+6]
                print(f"    Kontext: {' '.join(f'{b:02X}' for b in ctx)}")

    # Speed-Limit Suche (0x16 = 22 in verdächtigen Kontexten)
    print(f"\nSpeed-Limit Kontexte (Byte 0x16 = 22 dez):")
    count = 0
    for i in range(len(data) - 4):
        if data[i] == 0x16:
            # Suche Kontexte die nach Konfiguration aussehen
            ctx = data[max(0, i-4):i+5]
            # Interessant wenn umgeben von kleinen Werten (0-100)
            if all(b < 128 for b in ctx):
                if count < 20:
                    print(f"  Offset 0x{i:04X}: {' '.join(f'{b:02X}' for b in ctx)}")
                count += 1
    print(f"  ({count} Vorkommen gesamt)")


def main():
    print("=" * 60)
    print("  NAVEE ST3 PRO — FIRMWARE GRABBER")
    print("  API: https://lj.naveetech.com/tundra-api")
    print("=" * 60)

    # Credentials
    print("\nNavee Account Credentials:")
    email = input("  Email/Username: ").strip()
    password = input("  Passwort: ").strip()

    if not email or not password:
        print("❌ Email und Passwort erforderlich!")
        sys.exit(1)

    # Login
    if not try_login(email, password):
        print("\n❌ Login fehlgeschlagen mit allen Varianten.")
        print(f"   Log gespeichert in: {LOG_FILE}")
        sys.exit(1)

    # Geräte abrufen
    vehicles = get_vehicles()

    if not vehicles:
        print("\n⚠️  Keine Geräte gefunden. Versuche trotzdem Firmware-Check...")
        vehicles = [{"pid": "23452", "vehicleModelId": "23452"}]

    # Firmware für jedes Gerät prüfen
    all_firmware = []
    for v in vehicles:
        fw = check_firmware(v)
        all_firmware.extend(fw)

    if all_firmware:
        print(f"\n🎉 {len(all_firmware)} Firmware-Datei(en) gefunden!")
        download_firmware(all_firmware)
    else:
        print("\n⚠️  Keine Firmware-Downloads gefunden.")
        print("   Mögliche Gründe:")
        print("   - Firmware ist bereits aktuell")
        print("   - vehicleModelId stimmt nicht")
        print("   - API-Endpunkt hat sich geändert")

    print(f"\n📄 Vollständiger API-Log: {LOG_FILE}")
    save_log()


if __name__ == "__main__":
    main()

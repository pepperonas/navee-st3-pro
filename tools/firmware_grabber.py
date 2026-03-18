#!/usr/bin/env python3
"""
Navee ST3 Pro Firmware Grabber
Lädt Firmware-Binaries von der Navee Server-API herunter und analysiert sie.

API: https://lj.naveetech.com/tundra-api
Login: email + passwd (imgCode kann leer sein)
Firmware: POST /vehicle/modelSoftware mit vehicleModelId

Usage: python3 firmware_grabber.py
"""

import json
import os
import re
import struct
import sys
from datetime import datetime
from pathlib import Path

import requests

SCRIPT_DIR = Path(__file__).parent
LOG_FILE = SCRIPT_DIR / "navee_api_log.json"
FW_DIR = SCRIPT_DIR / "firmware"

BASE_URL = "https://lj.naveetech.com/tundra-api"

HEADERS = {
    "platform": "android",
    "language": "en",
    "systemVersion": "14",
    "model": "SM-S928B",
    "appVersion": "2.5.0",
    "Accept": "application/json",
    "Content-Type": "application/json; charset=utf-8",
    "User-Agent": "okhttp/3.14.9",
}

# Bekannte Modelle
KNOWN_MODELS = {
    3801: ("ST3 PRO", "23452", "DE 22 km/h"),
    3701: ("ST3", "24012", "Global"),
    4901: ("ST5 Pro", "24412", ""),
}

api_log = []


def log_api(method, url, body, response):
    entry = {
        "ts": datetime.now().isoformat(),
        "method": method, "url": url,
        "body": body, "status": response.status_code,
    }
    try:
        entry["response"] = response.json()
    except Exception:
        entry["response"] = response.text[:2000]
    api_log.append(entry)


def api(method, path, token=None, body=None, params=None):
    url = f"{BASE_URL}{path}"
    h = dict(HEADERS)
    if token:
        h["Authorization"] = token
    print(f"\n→ {method} {path}")
    if body:
        print(f"  Body: {json.dumps(body)[:200]}")
    r = getattr(requests, method.lower())(url, headers=h, json=body, params=params, timeout=30)
    log_api(method, url, body, r)
    try:
        data = r.json()
        code = data.get("code")
        msg = data.get("msg", "")
        if code == 200:
            print(f"← 200 OK")
        else:
            print(f"← {code}: {msg}")
        return data
    except Exception:
        print(f"← HTTP {r.status_code}: {r.text[:200]}")
        return None


def login(email, passwd):
    """Login — imgCode kann leer sein."""
    data = api("POST", "/login", body={
        "email": email, "passwd": passwd, "uuid": "navee-grabber", "imgCode": ""
    })
    if data and data.get("code") == 200 and data.get("data"):
        token = data["data"].get("token")
        uid = data["data"].get("userId")
        print(f"  ✅ Login OK — User ID: {uid}")
        return token
    return None


def get_models(token):
    """Alle verfügbaren Modelle abrufen."""
    data = api("GET", "/vehicle/model", token=token)
    if data and data.get("code") == 200 and data.get("data"):
        models = data["data"]
        print(f"\n📋 {len(models)} Modelle verfügbar:")
        for m in models:
            marker = " ← UNSER MODELL" if str(m.get("pid")) == "23452" else ""
            print(f"  id={m['id']:5} pid={m.get('pid','?'):6} type={m.get('type','?')}{marker}")
        return models
    return []


def get_vehicles(token):
    """Gebundene Geräte abrufen."""
    data = api("GET", "/vehicle/getVehicle", token=token)
    if data and data.get("code") == 200:
        vehicles = data.get("data", [])
        if vehicles:
            print(f"\n📱 {len(vehicles)} Gerät(e):")
            for v in vehicles:
                print(f"  MAC={v.get('mac')} PID={v.get('pid')} Name={v.get('vehicleName')}")
        else:
            print("  Keine gebundenen Geräte")
        return vehicles
    return []


def check_firmware(token, model_id, model_name=""):
    """Firmware-Check mit absichtlich alter Version."""
    print(f"\n🔍 Firmware-Check für {model_name} (modelId={model_id})...")
    data = api("POST", "/vehicle/modelSoftware", token=token, body={
        "vehicleModelId": str(model_id),
        "meter": "1.0.0", "bldc": "1.0.0", "bms": "1.0.0", "screen": "1.0.0"
    })
    if not data or data.get("code") != 200 or not data.get("data"):
        return []

    fw_data = data["data"]
    firmware = []
    for component in ["meterList", "bldcList", "bmsList", "screenList"]:
        for item in fw_data.get(component, []):
            fw = {
                "component": component.replace("List", ""),
                "version": item.get("vn", "?"),
                "url": item.get("fileUrl", ""),
                "notes": item.get("context", ""),
            }
            if fw["url"]:
                print(f"  🔧 {fw['component']} v{fw['version']}: {fw['notes'][:60]}")
                firmware.append(fw)
    return firmware


def download_firmware(fw_list):
    """Firmware-Binaries herunterladen."""
    FW_DIR.mkdir(exist_ok=True)
    paths = []
    for fw in fw_list:
        filename = f"navee_{fw['component']}_v{fw['version']}.bin"
        filepath = FW_DIR / filename
        print(f"\n⬇️  {fw['component']} v{fw['version']}...")
        r = requests.get(fw["url"], timeout=60)
        if r.status_code == 200:
            filepath.write_bytes(r.content)
            print(f"  ✅ {filepath} ({len(r.content)} Bytes)")
            paths.append(filepath)
        else:
            print(f"  ❌ HTTP {r.status_code}")
    return paths


def analyze_firmware(filepath):
    """Firmware-Binary analysieren."""
    data = filepath.read_bytes()
    size = len(data)
    print(f"\n{'='*60}")
    print(f"ANALYSE: {filepath.name} ({size} Bytes, {size/1024:.1f} KB)")
    print(f"{'='*60}")

    # Header
    header_str = data[:16].decode("latin-1")
    print(f"\nHeader: {header_str!r}")
    print(f"  Modell-ID: {data[:5].decode('latin-1')}")
    print(f"  Typ-Byte: 0x{data[6]:02X}")
    print(f"  Version: {data[7:15].decode('latin-1')}")

    # Hex-Dump erste 128 Bytes
    print(f"\nHex-Dump (erste 128 Bytes):")
    for i in range(0, min(128, size), 16):
        h = " ".join(f"{b:02X}" for b in data[i:i+16])
        a = "".join(chr(b) if 32 <= b < 127 else "." for b in data[i:i+16])
        print(f"  {i:04X}: {h:<48s} {a}")

    # String-Suche
    print(f"\nString-Suche:")
    text = data.decode("latin-1")
    searches = {
        "Speed-relevante": ["speed", "limit", "max_speed", "speed_limit", "velocity", "kmh", "km/h"],
        "Modell/PID": ["23452", "23451", "ST3", "T2202", "pid"],
        "Konfiguration": ["config", "setting", "param", "mode", "eco", "sport"],
        "Navee": ["NAVEE", "navee", "Navee"],
        "Version": ["1004", "2031", "version", "firmware"],
    }
    for category, terms in searches.items():
        found_any = False
        for s in terms:
            positions = [m.start() for m in re.finditer(re.escape(s), text, re.IGNORECASE)]
            if positions:
                if not found_any:
                    print(f"\n  [{category}]")
                    found_any = True
                print(f"    \"{s}\" × {len(positions)} bei: {positions[:8]}")
                for pos in positions[:3]:
                    # Extrahiere lesbaren Kontext
                    ctx_start = max(0, pos - 16)
                    ctx_end = min(size, pos + len(s) + 32)
                    ctx_bytes = data[ctx_start:ctx_end]
                    ctx_str = "".join(chr(b) if 32 <= b < 127 else "." for b in ctx_bytes)
                    print(f"      → \"{ctx_str}\"")

    # PID-Pattern
    print(f"\nPID 23452 als Bytes:")
    for label, pat in [
        ("0x5B9C (BE)", bytes([0x5B, 0x9C])),
        ("0x9C5B (LE)", bytes([0x9C, 0x5B])),
        ("ASCII '23452'", b"23452"),
    ]:
        pos = data.find(pat)
        if pos >= 0:
            ctx = data[max(0, pos-4):pos+len(pat)+4]
            print(f"  {label}: Offset 0x{pos:04X} — {' '.join(f'{b:02X}' for b in ctx)}")
        else:
            print(f"  {label}: nicht gefunden")

    # Speed-Wert Suche: 22 (0x16) in verdächtigen Kontexten
    print(f"\nSpeed-Limit Kandidaten (Byte 0x16=22 in Config-Kontexten):")
    candidates = []
    for i in range(2, len(data) - 2):
        if data[i] == 0x16:
            neighbors = data[max(0, i-2):i+3]
            # Interessant wenn umgeben von kleinen Werten (potenzielle Konfig-Tabelle)
            if all(b < 80 for b in neighbors):
                ctx = data[max(0, i-8):i+9]
                candidates.append((i, ctx))
    for i, ctx in candidates[:15]:
        print(f"  0x{i:04X}: {' '.join(f'{b:02X}' for b in ctx)}")
    print(f"  ({len(candidates)} Kandidaten gesamt)")

    # Suche nach Speed-Tabellen (aufeinanderfolgende kleine Werte)
    print(f"\nMögliche Speed-Tabellen:")
    for i in range(len(data) - 10):
        window = data[i:i+8]
        vals = list(window)
        # Suche nach aufsteigenden Werten im Bereich 15-50
        if all(15 <= v <= 50 for v in vals) and vals == sorted(vals) and len(set(vals)) >= 5:
            print(f"  0x{i:04X}: {' '.join(f'{b:02X}({b})' for b in window)}")

    return data


def main():
    print("=" * 60)
    print("  NAVEE ST3 PRO — FIRMWARE GRABBER v2")
    print("=" * 60)

    email = input("\nEmail: ").strip()
    passwd = input("Passwort: ").strip()
    if not email or not passwd:
        print("❌ Credentials erforderlich")
        sys.exit(1)

    # Login
    token = login(email, passwd)
    if not token:
        print("❌ Login fehlgeschlagen")
        sys.exit(1)

    # Geräte
    get_vehicles(token)

    # Modelle
    models = get_models(token)

    # Firmware für ST3 Pro (modelId=3801) + andere interessante Modelle
    target_ids = [
        (3801, "ST3 PRO (DE)"),
        (3701, "ST3"),
    ]

    all_fw = []
    for mid, name in target_ids:
        fw = check_firmware(token, mid, name)
        all_fw.extend(fw)

    if not all_fw:
        print("\n⚠️  Keine Firmware gefunden")
    else:
        print(f"\n🎉 {len(all_fw)} Firmware-Datei(en) gefunden!")
        paths = download_firmware(all_fw)
        for p in paths:
            analyze_firmware(p)

    # Log speichern
    with open(LOG_FILE, "w") as f:
        json.dump(api_log, f, indent=2, ensure_ascii=False)
    print(f"\n📄 API-Log: {LOG_FILE}")


if __name__ == "__main__":
    main()

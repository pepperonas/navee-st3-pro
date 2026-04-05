#!/usr/bin/env python3
"""
Navee Firmware Grabber — BLDC Hunter

Erweiterte Version des firmware_grabber.py, spezialisiert auf:
- Systematisches Abfragen ALLER Firmware-Typen (Meter, BLDC, BMS, Screen)
- Testen verschiedener PIDs/Model-IDs (DE, Global, US, etc.)
- Absichtlich alte Versionen senden um Updates zu erzwingen
- Detailliertes Logging welche Listen befüllt zurückkommen

Auth: Unterstützt Email/Passwort UND Google-Login (via /loginByOther)
API: https://lj.naveetech.com/tundra-api

Google-Login-Flow (aus APK-Decompilation):
  1. App nutzt ShareSDK (MobTech) für Google Sign-In
  2. Nach Google-Auth: POST /loginByOther mit loginType=2, uid, raw, nickName, icon
  3. Server gibt UserSession mit token zurück (identisch zu Email-Login)
"""

import json
import os
import re
import struct
import subprocess
import sys
import webbrowser
from datetime import datetime
from pathlib import Path

import requests

SCRIPT_DIR = Path(__file__).parent
LOG_FILE = SCRIPT_DIR / "bldc_hunt_log.json"
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

# Alle bekannten Model-IDs mit PID und Region
# Format: (modelId, name, pid, region)
KNOWN_MODELS = [
    (3801, "ST3 PRO", "23452", "DE 22km/h"),
    (3701, "ST3", "24012", "Global"),
    (4901, "ST5 Pro", "24412", ""),
]

# Zusätzliche Model-IDs zum Testen (aus bekannten PIDs im ViewModel)
# PIDs aus ScooterViewModel.getMaxSpeedOptionsForPID()
EXTRA_MODEL_IDS_TO_PROBE = list(range(3600, 3900)) + list(range(4800, 5100))

# Firmware-Komponenten
COMPONENTS = ["meterList", "bldcList", "bmsList", "screenList"]
COMPONENT_NAMES = {
    "meterList": "Meter (Dashboard)",
    "bldcList": "BLDC (Motor Controller)",
    "bmsList": "BMS (Battery)",
    "screenList": "Screen (Display)",
}

api_log = []
hunt_results = []


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
    r = getattr(requests, method.lower())(url, headers=h, json=body, params=params, timeout=30)
    log_api(method, url, body, r)
    try:
        return r.json()
    except Exception:
        return None


def login_email(email, passwd):
    """Login via Email/Passwort."""
    print("Login via Email/Passwort...")
    data = api("POST", "/login", body={
        "email": email, "passwd": passwd, "uuid": "navee-grabber", "imgCode": ""
    })
    if data and data.get("code") == 200 and data.get("data"):
        token = data["data"].get("token")
        print(f"  Login OK (userId={data['data'].get('userId')})")
        return token
    print(f"  Login FAILED: {data}")
    return None


def login_google(google_uid, google_raw="", nickname="", icon=""):
    """Login via Google Account (APK-Endpoint: /loginByOther).

    From APK decompilation (LoginActivity.java):
      - loginType=1: Facebook
      - loginType=2: Google
      - uid: Google User ID (from GoogleSignInAccount.getId())
      - raw: Full ShareSDK export data (JSON string with all Google profile data)
      - nickName: Display name
      - icon: Profile photo URL
    """
    print("Login via Google (/loginByOther)...")

    # Build ShareSDK-compatible raw export if not provided
    # The official app sends platform.getDb().exportData() which is a JSON string
    # containing the Google profile data. Server validates "content" field exists.
    if not google_raw:
        raw_data = {
            "id": google_uid,
            "nickname": nickname or "",
            "email": "",
            "picture": icon or "",
            "family_name": "",
            "given_name": nickname or "",
            "requestedScopes": "",
            "isSigin": "true",
            "token": "",
            "idToken": "",
            "content": nickname or google_uid,  # Server requires this field
        }
        google_raw = json.dumps(raw_data)

    body = {
        "loginType": "2",
        "uid": google_uid,
        "raw": google_raw,
    }
    if nickname:
        body["nickName"] = nickname
    if icon:
        body["icon"] = icon

    data = api("POST", "/loginByOther", body=body)
    if data and data.get("code") == 200 and data.get("data"):
        token = data["data"].get("token")
        uid = data["data"].get("userId")
        print(f"  Google Login OK (userId={uid})")
        return token

    # Detailliertes Fehler-Logging
    if data:
        print(f"  Google Login FAILED: code={data.get('code')}, msg={data.get('msg')}")
    else:
        print("  Google Login FAILED: keine Antwort")
    return None


def login_interactive():
    """Interaktiver Login — wählt Methode basierend auf User-Input."""
    print("\n  Login-Methoden:")
    print("  [1] Email + Passwort")
    print("  [2] Google Account (User-ID)")
    print("  [3] Gespeicherter Token")
    choice = input("\n  Auswahl (1/2/3): ").strip()

    if choice == "1":
        email = input("  Email: ").strip()
        passwd = input("  Passwort: ").strip()
        if not email or not passwd:
            print("  Credentials erforderlich")
            return None
        return login_email(email, passwd)

    elif choice == "2":
        print("\n  Google-Login benötigt deine Google User-ID.")
        print("  Diese findest du in der Navee App oder via Google Account Settings.")
        print("  Format: numerische ID, z.B. '118234567890123456789'")
        print()
        google_uid = input("  Google User-ID: ").strip()
        if not google_uid:
            print("  User-ID erforderlich")
            return None
        nickname = input("  Display Name (optional, Enter=skip): ").strip()
        return login_google(google_uid, nickname=nickname)

    elif choice == "3":
        token = input("  Token: ").strip()
        if not token:
            print("  Token erforderlich")
            return None
        # Validiere Token mit einem einfachen API-Call
        print("  Teste Token...")
        data = api("GET", "/vehicle/getVehicle", token=token)
        if data and data.get("code") == 200:
            print("  Token gültig!")
            return token
        else:
            print(f"  Token ungültig: {data}")
            return None

    else:
        print("  Ungültige Auswahl")
        return None


def get_all_models(token):
    """Alle verfügbaren Modelle abrufen und zurückgeben."""
    data = api("GET", "/vehicle/model", token=token)
    if data and data.get("code") == 200 and data.get("data"):
        models = data["data"]
        print(f"\n{'='*70}")
        print(f"  {len(models)} MODELLE AUF DEM SERVER")
        print(f"{'='*70}")
        for m in models:
            print(f"  id={m['id']:5}  pid={str(m.get('pid','?')):>6}  "
                  f"type={m.get('type','?'):10}  name={m.get('vehicleModelName','?')}")
        return models
    return []


def check_firmware_extended(token, model_id, model_name="", versions=None):
    """Firmware-Check mit konfigurierbaren Versionsstrings.

    versions: dict mit Keys meter, bldc, bms, screen (default: alle "0.0.0.1")
    """
    if versions is None:
        versions = {}

    body = {
        "vehicleModelId": str(model_id),
        "meter": versions.get("meter", "0.0.0.1"),
        "bldc": versions.get("bldc", "0.0.0.1"),
        "bms": versions.get("bms", "0.0.0.1"),
        "screen": versions.get("screen", "0.0.0.1"),
    }

    data = api("POST", "/vehicle/modelSoftware", token=token, body=body)

    result = {
        "model_id": model_id,
        "model_name": model_name,
        "versions_sent": body,
        "ts": datetime.now().isoformat(),
        "populated_lists": [],
        "firmware": [],
        "api_code": None,
        "api_msg": "",
    }

    if not data:
        result["api_code"] = "no_response"
        return result

    result["api_code"] = data.get("code")
    result["api_msg"] = data.get("msg", "")

    if data.get("code") != 200 or not data.get("data"):
        return result

    fw_data = data["data"]

    for component in COMPONENTS:
        items = fw_data.get(component, [])
        if items:
            result["populated_lists"].append(component)
        for item in items:
            fw = {
                "component": component.replace("List", ""),
                "component_full": COMPONENT_NAMES.get(component, component),
                "version": item.get("vn", "?"),
                "url": item.get("fileUrl", ""),
                "notes": item.get("context", ""),
                "id": item.get("id", ""),
                "raw": item,
            }
            result["firmware"].append(fw)

    return result


def download_firmware(fw_entry, tag=""):
    """Einzelne Firmware herunterladen."""
    FW_DIR.mkdir(exist_ok=True)
    comp = fw_entry["component"]
    ver = fw_entry["version"]
    suffix = f"_{tag}" if tag else ""
    suffix = re.sub(r'[/\\:*?"<>|]', '_', suffix)  # sanitize for filesystem
    filename = f"navee_{comp}_v{ver}{suffix}.bin"
    filepath = FW_DIR / filename

    if filepath.exists():
        print(f"  Existiert bereits: {filepath.name}")
        return filepath

    url = fw_entry.get("url", "")
    if not url:
        print(f"  Keine URL für {comp} v{ver}")
        return None

    print(f"  Downloading {comp} v{ver}...")
    r = requests.get(url, timeout=60)
    if r.status_code == 200:
        filepath.write_bytes(r.content)
        print(f"  -> {filepath.name} ({len(r.content)} Bytes)")
        return filepath
    else:
        print(f"  FEHLER HTTP {r.status_code}")
        return None


def analyze_firmware_header(filepath):
    """Firmware-Header analysieren und zusammenfassen."""
    data = filepath.read_bytes()
    size = len(data)

    info = {
        "filename": filepath.name,
        "size": size,
        "size_kb": round(size / 1024, 1),
    }

    if size >= 16:
        try:
            info["model_string"] = data[:6].decode("latin-1").rstrip("\x00")
        except Exception:
            info["model_string"] = "?"
        info["type_byte"] = f"0x{data[6]:02X}"
        type_names = {0x01: "Meter", 0x02: "BLDC", 0x03: "BMS", 0x04: "Screen"}
        info["type_name"] = type_names.get(data[6], f"Unknown(0x{data[6]:02X})")
        try:
            info["version_string"] = data[7:15].decode("latin-1").rstrip("\x00")
        except Exception:
            info["version_string"] = "?"

        # Hex-Dump Header
        info["header_hex"] = " ".join(f"{b:02X}" for b in data[:16])
        info["header_ascii"] = "".join(chr(b) if 32 <= b < 127 else "." for b in data[:16])

    return info


def print_result_summary(result):
    """Kompakte Zusammenfassung eines Firmware-Check-Ergebnisses."""
    model = f"{result['model_name']} (id={result['model_id']})"
    code = result["api_code"]

    if code != 200:
        print(f"  {model}: API {code} — {result['api_msg']}")
        return

    populated = result["populated_lists"]
    if not populated:
        print(f"  {model}: KEINE Firmware verfügbar (alle Listen leer)")
    else:
        parts = []
        for comp in COMPONENTS:
            count = len([f for f in result["firmware"] if f["component"] == comp.replace("List", "")])
            if comp in populated:
                parts.append(f"{comp.replace('List','').upper()}={count}")
            else:
                parts.append(f"{comp.replace('List','').upper()}=0")
        fw_str = ", ".join(parts)
        print(f"  {model}: {fw_str}")

        # Detail für gefundene Firmware
        for fw in result["firmware"]:
            url_short = fw["url"][-40:] if fw["url"] else "NO URL"
            print(f"    -> {fw['component_full']} v{fw['version']}: ...{url_short}")


def main():
    print("=" * 70)
    print("  NAVEE FIRMWARE GRABBER — BLDC HUNTER")
    print("  Systematische Suche nach Motor Controller Firmware")
    print("=" * 70)

    token = login_interactive()
    if not token:
        print("Login fehlgeschlagen")
        sys.exit(1)

    # --- Phase 1: Alle Modelle vom Server holen ---
    all_models = get_all_models(token)

    # --- Phase 2: Firmware für bekannte Model-IDs abfragen ---
    print(f"\n{'='*70}")
    print("  PHASE 2: FIRMWARE-CHECK BEKANNTE MODELLE")
    print(f"{'='*70}")

    # Absichtlich uralte Versionen für alle Komponenten
    old_versions = {
        "meter": "0.0.0.1",
        "bldc": "0.0.0.1",
        "bms": "0.0.0.1",
        "screen": "0.0.0.1",
    }

    # Bekannte Model-IDs + alle vom Server
    model_ids_to_check = []

    # Erst die bekannten
    for mid, name, pid, region in KNOWN_MODELS:
        model_ids_to_check.append((mid, f"{name} ({region}, pid={pid})"))

    # Dann alle vom Server die wir noch nicht haben
    known_ids = {m[0] for m in KNOWN_MODELS}
    for m in all_models:
        mid = m.get("id")
        if mid and mid not in known_ids:
            name = m.get("vehicleModelName", m.get("type", "?"))
            pid = m.get("pid", "?")
            model_ids_to_check.append((mid, f"{name} (pid={pid})"))

    bldc_found = []

    for model_id, model_name in model_ids_to_check:
        result = check_firmware_extended(token, model_id, model_name, old_versions)
        hunt_results.append(result)
        print_result_summary(result)

        # BLDC gefunden?
        for fw in result["firmware"]:
            if fw["component"] == "bldc":
                print(f"\n  *** BLDC FIRMWARE GEFUNDEN: {model_name} ***")
                bldc_found.append((result, fw))

    # --- Phase 3: Ergebnisübersicht ---
    print(f"\n{'='*70}")
    print("  ERGEBNIS-ZUSAMMENFASSUNG")
    print(f"{'='*70}")

    print(f"\n  Modelle geprüft: {len(model_ids_to_check)}")

    # Aggregiere welche Komponenten überhaupt verfügbar sind
    all_populated = set()
    for r in hunt_results:
        for comp in r["populated_lists"]:
            all_populated.add(comp)

    print(f"  Verfügbare Firmware-Typen:")
    for comp in COMPONENTS:
        status = "JA" if comp in all_populated else "NEIN"
        count = sum(1 for r in hunt_results for f in r["firmware"] if f["component"] == comp.replace("List", ""))
        models_with = [r["model_name"] for r in hunt_results if comp in r["populated_lists"]]
        print(f"    {COMPONENT_NAMES[comp]:30s}: {status} ({count} Einträge)")
        if models_with:
            for m in models_with[:5]:
                print(f"      - {m}")

    # --- Phase 4: BLDC Download ---
    if bldc_found:
        print(f"\n{'='*70}")
        print(f"  BLDC FIRMWARE DOWNLOAD ({len(bldc_found)} gefunden)")
        print(f"{'='*70}")

        for result, fw in bldc_found:
            tag = result["model_name"].replace(" ", "_").replace("(", "").replace(")", "")
            filepath = download_firmware(fw, tag=tag)
            if filepath:
                info = analyze_firmware_header(filepath)
                print(f"\n  Header-Analyse: {info['filename']}")
                print(f"    Size:    {info['size']} Bytes ({info['size_kb']} KB)")
                print(f"    Model:   {info.get('model_string', '?')}")
                print(f"    Type:    {info.get('type_name', '?')} ({info.get('type_byte', '?')})")
                print(f"    Version: {info.get('version_string', '?')}")
                print(f"    Header:  {info.get('header_hex', '?')}")
                print(f"    ASCII:   {info.get('header_ascii', '?')}")
    else:
        print(f"\n  KEIN BLDC-Firmware bei {len(model_ids_to_check)} Modellen gefunden.")
        print("  Mögliche Gründe:")
        print("    - BLDC-Updates sind selten / aktuell kein Update verfügbar")
        print("    - BLDC wird nur über spezielle API-Parameter ausgeliefert")
        print("    - BLDC-Update nur bei gebundenem Gerät mit passender PID")

    # --- Phase 5: Vergleich mit Meter-Firmware ---
    meter_files = list(FW_DIR.glob("navee_meter_*.bin")) if FW_DIR.exists() else []
    bldc_files = list(FW_DIR.glob("navee_bldc_*.bin")) if FW_DIR.exists() else []

    if meter_files and bldc_files:
        print(f"\n{'='*70}")
        print("  VERGLEICH: METER vs BLDC")
        print(f"{'='*70}")

        for mf in meter_files[:1]:
            mi = analyze_firmware_header(mf)
            print(f"\n  METER: {mi['filename']}")
            print(f"    Size: {mi['size']} Bytes, Model: {mi.get('model_string')}, "
                  f"Type: {mi.get('type_byte')}, Version: {mi.get('version_string')}")

        for bf in bldc_files:
            bi = analyze_firmware_header(bf)
            print(f"\n  BLDC:  {bi['filename']}")
            print(f"    Size: {bi['size']} Bytes, Model: {bi.get('model_string')}, "
                  f"Type: {bi.get('type_byte')}, Version: {bi.get('version_string')}")

            # Größenvergleich
            if meter_files:
                mi = analyze_firmware_header(meter_files[0])
                ratio = bi["size"] / mi["size"] if mi["size"] > 0 else 0
                print(f"    Ratio BLDC/Meter: {ratio:.2f}x")

    # --- Log speichern ---
    log_data = {
        "run_ts": datetime.now().isoformat(),
        "models_checked": len(model_ids_to_check),
        "bldc_found": len(bldc_found),
        "hunt_results": hunt_results,
        "api_log": api_log,
    }
    with open(LOG_FILE, "w") as f:
        json.dump(log_data, f, indent=2, ensure_ascii=False, default=str)
    print(f"\n  Log: {LOG_FILE}")


if __name__ == "__main__":
    main()

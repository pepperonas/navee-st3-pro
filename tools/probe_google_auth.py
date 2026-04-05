#!/usr/bin/env python3
"""
Navee API — Google Auth Endpoint Probe

Testet verschiedene Endpoints die chinesische Apps typischerweise
für Google/Third-Party-Login verwenden.

Usage: python3 probe_google_auth.py
"""

import json
import requests

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

# Typische Endpoints für Google-Login bei chinesischen IoT-Apps
PROBE_ENDPOINTS = [
    # Third-party login variants
    ("POST", "/thirdPartyLogin", {"type": "google", "token": "probe", "uuid": "navee-probe"}),
    ("POST", "/third/login", {"type": "google", "token": "probe", "uuid": "navee-probe"}),
    ("POST", "/thirdLogin", {"type": 2, "accessToken": "probe", "uuid": "navee-probe"}),
    ("POST", "/user/thirdLogin", {"type": "google", "token": "probe"}),
    ("POST", "/auth/google", {"idToken": "probe"}),
    ("POST", "/oauth/google", {"token": "probe"}),
    ("POST", "/login/google", {"token": "probe", "uuid": "navee-probe"}),
    ("POST", "/googleLogin", {"idToken": "probe", "uuid": "navee-probe"}),
    ("POST", "/socialLogin", {"platform": "google", "token": "probe"}),
    ("POST", "/user/socialLogin", {"platform": "google", "token": "probe"}),
    # Firebase-based
    ("POST", "/firebase/login", {"token": "probe"}),
    ("POST", "/login/firebase", {"idToken": "probe"}),
    # Generischer Login mit type-Parameter
    ("POST", "/login", {"type": 2, "token": "probe", "uuid": "navee-probe", "imgCode": ""}),
    ("POST", "/login", {"type": "google", "token": "probe", "uuid": "navee-probe", "imgCode": ""}),
    ("POST", "/login", {"loginType": "google", "accessToken": "probe", "uuid": "navee-probe"}),
    # User info / token refresh
    ("GET", "/user/info", None),
    ("GET", "/user/getUserInfo", None),
]


def probe():
    print("=" * 60)
    print("  NAVEE API — GOOGLE AUTH ENDPOINT PROBE")
    print("=" * 60)
    print(f"\n  Base: {BASE_URL}")
    print(f"  Testing {len(PROBE_ENDPOINTS)} endpoints...\n")

    interesting = []

    for method, path, body in PROBE_ENDPOINTS:
        url = f"{BASE_URL}{path}"
        try:
            if method == "POST":
                r = requests.post(url, headers=HEADERS, json=body, timeout=10)
            else:
                r = requests.get(url, headers=HEADERS, timeout=10)

            try:
                data = r.json()
                code = data.get("code", "?")
                msg = data.get("msg", "")
            except Exception:
                code = f"HTTP {r.status_code}"
                msg = r.text[:100]

            # Interessant = alles was NICHT 404 ist
            is_interesting = r.status_code != 404 and code != 404
            marker = " <<<" if is_interesting else ""

            print(f"  {method:4} {path:30} -> code={code}, msg={msg[:50]}{marker}")

            if is_interesting:
                interesting.append({
                    "method": method, "path": path, "body": body,
                    "http_status": r.status_code, "api_code": code, "msg": msg,
                    "full_response": data if isinstance(data, dict) else r.text[:500],
                })

        except requests.exceptions.ConnectionError:
            print(f"  {method:4} {path:30} -> CONNECTION ERROR")
        except requests.exceptions.Timeout:
            print(f"  {method:4} {path:30} -> TIMEOUT")
        except Exception as e:
            print(f"  {method:4} {path:30} -> ERROR: {e}")

    print(f"\n{'='*60}")
    print(f"  {len(interesting)} interessante Endpoints gefunden")
    print(f"{'='*60}")

    for ep in interesting:
        print(f"\n  {ep['method']} {ep['path']}")
        print(f"  Body: {json.dumps(ep['body'])[:100]}")
        print(f"  Response: {json.dumps(ep['full_response'], ensure_ascii=False)[:200]}")

    # Save results
    outfile = "probe_google_auth_results.json"
    with open(outfile, "w") as f:
        json.dump(interesting, f, indent=2, ensure_ascii=False)
    print(f"\n  Results: {outfile}")


if __name__ == "__main__":
    probe()

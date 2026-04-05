#!/usr/bin/env python3
"""
Fetch bound vehicle info from Navee API to find the correct device ID for BLE auth.
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


def login_google(uid, nickname=""):
    raw = json.dumps({
        "id": uid, "nickname": nickname, "email": "", "picture": "",
        "family_name": "", "given_name": nickname, "requestedScopes": "",
        "isSigin": "true", "token": "", "idToken": "", "content": nickname or uid,
    })
    r = requests.post(f"{BASE_URL}/loginByOther", headers=HEADERS,
                       json={"loginType": "2", "uid": uid, "raw": raw,
                             "nickName": nickname}, timeout=30)
    data = r.json()
    if data.get("code") == 200 and data.get("data"):
        return data["data"].get("token"), data["data"].get("userId")
    return None, None


def main():
    token, user_id = login_google("1276260019345", "Martin Pfeffer")
    if not token:
        print("Login failed")
        return

    print(f"Logged in — userId: {user_id}")
    h = dict(HEADERS)
    h["Authorization"] = token

    # Get bound vehicles
    r = requests.get(f"{BASE_URL}/vehicle/getVehicle", headers=h, timeout=30)
    data = r.json()
    print(f"\nVehicle API response:")
    print(json.dumps(data, indent=2, ensure_ascii=False))

    # Get user info
    r2 = requests.get(f"{BASE_URL}/getUser", headers=h, timeout=30)
    data2 = r2.json()
    print(f"\nUser API response:")
    print(json.dumps(data2, indent=2, ensure_ascii=False))


if __name__ == "__main__":
    main()

# BLE-Protokoll Dokumentation — Navee ST3 Pro

Vollstaendige Referenz des proprietaeren BLE-Kommunikationsprotokolls des Navee ST3 Pro E-Scooters. Basierend auf APK-Dekompilierung (jadx), BT-HCI-Captures und Live-Tests.

---

## Inhaltsverzeichnis

- [BLE UUIDs](#ble-uuids)
- [Frame-Format](#frame-format)
- [Kommando-Uebersicht](#kommando-uebersicht)
  - [Schreib-Kommandos (Einzelbyte)](#schreib-kommandos-einzelbyte)
  - [Schreib-Kommandos (Mehrbyte)](#schreib-kommandos-mehrbyte)
  - [Lese-/Status-Kommandos](#lese-status-kommandos)
  - [Authentifizierung](#authentifizierung)
  - [Telemetrie (unaufgefordert)](#telemetrie-unaufgefordert)
- [Status-Response (0x70)](#status-response-0x70)
- [Telemetrie-Parsing (0x90)](#telemetrie-parsing-0x90)
- [PID (Product ID)](#pid-product-id)
- [Max-Speed Optionen nach PID](#max-speed-optionen-nach-pid)

---

## BLE UUIDs

| Typ | UUID |
|-----|------|
| **Service** | `0000d0ff-3c17-d293-8e48-14fe2e4da212` |
| **Write Characteristic** | `0000b002-0000-1000-8000-00805f9b34fb` |
| **Notify Characteristic** | `0000b003-0000-1000-8000-00805f9b34fb` |

Der Scooter advertised den Service-UUID im BLE-Scan-Record. Die Kommunikation erfolgt ausschliesslich ueber Write (App → Scooter) und Notify (Scooter → App).

---

## Frame-Format

Jeder BLE-Frame folgt diesem Aufbau:

```
┌────────┬──────┬─────┬─────┬──────────┬──────────┬────────┐
│ Header │ Flag │ CMD │ LEN │ DATA     │ Checksum │ Footer │
│ 55 AA  │ 1B   │ 1B  │ 1B  │ LEN Byte │ 1B       │ FE FD  │
└────────┴──────┴─────┴─────┴──────────┴──────────┴────────┘
```

| Feld | Laenge | Beschreibung |
|------|--------|--------------|
| **Header** | 2 Bytes | Immer `0x55 0xAA` |
| **Flag** | 1 Byte | Richtungsflag (z.B. `0x06` fuer Write, variiert) |
| **CMD** | 1 Byte | Kommando-Byte (siehe Tabellen unten) |
| **LEN** | 1 Byte | Laenge des DATA-Feldes in Bytes |
| **DATA** | 0-n Bytes | Nutzlast, abhaengig vom Kommando |
| **Checksum** | 1 Byte | Summe aller Bytes (Header bis DATA) mod 256 |
| **Footer** | 2 Bytes | Immer `0xFE 0xFD` |

### Beispiel: Scheinwerfer einschalten

```
55 AA 06 57 01 01 FE FE FD
│  │  │  │  │  │  │  └─ Footer
│  │  │  │  │  │  └──── Checksum: (55+AA+06+57+01+01) mod 256 = FE
│  │  │  │  │  └─────── DATA: 01 (einschalten)
│  │  │  │  └────────── LEN: 01
│  │  │  └───────────── CMD: 57 (Headlight)
│  │  └──────────────── Flag: 06
│  └─────────────────── Header
└────────────────────── Header
```

---

## Kommando-Uebersicht

### Schreib-Kommandos (Einzelbyte)

Kommandos mit einem einzelnen Datenbyte als Parameter.

| CMD | Name | DATA | Beschreibung |
|-----|------|------|--------------|
| `0x50` | Unbind Vehicle | — | Fahrzeug-Bindung loesen |
| `0x51` | Lock | `0x00` = entsperren, `0x01` = sperren | Fahrzeugsperre |
| `0x52` | Cruise Control | `0x00` = aus, `0x01` = ein | Tempomat |
| `0x53` | ERS / Regen Braking | Wert | Rekuperationsbremse / Energierueckgewinnung |
| `0x55` | Mileage Unit | `0x00` = MPH, `0x01` = KM | Einheit fuer Kilometerstand |
| `0x56` | Mileage Algorithm | Wert | Kilometerstand-Algorithmus |
| `0x57` | Headlight | `0x00` = aus, `0x01` = ein | Scheinwerfer (bestaetigt via BT-Capture) |
| `0x58` | Speed Mode | `0x03` = ECO, `0x05` = SPORT | Geschwindigkeitsmodus |
| `0x59` | Reset Vehicle | — | Fahrzeug zuruecksetzen |
| `0x5A` | Tire Maintenance | Wert | Reifenwartung |
| `0x5E` | Ambient Light | `0x00` = aus, `0x01` = ein | Umgebungslicht-Sensor |
| `0x60` | Taillight | `0x00` = aus, `0x01` = ein | Ruecklicht (bestaetigt via BT-Capture) |
| `0x61` | Proximity Key | `0x00` = aus, `0x01` = ein | Naeherungsschluessel |
| `0x6A` | Startup Speed | `0x00`-`0x05` (0.0-3.0 m/s) | Anfahrgeschwindigkeit |
| `0x6B` | Custom Speed Limit | Bit 7 = aktiviert, Bits 0-6 = km/h | Benutzerdefiniertes Tempolimit |
| `0x80` | Weather Update | Wert | Wetterdaten-Update |

### Schreib-Kommandos (Mehrbyte)

Kommandos mit mehreren Datenbytes.

| CMD | Name | DATA | Beschreibung |
|-----|------|------|--------------|
| `0x63` | Set Digit Password | 6 Bytes | 6-stelliges Zahlenpasswort setzen |
| `0x67` | Light Control | variabel | Erweiterte Lichtsteuerung |
| `0x6E` | Max Speed | `[0x01, km/h]` | Maximale Geschwindigkeit — wird ACK'd, ist aber auf DE-Firmware Read-Only |
| `0x6F` | Set Scooter Parameters | variabel | Fahrzeugparameter nach Auth setzen |

#### Custom Speed Limit (`0x6B`) im Detail

Das Datenbyte ist eine Kombination aus Enable-Flag und Geschwindigkeitswert:

```
Bit 7 (0x80): Enable/Disable
Bits 0-6:     Geschwindigkeit in km/h

Beispiele:
  0x80 | 20 = 0x94  → Limit aktiviert, 20 km/h
  0x80 | 15 = 0x8F  → Limit aktiviert, 15 km/h
  0x00 | 0  = 0x00  → Limit deaktiviert
```

### Lese-/Status-Kommandos

Anfragen an den Scooter, die eine Response auf der Notify-Characteristic ausloesen.

| CMD | Name | Response-Laenge | Beschreibung |
|-----|------|-----------------|--------------|
| `0x70` | Vehicle Settings | 37 Bytes | Vollstaendiger Fahrzeugstatus (siehe [0x70 Mapping](#status-response-0x70)) |
| `0x71` | Driving/Trip Data | variabel | Fahrt- und Trip-Daten |
| `0x72` | Battery Status | 37 Bytes | Detaillierter Batterie-Status |
| `0x73` | Firmware Version | variabel | Firmware-Versionsstring |
| `0x74` | Serial Number | variabel | Seriennummer des Fahrzeugs |
| `0x75` | Battery SN | variabel | Seriennummer der Batterie |
| `0x76` | Drive History | variabel | Fahrtenverlauf |
| `0x79` | Battery Extra Info | variabel | Erweiterte Batterie-Informationen |
| `0x7A` | Password & Switch Status | variabel | Passwort- und Schalter-Status |

### Authentifizierung

| CMD | Name | Beschreibung |
|-----|------|--------------|
| `0x30` | Auth Request | Authentifizierungsanfrage (siehe [AUTHENTICATION.md](AUTHENTICATION.md)) |
| `0x31` | Auth Key | Challenge-Response Auth (nicht benoetigt fuer einfache Auth) |

### Telemetrie (unaufgefordert)

Diese Kommandos werden vom Scooter automatisch gesendet, sobald Notifications aktiviert sind.

| CMD | Name | Laenge | Beschreibung |
|-----|------|--------|--------------|
| `0x90` | Home Page Telemetry | 17 Bytes | Hauptseiten-Telemetrie (siehe [0x90 Parsing](#telemetrie-parsing-0x90)) |
| `0x91` | Realtime Status v0 | variabel | Echtzeit-Status Version 0 |
| `0x92` | Realtime Status v1 | variabel | Echtzeit-Status Version 1 |

---

## Status-Response (0x70)

Die Antwort auf CMD `0x70` liefert 37 Bytes mit dem vollstaendigen Fahrzeugstatus. Mapping basierend auf Live-Daten und APK-Analyse:

| Byte | Name | Werte | Beschreibung |
|------|------|-------|--------------|
| 0 | Binding Status | `0x00`/`0x01` | Bindungsstatus |
| 1 | Drive Mode | `0x01` = Normal | Fahrmodus |
| 2 | Speed Mode | `0x03` = ECO, `0x05` = SPORT | Geschwindigkeitsmodus |
| 3 | Lock | `0x00` = entsperrt, `0x01` = gesperrt | Fahrzeugsperre |
| 4 | Cruise Control | `0x00` = aus, `0x01` = ein | Tempomat |
| 5 | Taillight | `0x00` = aus, `0x01` = ein | Ruecklicht |
| 6 | ERS / Speed Setting | `0x3C` = 60%, `0x5A` = 90% | Rekuperationsstufe |
| 7 | Mileage Unit | `0x00` = MPH, `0x01` = KM | Entfernungseinheit |
| 8 | Auto Sensor | `0x00`/`0x01` | Automatischer Sensor |
| 9 | Headlight | `0x00` = aus, `0x01` = ein | Scheinwerfer |
| 10 | Ambient Light | `0x00` = aus, `0x01` = ein | Umgebungslicht |
| 11 | TCS Switch | `0x00`/`0x01` | Traktionskontrolle |
| 12 | Turn Sound | `0x00`/`0x01` | Blinker-Sound |
| 13 | Proximity Key | `0x00` = aus, `0x01` = ein | Naeherungsschluessel |
| 14 | Night Mode | `0x00`/`0x01` | Nachtmodus |
| 15 | Reserved | — | Reserviert |
| 16 | Reserved | — | Reserviert |
| 17 | Reserved | — | Reserviert |
| 18 | Reserved | — | Reserviert |
| 19 | Startup Speed | `0x00`-`0x05` | Anfahrgeschwindigkeit (0.0-3.0 m/s) |
| 20 | Speed Limit | Bit 7 = aktiv, Bits 0-6 = km/h | Benutzerdefiniertes Tempolimit |
| 21 | Reserved | — | Reserviert |
| 22 | Reserved | — | Reserviert |
| 23 | Reserved | — | Reserviert |
| 24 | Reserved | — | Reserviert |
| 25 | Reserved | — | Reserviert |
| 26 | Max Speed | z.B. `0x16` = 22 km/h (DE) | Firmware-Geschwindigkeitslimit (PID-abhaengig) |
| 27-36 | Reserved | — | Reserviert / unbekannt |

### Beispiel-Response (DE-Firmware)

```
Byte:  00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 ... 19 20 ... 26
Wert:  01 01 03 00 00 01 3C 01 00 01 00 00 00 00 00 ... 02 94 ... 16

Interpretation:
  Gebunden, Normal-Modus, ECO, entsperrt, kein Tempomat,
  Ruecklicht ein, ERS 60%, km-Einheit, Scheinwerfer ein,
  Startup Speed 2 (1.2 m/s), Speed Limit aktiv bei 20 km/h,
  Max Speed 22 km/h (Firmware-Cap DE)
```

---

## Telemetrie-Parsing (0x90)

Die Home-Page-Telemetrie wird kontinuierlich vom Scooter gesendet (17 Bytes Nutzdaten):

| Byte(s) | Name | Format | Beschreibung |
|---------|------|--------|--------------|
| 3 | Battery | uint8 | Akkustand in Prozent (0-100) |
| 5-6 | Speed | uint16 LE | Aktuelle Geschwindigkeit (Little-Endian, /10 fuer km/h) |
| 7 | Temperature | int8 | Temperatur in Grad Celsius |
| 9-10 | Total Distance | uint16 LE | Gesamtstrecke (Little-Endian, /10 fuer km) |

### Parsing-Beispiel

```
Rohdaten (DATA-Feld): ... 42 ... 00 C8 1E ... 03 E8 ...
                            │      │  │  │      │  │
                            │      │  │  │      └──┴── Bytes 9-10: 0x03E8 = 1000 → 100.0 km
                            │      │  │  └──────────── Byte 7: 0x1E = 30 → 30 Grad C
                            │      └──┴─────────────── Bytes 5-6: 0x00C8 = 200 → 20.0 km/h
                            └───────────────────────── Byte 3: 0x42 = 66 → 66%
```

### Speed-Berechnung (Little-Endian)

```kotlin
val speedRaw = data[5].toInt() and 0xFF or ((data[6].toInt() and 0xFF) shl 8)
val speedKmh = speedRaw / 10.0
```

---

## PID (Product ID)

Die Product ID (PID) identifiziert das Scooter-Modell und bestimmt die verfuegbaren Geschwindigkeitsoptionen.

### Extraktion aus BLE Scan Record

Die PID wird aus den Bytes 6-8 des BLE-Scan-Records extrahiert (Little-Endian):

```kotlin
val pid = scanRecord[6].toInt() and 0xFF or
         ((scanRecord[7].toInt() and 0xFF) shl 8) or
         ((scanRecord[8].toInt() and 0xFF) shl 16)
```

### PID-Tabelle (aus offizieller APK)

| PID | Modell | Markt |
|-----|--------|-------|
| 23452 | ST3 Pro | DE (Deutschland) |
| 23451 | ST3 Pro | Global |
| 23450 | ST3 | Global |

---

## Max-Speed Optionen nach PID

Die maximale Geschwindigkeit ist PID-abhaengig und firmware-seitig begrenzt. Die folgende Tabelle zeigt die verfuegbaren Optionen gemaess der offiziellen APK:

| PID | ECO (km/h) | SPORT (km/h) | Max (Firmware) | Markt |
|-----|------------|---------------|----------------|-------|
| 23452 | 6, 10, 15, 20 | 6, 10, 15, 20, 22 | **22 km/h** | DE |
| 23451 | 6, 10, 15, 20, 25 | 6, 10, 15, 20, 25, 30 | 30 km/h | Global |
| 23450 | 6, 10, 15, 20 | 6, 10, 15, 20, 25 | 25 km/h | Global |

### Wichtiger Hinweis

Der CMD `0x6E` (Max Speed) wird vom Scooter zwar mit ACK bestaetigt, aendert aber auf der DE-Firmware (PID 23452) **nicht** die tatsaechliche Hoechstgeschwindigkeit. Der Wert `0x16` (22 km/h) in Byte 26 der Status-Response ist ein **firmware-seitiges Hard-Limit**, das nicht per BLE ueberschrieben werden kann.

---

## Siehe auch

- [AUTHENTICATION.md](AUTHENTICATION.md) — Authentifizierungsablauf
- [REVERSE_ENGINEERING.md](REVERSE_ENGINEERING.md) — Reverse-Engineering Ergebnisse

#!/usr/bin/env python3
"""
BLDC Firmware Vergleich: ST3 PRO DE vs ST3 Global

Vergleicht die beiden BLDC-Firmware-Binaries auf:
- Header-Unterschiede
- Größe und Struktur
- Speed-relevante Bytes und Tabellen
- String-Unterschiede
- Byte-für-Byte Diff der gemeinsamen Bereiche
- Potenzielle Speed-Limit-Patches
"""

import re
import struct
import sys
from pathlib import Path

FW_DIR = Path(__file__).parent / "firmware"

DE_FILE = sorted(FW_DIR.glob("navee_bldc_*ST3_PRO_DE*"))
GLOBAL_FILE = sorted(FW_DIR.glob("navee_bldc_*ST3_Global*"))


def extract_strings(data, min_len=4):
    """Extrahiere druckbare ASCII-Strings."""
    strings = []
    current = ""
    start = 0
    for i, b in enumerate(data):
        if 32 <= b < 127:
            if not current:
                start = i
            current += chr(b)
        else:
            if len(current) >= min_len:
                strings.append((start, current))
            current = ""
    if len(current) >= min_len:
        strings.append((start, current))
    return strings


def find_speed_candidates(data, label):
    """Suche nach Speed-relevanten Mustern."""
    results = []

    # 1. Byte 0x16 (22 km/h) in Config-Kontexten
    for i in range(2, len(data) - 2):
        if data[i] == 0x16:  # 22
            neighbors = data[max(0, i - 4):i + 5]
            if all(b < 100 for b in neighbors):
                results.append(("byte_22", i, neighbors))

    # 2. Byte 0x19 (25 km/h)
    for i in range(2, len(data) - 2):
        if data[i] == 0x19:  # 25
            neighbors = data[max(0, i - 4):i + 5]
            if all(b < 100 for b in neighbors):
                results.append(("byte_25", i, neighbors))

    # 3. Aufsteigende Speed-Tabellen
    for i in range(len(data) - 6):
        window = list(data[i:i + 6])
        if all(10 <= v <= 70 for v in window) and window == sorted(window) and len(set(window)) >= 4:
            results.append(("speed_table", i, data[i:i + 8]))

    # 4. Word-Werte: 2200 (22.0 km/h * 100), 2500
    for i in range(len(data) - 1):
        val_le = data[i] | (data[i + 1] << 8)
        val_be = (data[i] << 8) | data[i + 1]
        for val, src in [(val_le, "LE"), (val_be, "BE")]:
            if val in (2200, 2500, 3200, 4000, 5000, 2000):
                results.append((f"word_{val}_{src}", i, data[max(0, i - 2):i + 4]))

    return results


def hex_context(data, offset, window=16):
    """Hex + ASCII Kontext um einen Offset."""
    start = max(0, offset - window // 2)
    end = min(len(data), offset + window // 2)
    chunk = data[start:end]
    h = " ".join(f"{b:02X}" for b in chunk)
    a = "".join(chr(b) if 32 <= b < 127 else "." for b in chunk)
    return f"0x{start:04X}: {h}  {a}"


def main():
    if not DE_FILE or not GLOBAL_FILE:
        print("FEHLER: BLDC-Firmware-Dateien nicht gefunden")
        print(f"  DE:     {list(FW_DIR.glob('navee_bldc_*ST3_PRO*'))}")
        print(f"  Global: {list(FW_DIR.glob('navee_bldc_*ST3_Global*'))}")
        sys.exit(1)

    de_path = DE_FILE[0]
    gl_path = GLOBAL_FILE[0]
    de_data = de_path.read_bytes()
    gl_data = gl_path.read_bytes()

    print("=" * 80)
    print("  BLDC FIRMWARE VERGLEICH: ST3 PRO DE vs ST3 GLOBAL")
    print("=" * 80)

    # === 1. Header-Vergleich ===
    print(f"\n{'='*80}")
    print("  1. HEADER-VERGLEICH")
    print(f"{'='*80}")

    for label, data, path in [("DE ", de_data, de_path), ("GLO", gl_data, gl_path)]:
        print(f"\n  [{label}] {path.name}")
        print(f"    Size:    {len(data)} Bytes ({len(data)/1024:.1f} KB)")
        print(f"    Model:   {data[:6].decode('latin-1')}")
        print(f"    Type:    0x{data[6]:02X}")
        print(f"    Version: {data[7:15].decode('latin-1')}")
        print(f"    Header (64 bytes):")
        for i in range(0, 64, 16):
            h = " ".join(f"{data[j]:02X}" for j in range(i, min(i + 16, 64)))
            a = "".join(chr(data[j]) if 32 <= data[j] < 127 else "." for j in range(i, min(i + 16, 64)))
            print(f"      {i:04X}: {h:<48s} {a}")

    print(f"\n  Größen-Differenz: {len(de_data) - len(gl_data)} Bytes "
          f"(DE ist {(len(de_data) - len(gl_data)) / 1024:.1f} KB größer)")

    # === 2. Byte-für-Byte Diff ===
    print(f"\n{'='*80}")
    print("  2. BYTE-FÜR-BYTE DIFF (gemeinsamer Bereich)")
    print(f"{'='*80}")

    min_len = min(len(de_data), len(gl_data))
    diffs = []
    for i in range(min_len):
        if de_data[i] != gl_data[i]:
            diffs.append(i)

    print(f"\n  Gemeinsame Bytes: {min_len}")
    print(f"  Unterschiedliche Bytes: {len(diffs)}")
    if min_len > 0:
        print(f"  Identisch: {(1 - len(diffs) / min_len) * 100:.1f}%")

    # Erste 100 Diffs zeigen
    if diffs:
        print(f"\n  Erste {min(50, len(diffs))} Unterschiede:")
        print(f"  {'Offset':>8s}  {'DE':>4s}  {'GLO':>4s}  {'DE_dec':>6s}  {'GLO_dec':>7s}")
        for i in diffs[:50]:
            print(f"  0x{i:06X}  0x{de_data[i]:02X}  0x{gl_data[i]:02X}  "
                  f"{de_data[i]:6d}  {gl_data[i]:7d}")

    # Diff-Cluster finden (zusammenhängende Bereiche)
    if diffs:
        print(f"\n  Diff-Cluster (zusammenhängende geänderte Bereiche):")
        clusters = []
        cluster_start = diffs[0]
        cluster_end = diffs[0]
        for d in diffs[1:]:
            if d <= cluster_end + 4:  # Max 4 Bytes Lücke
                cluster_end = d
            else:
                clusters.append((cluster_start, cluster_end))
                cluster_start = d
                cluster_end = d
        clusters.append((cluster_start, cluster_end))

        print(f"  {len(clusters)} Cluster gefunden:\n")
        for start, end in clusters[:30]:
            size = end - start + 1
            de_chunk = de_data[start:end + 1]
            gl_chunk = gl_data[start:end + 1]
            de_hex = " ".join(f"{b:02X}" for b in de_chunk[:24])
            gl_hex = " ".join(f"{b:02X}" for b in gl_chunk[:24])
            more = "..." if size > 24 else ""
            print(f"  0x{start:04X}-0x{end:04X} ({size:4d} bytes):")
            print(f"    DE:  {de_hex}{more}")
            print(f"    GLO: {gl_hex}{more}")

    # === 3. Extra-Daten in DE (tail) ===
    if len(de_data) > len(gl_data):
        extra = de_data[len(gl_data):]
        print(f"\n{'='*80}")
        print(f"  3. EXTRA-DATEN NUR IN DE ({len(extra)} Bytes)")
        print(f"{'='*80}")
        print(f"\n  Erste 256 Bytes des Extra-Bereichs:")
        for i in range(0, min(256, len(extra)), 16):
            offset = len(gl_data) + i
            chunk = extra[i:i + 16]
            h = " ".join(f"{b:02X}" for b in chunk)
            a = "".join(chr(b) if 32 <= b < 127 else "." for b in chunk)
            print(f"    {offset:04X}: {h:<48s} {a}")

        # Strings im Extra-Bereich
        extra_strings = extract_strings(extra)
        if extra_strings:
            print(f"\n  Strings im Extra-Bereich:")
            for off, s in extra_strings:
                print(f"    0x{len(gl_data) + off:04X}: \"{s}\"")

    # === 4. Speed-relevante Bytes ===
    print(f"\n{'='*80}")
    print("  4. SPEED-RELEVANTE BYTES")
    print(f"{'='*80}")

    for label, data in [("DE", de_data), ("GLOBAL", gl_data)]:
        candidates = find_speed_candidates(data, label)
        print(f"\n  [{label}] Speed-Kandidaten:")

        # Byte 22 (0x16)
        b22 = [c for c in candidates if c[0] == "byte_22"]
        print(f"    Byte 0x16 (22 km/h): {len(b22)} Fundstellen")
        for _, off, ctx in b22[:10]:
            print(f"      {hex_context(data, off)}")

        # Byte 25 (0x19)
        b25 = [c for c in candidates if c[0] == "byte_25"]
        print(f"    Byte 0x19 (25 km/h): {len(b25)} Fundstellen")
        for _, off, ctx in b25[:10]:
            print(f"      {hex_context(data, off)}")

        # Speed-Tabellen
        tables = [c for c in candidates if c[0] == "speed_table"]
        print(f"    Speed-Tabellen: {len(tables)} Fundstellen")
        for _, off, ctx in tables[:5]:
            vals = " ".join(f"{b:02X}({b})" for b in ctx)
            print(f"      0x{off:04X}: {vals}")

        # Word-Werte
        words = [c for c in candidates if c[0].startswith("word_")]
        if words:
            print(f"    Word-Werte (2200, 2500, etc.):")
            for tag, off, ctx in words[:10]:
                print(f"      0x{off:04X}: {tag} — {hex_context(data, off)}")

    # === 5. Speed-Bytes die NUR in DE existieren ===
    print(f"\n{'='*80}")
    print("  5. SPEED-BYTES NUR IN DE (nicht in Global)")
    print(f"{'='*80}")

    de_22_positions = set()
    gl_22_positions = set()
    for i in range(min_len):
        if de_data[i] == 0x16:
            de_22_positions.add(i)
        if gl_data[i] == 0x16:
            gl_22_positions.add(i)

    de_only_22 = de_22_positions - gl_22_positions
    print(f"\n  Byte 0x16 (22) nur in DE: {len(de_only_22)} Stellen")
    for pos in sorted(de_only_22)[:20]:
        gl_val = gl_data[pos] if pos < len(gl_data) else "N/A"
        print(f"    0x{pos:04X}: DE=0x16(22)  GLO=0x{gl_val:02X}({gl_val})")
        print(f"      DE:  {hex_context(de_data, pos)}")
        print(f"      GLO: {hex_context(gl_data, pos)}")

    # === 6. Stellen wo DE=22 und Global=25 ===
    print(f"\n{'='*80}")
    print("  6. STELLEN WO DE=22 UND GLOBAL=25 (Speed-Limit Kandidaten!)")
    print(f"{'='*80}")

    speed_limit_patches = []
    for i in range(min_len):
        if de_data[i] == 0x16 and gl_data[i] == 0x19:
            speed_limit_patches.append(i)
        # Auch Word-Vergleich: DE=2200, GL=2500
        if i < min_len - 1:
            de_word = de_data[i] | (de_data[i + 1] << 8)
            gl_word = gl_data[i] | (gl_data[i + 1] << 8)
            if de_word == 2200 and gl_word == 2500:
                speed_limit_patches.append(i)

    if speed_limit_patches:
        print(f"\n  *** {len(speed_limit_patches)} KANDIDATEN GEFUNDEN! ***\n")
        for pos in speed_limit_patches:
            print(f"  Offset 0x{pos:04X}:")
            print(f"    DE:  {hex_context(de_data, pos, 32)}")
            print(f"    GLO: {hex_context(gl_data, pos, 32)}")
    else:
        print("\n  Keine direkten 22↔25 Substitutionen gefunden.")
        print("  Speed-Limit könnte als Word (2200/2500), Float, oder in")
        print("  einer Lookup-Tabelle kodiert sein.")

    # === 7. Alle Stellen wo DE < Global (potenzielle Drosselungen) ===
    print(f"\n{'='*80}")
    print("  7. STELLEN WO DE < GLOBAL (potenzielle Drosselungen)")
    print(f"{'='*80}")

    throttle_candidates = []
    for i in range(min_len):
        de_v = de_data[i]
        gl_v = gl_data[i]
        if de_v < gl_v and 10 <= de_v <= 50 and 10 <= gl_v <= 70:
            throttle_candidates.append((i, de_v, gl_v))

    print(f"\n  {len(throttle_candidates)} Stellen wo DE-Wert < Global-Wert (10-70 Bereich):")
    for pos, de_v, gl_v in throttle_candidates[:30]:
        print(f"    0x{pos:04X}: DE={de_v:3d}(0x{de_v:02X})  GLO={gl_v:3d}(0x{gl_v:02X})  "
              f"Diff={gl_v - de_v:+d}")
        print(f"      DE:  {hex_context(de_data, pos)}")
        print(f"      GLO: {hex_context(gl_data, pos)}")

    # === 8. String-Vergleich ===
    print(f"\n{'='*80}")
    print("  8. STRING-VERGLEICH")
    print(f"{'='*80}")

    de_strings = set(s for _, s in extract_strings(de_data, 5))
    gl_strings = set(s for _, s in extract_strings(gl_data, 5))

    de_only = de_strings - gl_strings
    gl_only = gl_strings - de_strings
    common = de_strings & gl_strings

    print(f"\n  Gemeinsame Strings: {len(common)}")
    for s in sorted(common)[:20]:
        print(f"    \"{s}\"")

    if de_only:
        print(f"\n  Nur in DE ({len(de_only)}):")
        for s in sorted(de_only):
            print(f"    \"{s}\"")

    if gl_only:
        print(f"\n  Nur in Global ({len(gl_only)}):")
        for s in sorted(gl_only):
            print(f"    \"{s}\"")

    # === 9. Zusammenfassung ===
    print(f"\n{'='*80}")
    print("  9. ZUSAMMENFASSUNG")
    print(f"{'='*80}")
    print(f"\n  DE Firmware:     {de_path.name}")
    print(f"  Global Firmware: {gl_path.name}")
    print(f"  Größen-Diff:     {len(de_data) - len(gl_data)} Bytes")
    print(f"  Byte-Diffs:      {len(diffs)} von {min_len} ({len(diffs)/max(min_len,1)*100:.1f}%)")
    print(f"  Diff-Cluster:    {len(clusters) if diffs else 0}")
    print(f"  22↔25 Patches:   {len(speed_limit_patches)}")
    print(f"  Throttle-Stellen: {len(throttle_candidates)}")
    print(f"  DE-only Strings: {len(de_only)}")
    print(f"  GL-only Strings: {len(gl_only)}")


if __name__ == "__main__":
    main()

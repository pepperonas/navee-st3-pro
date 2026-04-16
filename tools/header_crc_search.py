#!/usr/bin/env python3
"""Cross-firmware header analysis for Navee BLDC firmwares.

Goal: Determine whether bytes 0x12-0x14 in the header are a checksum/CRC
of the firmware body, by analyzing all available BLDC firmware files
across all scooter models.

If we find that header[0x13:0x15] = f(body) for ALL files, we have the
algorithm — and then patched firmwares can be made dashboard-acceptable.
"""
from __future__ import annotations
import struct
import zlib
from pathlib import Path
from typing import Iterable

FW_DIR = Path(__file__).parent / "firmware"


# ----------------------------------------------------------------------
# CRC implementations (no external deps)
# ----------------------------------------------------------------------
def crc16_table(poly: int, refin: bool) -> list[int]:
    """Build a CRC-16 lookup table for given polynomial."""
    tbl = [0] * 256
    if refin:
        # reflected polynomial
        rpoly = 0
        for i in range(16):
            if poly & (1 << i):
                rpoly |= 1 << (15 - i)
        poly = rpoly
        for i in range(256):
            v = i
            for _ in range(8):
                v = (v >> 1) ^ poly if (v & 1) else (v >> 1)
            tbl[i] = v & 0xFFFF
    else:
        for i in range(256):
            v = i << 8
            for _ in range(8):
                v = ((v << 1) ^ poly) & 0xFFFF if (v & 0x8000) else (v << 1) & 0xFFFF
            tbl[i] = v
    return tbl


def crc16(data: bytes, poly: int, init: int, refin: bool, refout: bool, xor_out: int) -> int:
    tbl = crc16_table(poly, refin)
    if refin:
        # init also reflected for reflected mode
        crc = init
        for b in data:
            crc = ((crc >> 8) ^ tbl[(crc ^ b) & 0xFF]) & 0xFFFF
    else:
        crc = init
        for b in data:
            crc = ((crc << 8) ^ tbl[((crc >> 8) ^ b) & 0xFF]) & 0xFFFF
    if refout != refin:
        # reflect output
        out = 0
        for i in range(16):
            if crc & (1 << i):
                out |= 1 << (15 - i)
        crc = out
    return crc ^ xor_out


# Catalogue of standard CRC-16 variants
CRC_VARIANTS = {
    "CRC-16/IBM (ARC)":     dict(poly=0x8005, init=0x0000, refin=True,  refout=True,  xor_out=0x0000),
    "CRC-16/MODBUS":        dict(poly=0x8005, init=0xFFFF, refin=True,  refout=True,  xor_out=0x0000),
    "CRC-16/USB":           dict(poly=0x8005, init=0xFFFF, refin=True,  refout=True,  xor_out=0xFFFF),
    "CRC-16/MAXIM":         dict(poly=0x8005, init=0x0000, refin=True,  refout=True,  xor_out=0xFFFF),
    "CRC-16/CCITT-FALSE":   dict(poly=0x1021, init=0xFFFF, refin=False, refout=False, xor_out=0x0000),
    "CRC-16/XMODEM":        dict(poly=0x1021, init=0x0000, refin=False, refout=False, xor_out=0x0000),
    "CRC-16/KERMIT":        dict(poly=0x1021, init=0x0000, refin=True,  refout=True,  xor_out=0x0000),
    "CRC-16/AUG-CCITT":     dict(poly=0x1021, init=0x1D0F, refin=False, refout=False, xor_out=0x0000),
    "CRC-16/GENIBUS":       dict(poly=0x1021, init=0xFFFF, refin=False, refout=False, xor_out=0xFFFF),
    "CRC-16/DNP":           dict(poly=0x3D65, init=0x0000, refin=True,  refout=True,  xor_out=0xFFFF),
    "CRC-16/EN-13757":      dict(poly=0x3D65, init=0x0000, refin=False, refout=False, xor_out=0xFFFF),
    "CRC-16/T10-DIF":       dict(poly=0x8BB7, init=0x0000, refin=False, refout=False, xor_out=0x0000),
    "CRC-16/TELEDISK":      dict(poly=0xA097, init=0x0000, refin=False, refout=False, xor_out=0x0000),
    "CRC-16/CDMA2000":      dict(poly=0xC867, init=0xFFFF, refin=False, refout=False, xor_out=0x0000),
    "CRC-16/RIELLO":        dict(poly=0x1021, init=0xB2AA, refin=True,  refout=True,  xor_out=0x0000),
}


# ----------------------------------------------------------------------
# Simple/non-standard sums
# ----------------------------------------------------------------------
def sum8(data: bytes) -> int:
    return sum(data) & 0xFF


def sum16(data: bytes) -> int:
    return sum(data) & 0xFFFF


def sum16_le_words(data: bytes) -> int:
    n = len(data) - (len(data) % 2)
    return sum(struct.unpack(f"<{n // 2}H", data[:n])) & 0xFFFF


def sum16_be_words(data: bytes) -> int:
    n = len(data) - (len(data) % 2)
    return sum(struct.unpack(f">{n // 2}H", data[:n])) & 0xFFFF


def xor_bytes(data: bytes) -> int:
    x = 0
    for b in data:
        x ^= b
    return x


# ----------------------------------------------------------------------
# Header extraction
# ----------------------------------------------------------------------
def parse_header(data: bytes) -> dict:
    """Heuristic header parse. Format observed:

    [0x00..0x05]  ASCII type tag (e.g. 'T2324\\0')
    [0x06..0x07]  type/category bytes (e.g. \\x00\\x02 for BLDC)
    [0x08..0x0F]  ASCII version digits (e.g. '00151010') + null
    [0x10]        \\x00 padding
    [0x11]        REGION byte (0xCF=DE, 0xB7=Global, ...)
    [0x12]        marker byte (always 0x80 in observed samples)
    [0x13..0x14]  CHECKSUM candidate (varies between FW)
    [0x15..]      0xFF padding until code starts
    """
    return {
        "tag":       data[0:6].rstrip(b"\x00"),
        "category":  data[6:8],
        "version":   data[8:16].rstrip(b"\x00\xFF"),
        "region":    data[0x11],
        "marker":    data[0x12],
        "checksum":  struct.unpack_from("<H", data, 0x13)[0],
        "checksum_be": struct.unpack_from(">H", data, 0x13)[0],
        "checksum_3b": data[0x13:0x16],
    }


def trim_padding(data: bytes, pad: int = 0xFF) -> bytes:
    """Strip trailing padding bytes (returns the 'code body')."""
    end = len(data)
    while end > 0 and data[end - 1] == pad:
        end -= 1
    return data[:end]


def first_code_offset(data: bytes) -> int:
    """Find where the actual code starts (after header + 0xFF pad)."""
    # Scan from byte 0x15 onward, skip 0xFF, return first non-0xFF.
    for i in range(0x15, len(data)):
        if data[i] != 0xFF:
            return i
    return len(data)


# ----------------------------------------------------------------------
# Core analysis
# ----------------------------------------------------------------------
def collect() -> list[tuple[Path, bytes, dict]]:
    files = sorted(FW_DIR.glob("navee_bldc_v*_pid=*.bin"))
    out = []
    for f in files:
        d = f.read_bytes()
        out.append((f, d, parse_header(d)))
    return out


def show_inventory(items: Iterable[tuple[Path, bytes, dict]]) -> None:
    print("\n" + "=" * 110)
    print(f"{'FILE':<58} {'SIZE':>7} {'TAG':<6} {'CAT':<5} {'VERSION':<10} REG  M  CSUM_LE CSUM_BE")
    print("=" * 110)
    for f, d, h in items:
        print(
            f"{f.name:<58} {len(d):>7} {h['tag'].decode('ascii', 'replace'):<6} "
            f"{h['category'].hex():<5} {h['version'].decode('ascii', 'replace'):<10} "
            f"{h['region']:02X}   {h['marker']:02X} {h['checksum']:>6X}  {h['checksum_be']:>6X}"
        )


def show_tag_groups(items: list[tuple[Path, bytes, dict]]) -> None:
    """Group by hardware tag (T-prefix) — same hardware family should share format."""
    groups: dict[bytes, list] = {}
    for f, d, h in items:
        groups.setdefault(h["tag"], []).append((f, d, h))
    print("\n" + "=" * 80)
    print("FIRMWARE GROUPED BY HARDWARE TAG")
    print("=" * 80)
    for tag, lst in sorted(groups.items()):
        print(f"\n[{tag.decode('ascii', 'replace')}]  ({len(lst)} files)")
        for f, d, h in lst:
            print(f"  {f.name:<58} reg={h['region']:02X} csum_le={h['checksum']:04X}")


# ----------------------------------------------------------------------
# CRC search: try every variant against every body slice.
# ----------------------------------------------------------------------
def slice_candidates(data: bytes) -> dict[str, bytes]:
    """Produce candidate body byte ranges to compute the CRC over."""
    code = trim_padding(data)
    body_offset = first_code_offset(data)
    return {
        "full_with_pad":        data,
        "full_no_pad":          code,
        "after_header_with_pad":data[0x15:],
        "after_header_no_pad":  trim_padding(data[0x15:]),
        "after_marker_with_pad":data[0x13:],   # includes the checksum slot itself
        "after_marker_no_pad":  trim_padding(data[0x13:]),
        "from_code_start":      data[body_offset:],
        "from_code_no_pad":     trim_padding(data[body_offset:]),
        "header_only_first16":  data[:16],
        "header_only_first17":  data[:17],
        "header_only_first18":  data[:18],
    }


def search_crc(items: list[tuple[Path, bytes, dict]], min_match: int = 5) -> None:
    """For each (variant, slice), count how many files match."""
    print("\n" + "=" * 90)
    print("CRC ALGORITHM SEARCH")
    print(f"  Trying {len(CRC_VARIANTS)} CRC variants × multiple body slices")
    print(f"  Reporting any combination matching >= {min_match} files")
    print("=" * 90)

    # Pre-compute slice candidates per file
    file_slices = []
    for f, d, h in items:
        file_slices.append((f, d, h, slice_candidates(d)))

    slice_names = list(slice_candidates(items[0][1]).keys())
    n = len(items)

    best = []
    for slice_name in slice_names:
        for var_name, params in CRC_VARIANTS.items():
            matches_le = 0
            matches_be = 0
            for f, d, h, slices in file_slices:
                crc = crc16(slices[slice_name], **params)
                if crc == h["checksum"]:
                    matches_le += 1
                if crc == h["checksum_be"]:
                    matches_be += 1
            if matches_le >= min_match or matches_be >= min_match:
                best.append((max(matches_le, matches_be), slice_name, var_name,
                             matches_le, matches_be))
    best.sort(reverse=True)
    if not best:
        print(f"  ❌ No CRC-16 variant matches >= {min_match} files on any slice.")
        print("     The checksum is NOT a standard CRC-16 — try other algorithms.")
    for rank, (m, slice_name, var_name, ml, mb) in enumerate(best[:20], 1):
        print(f"  #{rank:2d}  {var_name:<22} on {slice_name:<24} "
              f"LE={ml}/{n} BE={mb}/{n}")


def search_simple_sums(items: list[tuple[Path, bytes, dict]], min_match: int = 5) -> None:
    """Try 8/16-bit sums, XOR, etc."""
    print("\n" + "=" * 90)
    print("SIMPLE CHECKSUM SEARCH (sum8, sum16, xor, adler32, crc32-truncated)")
    print("=" * 90)
    n = len(items)
    file_slices = [(f, d, h, slice_candidates(d)) for f, d, h in items]
    slice_names = list(slice_candidates(items[0][1]).keys())

    algos = {
        "sum8":           lambda b: sum8(b),
        "sum16":          lambda b: sum16(b),
        "sum16-le-words": lambda b: sum16_le_words(b),
        "sum16-be-words": lambda b: sum16_be_words(b),
        "xor":            lambda b: xor_bytes(b),
        "adler32-low":    lambda b: zlib.adler32(b) & 0xFFFF,
        "adler32-high":   lambda b: (zlib.adler32(b) >> 16) & 0xFFFF,
        "crc32-low":      lambda b: zlib.crc32(b) & 0xFFFF,
        "crc32-high":     lambda b: (zlib.crc32(b) >> 16) & 0xFFFF,
    }
    best = []
    for slice_name in slice_names:
        for algo_name, fn in algos.items():
            ml = mb = 0
            for f, d, h, slices in file_slices:
                v = fn(slices[slice_name])
                if v == h["checksum"]:
                    ml += 1
                if v == h["checksum_be"]:
                    mb += 1
            if ml >= min_match or mb >= min_match:
                best.append((max(ml, mb), slice_name, algo_name, ml, mb))
    best.sort(reverse=True)
    if not best:
        print(f"  ❌ No simple sum matches >= {min_match} files.")
    for rank, (m, slice_name, algo_name, ml, mb) in enumerate(best[:15], 1):
        print(f"  #{rank:2d}  {algo_name:<16} on {slice_name:<24} "
              f"LE={ml}/{n} BE={mb}/{n}")


# ----------------------------------------------------------------------
# Same-tag pair analysis: focus on minimum-diff cases
# ----------------------------------------------------------------------
def analyze_same_tag_pairs(items: list[tuple[Path, bytes, dict]]) -> None:
    """For files sharing a hardware tag, look at how the checksum bytes
    relate to body diffs."""
    groups: dict[bytes, list] = {}
    for f, d, h in items:
        groups.setdefault(h["tag"], []).append((f, d, h))

    print("\n" + "=" * 80)
    print("SAME-TAG PAIRS (size delta vs checksum delta)")
    print("=" * 80)
    for tag, lst in sorted(groups.items()):
        if len(lst) < 2:
            continue
        print(f"\n[{tag.decode('ascii', 'replace')}]")
        # Pairwise
        for i in range(len(lst)):
            for j in range(i + 1, len(lst)):
                fa, da, ha = lst[i]
                fb, db, hb = lst[j]
                size_d = len(db) - len(da)
                csum_d = (hb["checksum"] - ha["checksum"]) & 0xFFFF
                # Count actual byte-level differences
                m = min(len(da), len(db))
                byte_diffs = sum(1 for k in range(m) if da[k] != db[k])
                print(f"  {fa.name[14:30]:<18} vs {fb.name[14:30]:<18}  "
                      f"Δsize={size_d:>+5}  Δcsum={csum_d:04X}  "
                      f"byte_diffs={byte_diffs}")


# ----------------------------------------------------------------------
# Main
# ----------------------------------------------------------------------
def main() -> None:
    items = collect()
    print(f"Loaded {len(items)} BLDC firmware files from {FW_DIR}")
    show_inventory(items)
    show_tag_groups(items)
    analyze_same_tag_pairs(items)
    search_crc(items, min_match=5)
    search_simple_sums(items, min_match=5)

    # Sanity-check: do all files have the same marker byte 0x80 at offset 0x12?
    markers = {h["marker"] for _, _, h in items}
    print(f"\n[sanity] Distinct marker bytes at offset 0x12: {sorted(markers)}")
    regions = {h["region"] for _, _, h in items}
    print(f"[sanity] Distinct region bytes at offset 0x11: {sorted(hex(r) for r in regions)}")
    cats = {bytes(h["category"]).hex() for _, _, h in items}
    print(f"[sanity] Distinct category bytes at offset 0x06-0x07: {sorted(cats)}")
    tags = {h["tag"] for _, _, h in items}
    print(f"[sanity] Distinct hardware tags: {sorted(t.decode('ascii', 'replace') for t in tags)}")


if __name__ == "__main__":
    main()

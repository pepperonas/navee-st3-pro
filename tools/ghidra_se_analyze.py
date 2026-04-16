#!/usr/bin/env python3
"""
ghidra_se_analyze.py — PyGhidra-driven analysis for Secure Element /
crypto / OTA-validator code paths in the Navee dashboard FW.

Run:
    export GHIDRA_INSTALL_DIR=/Users/martin/ghidra/ghidra_12.0.4_PUBLIC
    python3 tools/ghidra_se_analyze.py

Prerequisites:
  - pip install pyghidra
  - Ghidra project at /tmp/ghidra_navee (see PATCH_PLAN.md for setup)

Outputs:
  - /tmp/ghidra_se_findings.txt   (full log)

Tasks:
  1. Find all functions referencing FMN / Apple-FMNA strings
  2. Find OTA-receive function in PATCH-image (0x2792)
  3. Decompile candidate validator functions
  4. List all peripheral register accesses (I2C/SPI base addrs)
  5. Output XRef graph for `secp256r1`, `fmna_crypto_init`, `ServerSharedSecret`
"""
from __future__ import annotations

import os
import sys
from pathlib import Path

GHIDRA_DEFAULT = "/Users/martin/ghidra/ghidra_12.0.4_PUBLIC"
PROJECT_DIR = "/tmp/ghidra_navee"
PROJECT_NAME = "navee_dashboard"
OUTPUT = "/tmp/ghidra_se_findings.txt"

os.environ.setdefault("GHIDRA_INSTALL_DIR", GHIDRA_DEFAULT)

try:
    import pyghidra
except ImportError:
    print("ERROR: pyghidra not installed. Run: pip install --user pyghidra", file=sys.stderr)
    sys.exit(2)

pyghidra.start(verbose=False)

from ghidra.app.decompiler import DecompInterface  # noqa: E402
from ghidra.util.task import ConsoleTaskMonitor  # noqa: E402
from java.lang import Object as JObject  # noqa: E402

OUT = []

def log(s: str) -> None:
    print(s, flush=True)
    OUT.append(str(s))


# Targets identified by static analysis (see docs/secure_element_analysis.md)
SE_FUNCTIONS = [
    (0x008293A8, "cmp_4byte_magic (wrong signature!)"),
    (0x008296BC, "apple_fmna_item_header_parser (Header is invalid)"),
    (0x00829344, "mac_updater (Ready to update MAC!)"),
    (0x008212F4, "ota_finalize_post_verify"),
    (0x00824AC4, "fmna_crypto_init_dispatcher"),
    (0x00816AF8, "fm_crypto_ckg_init_internal"),
    (0x00816FCA, "fmna_server_shared_secret"),
    (0x00811B7C, "candidate_se_comm_88byte_chunked"),
]

INTERESTING_STRINGS = [
    "wrong signature! Read %8X != Requried %8X",
    "Header is invalid",
    "Ready to update MAC!",
    "fmna_crypto_init",
    "fm_crypto_ckg_init",
    "ServerSharedSecret",
    "PairingSession",
    "SerialNumberProtection",
    "secp256r1",
    "AES-256-GCM",
    "[OTA] mible_upgrade_firmware",
    "[OTA] upgrade verify ok",
]


def find_string_offset(mem, addr_space, ascii_str: str) -> int | None:
    target = ascii_str.encode() if isinstance(ascii_str, str) else ascii_str
    for base in range(0x00800000, 0x00880000 - len(target)):
        try:
            match = True
            for i, b in enumerate(target):
                bb = mem.getByte(addr_space.getAddress(base + i)) & 0xFF
                if bb != b:
                    match = False
                    break
            if match:
                return base
        except Exception:
            pass
    return None


def manual_xref_scan(mem, addr_space, fm, target_mem: int,
                      code_start: int = 0x0080E400, code_end: int = 0x0082F69C
                      ) -> list[tuple[int, int]]:
    """Find all 4-byte literal-pool entries equal to target_mem.
    Returns list of (pool_addr, function_entry_addr)."""
    found = []
    # Cover both uncached (0x008XXXXX) and cached (0x088XXXXX) variants
    variants = {target_mem, target_mem | 0x08000000}
    for off in range(code_start, code_end, 4):
        try:
            v = mem.getInt(addr_space.getAddress(off)) & 0xFFFFFFFF
            if v in variants:
                f = fm.getFunctionContaining(addr_space.getAddress(off))
                if f:
                    found.append((off, f.getEntryPoint().getOffset()))
        except Exception:
            pass
    return found


def decompile(decomp, fm, addr_space, addr: int, max_lines: int = 80) -> bool:
    f = fm.getFunctionAt(addr_space.getAddress(addr))
    if f is None:
        log(f"    NO function at 0x{addr:08X}")
        return False
    log(f"\n  === FUNCTION {f.getName()} @ 0x{addr:08X} ===")
    res = decomp.decompileFunction(f, 90, ConsoleTaskMonitor())
    if res.decompileCompleted():
        code = res.getDecompiledFunction().getC()
        lines = [l for l in code.split("\n") if not l.strip().startswith("/* WARNING:")]
        for l in lines[:max_lines]:
            log("    " + l)
        if len(lines) > max_lines:
            log(f"    ... ({len(lines) - max_lines} more lines)")
        return True
    log(f"    decompile failed: {res.getErrorMessage()}")
    return False


def main() -> int:
    log("=" * 78)
    log("NAVEE SE/CRYPTO ANALYSIS — PyGhidra")
    log("=" * 78)

    with pyghidra.open_project(PROJECT_DIR, PROJECT_NAME) as project:
        try:
            df = list(project.getProjectData().getRootFolder().getFiles())[0]
        except Exception as e:
            log(f"ERROR: project not found at {PROJECT_DIR}/{PROJECT_NAME}")
            log(f"       {e}")
            log("Hint: run analyzeHeadless first to import the FW dump.")
            return 2

        consumer = JObject()
        program = df.getDomainObject(consumer, False, False, ConsoleTaskMonitor())
        try:
            af = program.getAddressFactory()
            addr_space = af.getDefaultAddressSpace()
            mem = program.getMemory()
            fm = program.getFunctionManager()
            ref_mgr = program.getReferenceManager()
            decomp = DecompInterface()
            decomp.openProgram(program)

            # 1. String XRefs
            log("\n[1] STRING-XREF MAP")
            log("-" * 60)
            for s in INTERESTING_STRINGS:
                off = find_string_offset(mem, addr_space, s)
                if off is None:
                    log(f"  '{s}': NOT FOUND")
                    continue
                log(f"  '{s}' @ 0x{off:08X}:")
                # Auto refs
                refs = list(ref_mgr.getReferencesTo(addr_space.getAddress(off)))
                for r in refs[:3]:
                    xa = r.getFromAddress()
                    f = fm.getFunctionContaining(xa)
                    fent = f.getEntryPoint().getOffset() if f else 0
                    log(f"    auto-XRef from 0x{xa.getOffset():08X} (func 0x{fent:08X})")
                # Manual scan
                manual = manual_xref_scan(mem, addr_space, fm, off)
                for pool, fent in manual[:3]:
                    log(f"    pool 0x{pool:08X} → func 0x{fent:08X}")

            # 2. Decompile target functions
            log("\n[2] DECOMPILE TARGETS")
            log("-" * 60)
            for addr, label in SE_FUNCTIONS:
                log(f"\n  ─── {label} @ 0x{addr:08X} ───")
                decompile(decomp, fm, addr_space, addr, max_lines=80)

            # 3. Peripheral register pool entries
            log("\n[3] PERIPHERAL REGISTER POOLS (0x40000000-0x40080000)")
            log("-" * 60)
            pers = {}
            for off in range(0x0080E400, 0x0082F69C, 4):
                try:
                    v = mem.getInt(addr_space.getAddress(off)) & 0xFFFFFFFF
                    if 0x40000000 <= v < 0x40080000:
                        block = v & 0xFFFFF000
                        pers.setdefault(block, []).append((off, v))
                except Exception:
                    pass
            for block in sorted(pers.keys()):
                entries = pers[block]
                offsets = sorted({e[1] - block for e in entries})
                log(f"  0x{block:08X}: {len(entries):>3} refs  (offsets: {offsets[:6]})")

        finally:
            program.release(consumer)

    Path(OUTPUT).write_text("\n".join(OUT) + "\n")
    log(f"\nFindings saved: {OUTPUT}")
    return 0


if __name__ == "__main__":
    sys.exit(main())

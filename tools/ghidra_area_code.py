# -*- coding: utf-8 -*-
# Find area code check and speed return values
# @category Navee
# @runtime Jython

program = currentProgram
listing = program.getListing()
memory = program.getMemory()
af = program.getAddressFactory().getDefaultAddressSpace()
decomp = ghidra.app.decompiler.DecompInterface()
decomp.openProgram(program)

print("=" * 60)
print("AREA CODE + SPEED VALUES")
print("=" * 60)

# FUN_0800ad02 - the speed lookup function
func = listing.getFunctionAt(af.getAddress(0x0800ad02))
if func:
    print("\n[1] FUN_0800ad02 Disassembly:")
    body = func.getBody()
    addr_iter = body.getAddresses(True)
    while addr_iter.hasNext():
        addr = addr_iter.next()
        instr = listing.getInstructionAt(addr)
        if instr:
            raw = ""
            for i in range(instr.getLength()):
                raw += "%02x " % (memory.getByte(addr.add(i)) & 0xFF)
            file_off = addr.getOffset() - 0x08000000
            s = str(instr)
            marker = ""
            # Mark interesting instructions
            if "#0x3" in s and "cmp" in s.lower():
                marker = " <<<< AREA CODE 3 (DE) CHECK"
            if "0xe1" in s.lower():
                marker = " <<<< 22.5 km/h RETURN VALUE"
            if "0x9b" in s.lower():
                marker = " <<<< 15.5 km/h"
            if "0xff" in s.lower() and "mov" in s.lower():
                marker = " <<<< 25.5 km/h"
            if "0x145" in s.lower():
                marker = " <<<< 32.5 km/h"
            if "0x195" in s.lower():
                marker = " <<<< 40.5 km/h"
            if "0xcd" in s.lower() and "mov" in s.lower():
                marker = " <<<< 20.5 km/h"
            print("  %s [0x%04X]: %-14s %s%s" % (addr, file_off, raw.strip(), s, marker))

    print("\n[2] Decompiled:")
    results = decomp.decompileFunction(func, 30, getMonitor())
    if results and results.decompileCompleted():
        print(results.getDecompiledFunction().getC())

decomp.dispose()
print("\nDone.")

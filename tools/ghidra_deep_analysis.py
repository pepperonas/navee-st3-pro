# -*- coding: utf-8 -*-
# Deep analysis: find where speed limit value 22 is set
# @category Navee
# @runtime Jython

program = currentProgram
listing = program.getListing()
memory = program.getMemory()
ref_mgr = program.getReferenceManager()
decomp = ghidra.app.decompiler.DecompInterface()
decomp.openProgram(program)

print("=" * 60)
print("DEEP SPEED LIMIT ANALYSIS")
print("=" * 60)

# Find references to the key strings
target_strings = {
    0x08013654: "key long set save unit %d speed limit %d",
    0x08013694: "ToggleSetting sys_stc.lift_speed_limit = %d",
    0x08013018: "saving s max speed state",
    0x0801304c: "reading s max speed state",
}

for str_addr_int, label in target_strings.items():
    str_addr = program.getAddressFactory().getDefaultAddressSpace().getAddress(str_addr_int)
    print("\n--- String: \"%s\" @ %s ---" % (label[:50], str_addr))
    refs = ref_mgr.getReferencesTo(str_addr)
    for ref in refs:
        from_addr = ref.getFromAddress()
        func = listing.getFunctionContaining(from_addr)
        if func:
            print("  Referenced from %s in %s @ %s" % (from_addr, func.getName(), func.getEntryPoint()))
            # Decompile the function
            results = decomp.decompileFunction(func, 30, getMonitor())
            if results and results.decompileCompleted():
                c_code = results.getDecompiledFunction().getC()
                # Print only relevant lines
                lines = c_code.split("\n")
                for i, line in enumerate(lines):
                    if any(k in line.lower() for k in ["speed", "limit", "0x16", "22", "max"]):
                        # Print surrounding context
                        start = max(0, i-2)
                        end = min(len(lines), i+3)
                        for j in range(start, end):
                            marker = ">>>" if j == i else "   "
                            print("    %s %s" % (marker, lines[j]))
                        print("    ---")

# Also look at function that does "movs r0,#0x16" at 08009522
print("\n--- movs r0,#0x16 @ 08009522 ---")
addr = program.getAddressFactory().getDefaultAddressSpace().getAddress(0x08009522)
func = listing.getFunctionContaining(addr)
if func:
    print("  Function: %s @ %s" % (func.getName(), func.getEntryPoint()))
    results = decomp.decompileFunction(func, 30, getMonitor())
    if results and results.decompileCompleted():
        c_code = results.getDecompiledFunction().getC()
        lines = c_code.split("\n")
        for i, line in enumerate(lines):
            if "0x16" in line or "22" in line or "speed" in line.lower() or "limit" in line.lower():
                start = max(0, i-2)
                end = min(len(lines), i+3)
                for j in range(start, end):
                    marker = ">>>" if j == i else "   "
                    print("    %s %s" % (marker, lines[j]))
                print("    ---")

decomp.dispose()
print("\nDone.")

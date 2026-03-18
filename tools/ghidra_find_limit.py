# -*- coding: utf-8 -*-
# Find the exact function that sets lift_speed_limit
# @category Navee
# @runtime Jython

program = currentProgram
listing = program.getListing()
memory = program.getMemory()
ref_mgr = program.getReferenceManager()
decomp = ghidra.app.decompiler.DecompInterface()
decomp.openProgram(program)

print("=" * 60)
print("FINDING lift_speed_limit SETTER")
print("=" * 60)

# Decompile ALL functions that reference any speed-related string
speed_addrs = [
    0x08012b68,  # "saving reading speed info"
    0x08012b9c,  # "reading speed set info"
    0x08013018,  # "saving s max speed state"
    0x0801304c,  # "reading s max speed state"
    0x08013080,  # "saving start speed state"
    0x080130b4,  # "reading start speed state"
    0x08013654,  # "key long set save unit %d speed limit %d"
    0x08013694,  # "ToggleSetting sys_stc.lift_speed_limit"
]

for addr_int in speed_addrs:
    addr = program.getAddressFactory().getDefaultAddressSpace().getAddress(addr_int)
    refs = ref_mgr.getReferencesTo(addr)
    for ref in refs:
        from_addr = ref.getFromAddress()
        func = listing.getFunctionContaining(from_addr)
        if func:
            print("\n=== %s @ %s ===" % (func.getName(), func.getEntryPoint()))
            results = decomp.decompileFunction(func, 30, getMonitor())
            if results and results.decompileCompleted():
                c_code = results.getDecompiledFunction().getC()
                # Print full decompiled code (truncated)
                print(c_code[:3000])

# Also decompile the functions near where speed values are read/saved
for func_addr_int in [0x080128f6, 0x08012928, 0x08012cc8, 0x08012cf8, 0x08012d1e, 0x08012d4e]:
    addr = program.getAddressFactory().getDefaultAddressSpace().getAddress(func_addr_int)
    func = listing.getFunctionAt(addr)
    if func:
        print("\n=== %s @ %s ===" % (func.getName(), func.getEntryPoint()))
        results = decomp.decompileFunction(func, 30, getMonitor())
        if results and results.decompileCompleted():
            c_code = results.getDecompiledFunction().getC()
            print(c_code[:2000])

decomp.dispose()
print("\nDone.")

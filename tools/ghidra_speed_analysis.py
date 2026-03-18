# -*- coding: utf-8 -*-
# Ghidra Headless Script: Search for speed_limit references in Navee firmware
# @category Navee
# @runtime Jython

program = currentProgram
listing = program.getListing()
memory = program.getMemory()
monitor = getMonitor()
ref_mgr = program.getReferenceManager()

print("=" * 60)
print("NAVEE FIRMWARE SPEED LIMIT ANALYSIS")
print("=" * 60)

# 1. String search
print("\n[1] String search...")
speed_strings = []
data_iter = listing.getDefinedData(True)
while data_iter.hasNext() and not monitor.isCancelled():
    d = data_iter.next()
    if d.hasStringValue():
        s = d.getValue()
        if s and any(k in s.lower() for k in ["speed", "limit", "max", "pid", "mode", "km"]):
            print("  String @ %s: \"%s\"" % (d.getAddress(), s))
            speed_strings.append((d.getAddress(), s))

# 2. References to speed strings
print("\n[2] References to speed strings...")
for addr, s in speed_strings:
    refs = ref_mgr.getReferencesTo(addr)
    for ref in refs:
        from_addr = ref.getFromAddress()
        func = listing.getFunctionContaining(from_addr)
        func_name = func.getName() if func else "unknown"
        print("  \"%s\" ref from %s [%s]" % (s[:40], from_addr, func_name))

# 3. Instructions with #0x16
print("\n[3] Instructions with #0x16 (22 decimal)...")
count = 0
instr_iter = listing.getInstructions(True)
while instr_iter.hasNext() and not monitor.isCancelled():
    instr = instr_iter.next()
    s = str(instr)
    if "#0x16" in s:
        func = listing.getFunctionContaining(instr.getAddress())
        func_name = func.getName() if func else "?"
        print("  %s @ %s [%s]" % (s, instr.getAddress(), func_name))
        count += 1
        if count > 80:
            print("  ... (truncated)")
            break

# 4. Functions
print("\n[4] All defined functions (count)...")
func_count = 0
func_iter = listing.getFunctions(True)
while func_iter.hasNext():
    func_iter.next()
    func_count += 1
print("  Total functions: %d" % func_count)

# 5. Byte 0x16 near speed_limit refs
print("\n[5] Byte 0x16 near speed_limit string refs...")
for addr, s in speed_strings:
    if "speed" in s.lower() and "limit" in s.lower():
        refs = ref_mgr.getReferencesTo(addr)
        for ref in refs:
            from_addr = ref.getFromAddress()
            try:
                for offset in range(-30, 30):
                    cur = from_addr.add(offset)
                    b = memory.getByte(cur) & 0xFF
                    if b == 0x16:
                        instr = listing.getInstructionContaining(cur)
                        if instr:
                            print("  0x16 at %s: %s (near \"%s\")" % (cur, instr, s[:30]))
            except:
                pass

print("\nDone.")

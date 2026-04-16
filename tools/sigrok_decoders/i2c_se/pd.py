"""sigrok protocol decoder: I2C Secure-Element classifier.

Stacks on top of the built-in 'i2c' decoder. Classifies traffic by 7-bit
address and decodes ATECC608 / SE050 / OPTIGA Trust packet structure.

Author: Navee project, MIT-style usage.
"""
import sigrokdecode as srd

# Known SE I2C addresses (7-bit)
SE_ADDRESSES = {
    0x60: ("ATECC608A",      "atecc"),
    0x6A: ("ATECC608A-alt",  "atecc"),
    0x6C: ("ATECC608A-alt2", "atecc"),
    0x48: ("SE050",          "se050"),
    0x49: ("SE050-alt",      "se050"),
    0x30: ("OPTIGA Trust X", "optiga"),
    0x31: ("OPTIGA Trust X", "optiga"),
    0x64: ("ATSHA204A",      "atsha"),
    0x66: ("ATSHA204A-alt",  "atsha"),
    0x10: ("Apple MFi 3.0",  "mfi"),
}

ATECC_OPCODES = {
    0x16: "GenKey",        0x17: "Info",        0x18: "Lock",
    0x1B: "Random",        0x1C: "Read",        0x1E: "Sign(T2)",
    0x40: "GenDig",        0x41: "Sign",        0x43: "GenDivKey",
    0x45: "Verify",        0x46: "PrivWrite",   0x47: "Nonce",
    0x48: "MAC",           0x4C: "ECDH",        0x52: "DeriveKey",
    0x60: "Verify-alt",    0x70: "AES",         0x77: "KDF",
}

ATECC_WORD_ADDRS = {
    0x00: "Reset",
    0x01: "Sleep",
    0x02: "Idle",
    0x03: "Command",
}


class Decoder(srd.Decoder):
    api_version = 3
    id = 'i2c_se'
    name = 'I2C SE'
    longname = 'I2C Secure Element classifier'
    desc = 'Detects ATECC608/SE050/OPTIGA on I2C and decodes packets.'
    license = 'mit'
    inputs = ['i2c']
    outputs = []
    tags = ['Embedded/industrial', 'Security/crypto']
    annotations = (
        ('device',  'Device identification'),
        ('action',  'Word-address / action'),
        ('opcode',  'Crypto opcode'),
        ('param',   'Command parameters'),
        ('crc',     'CRC-16 (last 2 bytes of ATECC packet)'),
        ('warning', 'Unrecognized / suspicious'),
    )
    annotation_rows = (
        ('id', 'Device',  (0,)),
        ('op', 'Op/Cmd',  (1, 2)),
        ('p',  'Params',  (3, 4)),
        ('w',  'Warn',    (5,)),
    )

    def __init__(self):
        self.reset()

    def reset(self):
        self.state = 'IDLE'
        self.dev_name = None
        self.dev_kind = None
        self.bytes_in_xfer = []  # list of (start_ss, end_es, byte)
        self.xfer_start_ss = 0
        self.is_write = False

    def start(self):
        self.out_ann = self.register(srd.OUTPUT_ANN)

    def put_ann(self, ss, es, ann_class, text):
        self.put(ss, es, self.out_ann, [ann_class, [text]])

    def decode(self, ss, es, data):
        cmd, payload = data[0], (data[1] if len(data) > 1 else None)

        if cmd == 'START':
            self.bytes_in_xfer = []
            self.xfer_start_ss = ss
            self.dev_name = None
            self.dev_kind = None
            return

        if cmd == 'ADDRESS WRITE' or cmd == 'ADDRESS READ':
            addr = payload
            self.is_write = (cmd == 'ADDRESS WRITE')
            if addr in SE_ADDRESSES:
                name, kind = SE_ADDRESSES[addr]
                self.dev_name = name
                self.dev_kind = kind
                rw = "W" if self.is_write else "R"
                self.put_ann(ss, es, 0, f"{name} ({rw})")
            else:
                # Unknown device — annotate so user can spot it
                rw = "W" if self.is_write else "R"
                self.put_ann(ss, es, 5, f"unknown 0x{addr:02X} ({rw})")
            return

        if cmd in ('DATA WRITE', 'DATA READ'):
            self.bytes_in_xfer.append((ss, es, payload))
            return

        if cmd == 'STOP':
            self._classify_xfer()
            self.bytes_in_xfer = []
            return

    def _classify_xfer(self):
        if not self.dev_name or not self.bytes_in_xfer:
            return

        if self.dev_kind == 'atecc':
            self._decode_atecc()
        elif self.dev_kind == 'se050':
            self._decode_se050()
        elif self.dev_kind == 'optiga':
            self._decode_optiga()
        elif self.dev_kind == 'atsha':
            self._decode_atecc()  # similar packet structure
        else:
            # Generic dump
            byte_str = " ".join(f"{b[2]:02X}" for b in self.bytes_in_xfer[:8])
            ss = self.bytes_in_xfer[0][0]
            es = self.bytes_in_xfer[-1][1]
            self.put_ann(ss, es, 1, f"data: {byte_str}")

    def _decode_atecc(self):
        bx = self.bytes_in_xfer
        if not bx:
            return

        # First byte is "Word Address"
        wa = bx[0][2]
        wa_name = ATECC_WORD_ADDRS.get(wa, f"unknown 0x{wa:02X}")
        self.put_ann(bx[0][0], bx[0][1], 1, wa_name)

        if wa == 0x03 and len(bx) >= 4:  # Command packet
            count = bx[1][2]
            opcode = bx[2][2]
            opname = ATECC_OPCODES.get(opcode, f"unknown 0x{opcode:02X}")
            self.put_ann(bx[1][0], bx[1][1], 3, f"count={count}")
            self.put_ann(bx[2][0], bx[2][1], 2, opname)
            if len(bx) >= 5:
                p1 = bx[3][2]
                self.put_ann(bx[3][0], bx[3][1], 3, f"P1=0x{p1:02X}")
            if len(bx) >= 7:
                p2 = bx[4][2] | (bx[5][2] << 8)
                self.put_ann(bx[4][0], bx[5][1], 3, f"P2=0x{p2:04X}")
            # Last 2 bytes = CRC-16
            if len(bx) >= 5:
                crc = bx[-2][2] | (bx[-1][2] << 8)
                self.put_ann(bx[-2][0], bx[-1][1], 4, f"CRC=0x{crc:04X}")

    def _decode_se050(self):
        # SE050 uses ISO7816 T=1 over I2C
        bx = self.bytes_in_xfer
        if len(bx) < 4:
            return
        nad = bx[0][2]
        pcb = bx[1][2]
        length = bx[2][2]
        self.put_ann(bx[0][0], bx[0][1], 1, f"NAD=0x{nad:02X}")
        self.put_ann(bx[1][0], bx[1][1], 2, f"PCB=0x{pcb:02X}")
        self.put_ann(bx[2][0], bx[2][1], 3, f"LEN={length}")
        # CRC at end (2 bytes)
        if len(bx) >= 5:
            self.put_ann(bx[-2][0], bx[-1][1], 4, "CRC")

    def _decode_optiga(self):
        # OPTIGA Trust uses I2C with simpler register-based protocol
        bx = self.bytes_in_xfer
        if not bx:
            return
        reg = bx[0][2]
        self.put_ann(bx[0][0], bx[0][1], 1, f"REG=0x{reg:02X}")
        if len(bx) > 1:
            byte_str = " ".join(f"{b[2]:02X}" for b in bx[1:6])
            self.put_ann(bx[1][0], bx[-1][1], 3, f"data: {byte_str}")

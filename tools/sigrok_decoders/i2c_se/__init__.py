"""sigrok protocol decoder: I2C → Secure Element command/response classification.

Stacks on top of the built-in 'i2c' decoder. For each I2C transaction:
- Identifies the device by 7-bit address (ATECC608, SE050, OPTIGA, etc.)
- For ATECC608: parses Word Address byte (0x03=Command, 0x00=Reset, 0x01=Sleep,
  0x02=Idle), then for Command packets decodes Count + Opcode + Param1/Param2.
- For SE050: identifies T=1 ISO7816 frames (NAD/PCB/LEN/INF/CRC).
- Highlights crypto operations (Sign, Verify, Random, ECDH).

Install:
  cp -r tools/sigrok_decoders/i2c_se ~/.local/share/libsigrokdecode/decoders/
Then in PulseView: Decoders → "I2C SE classifier", stack onto an I2C decoder.
"""
from .pd import Decoder

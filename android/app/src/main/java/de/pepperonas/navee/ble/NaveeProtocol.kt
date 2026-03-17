package de.pepperonas.navee.ble

import java.util.UUID

/**
 * Navee BLE protocol — command mapping based on official APK decompilation + BT capture verification.
 *
 * Frame format: 55 AA [FLAG] [CMD] [LEN] [DATA...] [CHECKSUM] FE FD
 *
 * IMPORTANT: parseFrame returns data starting at the version/type byte.
 * Actual payload starts at data[1] (offset +1). All parsers account for this.
 */
object NaveeProtocol {

    val SERVICE_UUID: UUID = UUID.fromString("0000d0ff-3c17-d293-8e48-14fe2e4da212")
    val WRITE_CHAR_UUID: UUID = UUID.fromString("0000b002-0000-1000-8000-00805f9b34fb")
    val NOTIFY_CHAR_UUID: UUID = UUID.fromString("0000b003-0000-1000-8000-00805f9b34fb")
    val CCCD_UUID: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")

    // Write commands (single byte)
    const val CMD_LOCK: Byte = 0x51
    const val CMD_CRUISE: Byte = 0x52
    const val CMD_ERS: Byte = 0x53
    const val CMD_TAILLIGHT: Byte = 0x54     // Rücklicht ein/aus
    const val CMD_AUTO_HEADLIGHT: Byte = 0x57 // Frontlicht Auto-Sensor
    const val CMD_SPEED_MODE: Byte = 0x58
    const val CMD_TURN_SOUND: Byte = 0x60     // Blinker-Ton (nicht Rücklicht!)
    const val CMD_STARTUP_SPEED: Byte = 0x6A
    const val CMD_SPEED_LIMIT: Byte = 0x6B

    // Write commands (multi-byte)
    const val CMD_MAX_SPEED: Byte = 0x6E
    const val CMD_SET_PARAMS: Byte = 0x6F

    // Read commands
    const val CMD_STATUS: Byte = 0x70
    const val CMD_BATTERY: Byte = 0x72
    const val CMD_FIRMWARE: Byte = 0x73
    const val CMD_SERIAL: Byte = 0x74
    const val CMD_DRIVE_HISTORY: Byte = 0x76

    // Auth
    const val CMD_AUTH: Byte = 0x30
    const val CMD_AUTH_KEY: Byte = 0x31

    // Telemetry (unsolicited from scooter)
    const val CMD_TELEM_HOME: Byte = 0x90.toByte()   // HomePage: battery, range, voltage
    const val CMD_TELEM_DRIVE: Byte = 0x92.toByte()   // DrivePage: speed, distance, trip

    const val SPEED_MODE_ECO: Byte = 0x03
    const val SPEED_MODE_SPORT: Byte = 0x05

    private val HEADER = byteArrayOf(0x55, 0xAA.toByte())
    private val FOOTER = byteArrayOf(0xFE.toByte(), 0xFD.toByte())

    fun buildFrame(cmd: Byte, data: ByteArray = byteArrayOf()): ByteArray {
        val body = if (data.isEmpty()) {
            byteArrayOf(0x00, cmd)
        } else {
            byteArrayOf(0x00, cmd) + byteArrayOf(data.size.toByte()) + data
        }
        val withHeader = HEADER + body
        val checksum = (withHeader.sumOf { it.toInt() and 0xFF } and 0xFF).toByte()
        return withHeader + checksum + FOOTER
    }

    // Read requests
    fun statusRequest() = buildFrame(CMD_STATUS)
    fun serialRequest() = buildFrame(CMD_SERIAL)
    fun firmwareRequest() = buildFrame(CMD_FIRMWARE)
    fun batteryRequest() = buildFrame(CMD_BATTERY)

    // Write commands
    fun setLock(locked: Boolean) = buildFrame(CMD_LOCK, byteArrayOf(if (locked) 0x01 else 0x00))
    fun setCruise(on: Boolean) = buildFrame(CMD_CRUISE, byteArrayOf(if (on) 0x01 else 0x00))
    fun setSpeedMode(mode: Byte) = buildFrame(CMD_SPEED_MODE, byteArrayOf(mode))
    fun setERS(level: Byte) = buildFrame(CMD_ERS, byteArrayOf(level))
    fun setStartupSpeed(level: Byte) = buildFrame(CMD_STARTUP_SPEED, byteArrayOf(level))
    fun setMaxSpeed(kmh: Int) = buildFrame(CMD_MAX_SPEED, byteArrayOf(0x01, kmh.toByte()))
    fun setCustomSpeedLimit(kmh: Int, enabled: Boolean): ByteArray {
        val value = if (enabled) (0x80 or (kmh and 0x7F)) else 0x00
        return buildFrame(CMD_SPEED_LIMIT, byteArrayOf(value.toByte()))
    }

    fun parseFrame(raw: ByteArray): ParsedFrame? {
        if (raw.size < 5) return null
        if (raw[0] != 0x55.toByte() || raw[1] != 0xAA.toByte()) return null
        if (raw[raw.size - 2] != 0xFE.toByte() || raw[raw.size - 1] != 0xFD.toByte()) return null
        val body = raw.copyOfRange(2, raw.size - 2)
        if (body.size < 2) return null
        val cmd = body[1]
        return if (body.size > 3) {
            val len = body[2].toInt() and 0xFF
            val data = if (body.size >= 3 + len) body.copyOfRange(3, 3 + len) else body.copyOfRange(3, body.size - 1)
            ParsedFrame(cmd, data)
        } else {
            ParsedFrame(cmd, byteArrayOf())
        }
    }

    fun extractPID(scanRecord: ByteArray?): Int? {
        if (scanRecord == null || scanRecord.size <= 8) return null
        val lo = scanRecord[6].toInt() and 0xFF
        val hi = scanRecord[7].toInt() and 0xFF
        return (hi shl 8) or lo
    }

    data class ParsedFrame(val cmd: Byte, val data: ByteArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is ParsedFrame) return false
            return cmd == other.cmd && data.contentEquals(other.data)
        }
        override fun hashCode() = 31 * cmd.hashCode() + data.contentHashCode()
    }
}

// --- Helper: read little-endian int from byte array ---
private fun ByteArray.readU8(index: Int): Int =
    if (size > index) this[index].toInt() and 0xFF else 0

private fun ByteArray.readU16LE(index: Int): Int =
    if (size > index + 1) (this[index].toInt() and 0xFF) or ((this[index + 1].toInt() and 0xFF) shl 8) else 0

// ============================================================
// Data classes
// ============================================================

data class ScooterState(
    val speedMode: Int = 3,         // 03=ECO, 05=SPORT
    val locked: Boolean = false,
    val cruiseOn: Boolean = false,
    val taillightOn: Boolean = false,
    val ersLevel: Int = 0,
    val autoHeadlight: Boolean = false, // 0x57 auto-sensor
    val tcsOn: Boolean = false,         // 0x59 traction control, byte 12
    val turnSound: Boolean = false,     // 0x60 blinker sound, byte 13
    val maxSpeed: Int = 0,
)

data class ScooterTelemetry(
    val battery: Int = 0,           // 0-100%
    val remainRange: Int = 0,       // km remaining
    val batteryVoltage: Int = 0,    // mV
    val speed: Int = 0,             // raw, /10 for km/h
    val totalMileage: Int = 0,      // total odometer
    val tripMileage: Int = 0,       // current trip
)

// ============================================================
// Parsers — all verified against decompiled official APK
// data[0] is version/type byte, actual payload at data[1+]
// ============================================================

/**
 * Parse 0x70 status response.
 * Official APK byte mapping (offset +1 from our data[]):
 *   data[1]=bindingStatus, data[2]=drivingMode, data[3]=lockStatus,
 *   data[4]=ccsStatus, data[5]=tailIsOn, data[6]=ersStatus, ...
 *   data[26]=maxSpeed
 *
 * Headlight (data[10]) and taillight (data[14]) positions verified via BT capture.
 */
fun parseStatus(data: ByteArray): ScooterState? {
    if (data.size < 14) return null
    return ScooterState(
        speedMode = data.readU8(2),          // 03=ECO, 05=SPORT
        locked = data.readU8(3) != 0,        // 0x51
        cruiseOn = data.readU8(4) != 0,      // 0x52
        taillightOn = data.readU8(5) != 0,   // 0x54
        ersLevel = data.readU8(6),           // 0x53
        autoHeadlight = data.readU8(9) != 0, // 0x57
        tcsOn = data.readU8(12) != 0,        // official byte 11 = tcsSwitch
        turnSound = data.readU8(13) != 0,    // official byte 12 = turnSound (0x60)
        maxSpeed = if (data.size > 26) data.readU8(26) else 0,
    )
}

/**
 * Parse 0x90 Home Page telemetry.
 * Official APK (DeviceHomePageInfo):
 *   byte 0=warningCode, 1=drivingMode, 2=batteryCharge, 3=batteryStatus,
 *   4=chargingState, 5=lockPushWarn, 6=remainMileage, 7=lockStatus,
 *   bytes 8-11=batteryVoltage (4 bytes LE)
 */
fun parseHomeTelemetry(data: ByteArray): ScooterTelemetry? {
    if (data.size < 8) return null
    // +1 offset: official byte N = data[N+1]
    val battery = data.readU8(3)         // byte 2 = batteryCharge
    val remainRange = data.readU8(7)     // byte 6 = remainMileage (km)
    val voltage = if (data.size >= 13) { // bytes 8-11 = batteryVoltage (4 bytes LE)
        (data.readU8(9)) or (data.readU8(10) shl 8) or
        (data.readU8(11) shl 16) or (data.readU8(12) shl 24)
    } else 0
    return ScooterTelemetry(
        battery = battery,
        remainRange = remainRange,
        batteryVoltage = voltage,
    )
}

/**
 * Parse 0x92 Drive Page telemetry (version 1).
 * Official APK (DeviceSubPageInfo, version=1):
 *   byte 0=batteryCharge, 1=drivingStatus, bytes 2-3=realTimeSpeed (LE, /10 for km/h),
 *   byte 4=remainMileage, bytes 5-6=drivingMileage, byte 7=drivingDuration,
 *   bytes 8-9=maxSpeed, 10-11=avgSpeed, 12-13=totalMileage,
 *   bytes 14-17=totalMileage override (4 bytes LE, if available)
 */
fun parseDriveTelemetry(data: ByteArray, current: ScooterTelemetry): ScooterTelemetry? {
    if (data.size < 14) return null
    // +1 offset: official byte N = data[N+1]
    val battery = data.readU8(1)         // byte 0 = batteryCharge
    val speed = data.readU16LE(3)        // bytes 2-3 = realTimeSpeed (LE)
    val remainRange = data.readU8(5)     // byte 4 = remainMileage
    val tripMileage = data.readU16LE(6)  // bytes 5-6 = drivingMileage
    var totalMileage = data.readU16LE(13) // bytes 12-13 = totalMileage
    // 4-byte override if available
    if (data.size >= 19) {
        val total4 = (data.readU8(15)) or (data.readU8(16) shl 8) or
                     (data.readU8(17) shl 16) or (data.readU8(18) shl 24)
        if (total4 > 0) totalMileage = total4
    }
    return ScooterTelemetry(
        battery = battery,
        remainRange = remainRange,
        batteryVoltage = current.batteryVoltage, // keep from 0x90
        speed = speed,
        totalMileage = totalMileage,
        tripMileage = tripMileage,
    )
}

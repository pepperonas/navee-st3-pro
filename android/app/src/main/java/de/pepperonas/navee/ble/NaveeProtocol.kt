package de.pepperonas.navee.ble

import java.util.UUID

/**
 * Navee BLE protocol — corrected command mapping based on official APK decompilation.
 *
 * Frame format: 55 AA 00 <CMD> [LEN] [DATA...] <CHECKSUM> FE FD
 * Checksum = sum of all bytes (including 55 AA header) mod 256
 */
object NaveeProtocol {

    // BLE UUIDs
    val SERVICE_UUID: UUID = UUID.fromString("0000d0ff-3c17-d293-8e48-14fe2e4da212")
    val WRITE_CHAR_UUID: UUID = UUID.fromString("0000b002-0000-1000-8000-00805f9b34fb")
    val NOTIFY_CHAR_UUID: UUID = UUID.fromString("0000b003-0000-1000-8000-00805f9b34fb")
    val CCCD_UUID: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")

    // --- Write commands (single byte parameter) ---
    const val CMD_UNBIND: Byte = 0x50
    const val CMD_LOCK: Byte = 0x51           // 0=unlock, 1=lock
    const val CMD_CRUISE: Byte = 0x52         // 0=off, 1=on (official mapping)
    const val CMD_ERS: Byte = 0x53            // Energy Recovery Strength (regen braking)
    const val CMD_MILEAGE_UNIT: Byte = 0x55   // 0=MPH, 1=KM
    const val CMD_MILEAGE_ALGO: Byte = 0x56   // Mileage algorithm
    const val CMD_SPEED_MODE: Byte = 0x58     // 3=ECO, 5=SPORT
    const val CMD_RESET_VEHICLE: Byte = 0x59  // Reset/restore vehicle
    const val CMD_TIRE_MAINT: Byte = 0x5A     // Tire maintenance (param=1)
    const val CMD_AMBIENT_LIGHT: Byte = 0x5E  // Ambient light
    const val CMD_PROXIMITY_KEY: Byte = 0x61  // Proximity key toggle
    const val CMD_STARTUP_SPEED: Byte = 0x6A  // Startup speed (0-5, 0.0-3.0 m/s)
    const val CMD_SPEED_LIMIT: Byte = 0x6B    // Custom speed limit (bit7=enable, bits0-6=km/h)
    const val CMD_WEATHER: Byte = 0x80.toByte() // Weather update

    // --- Write commands (multi-byte data) ---
    const val CMD_SET_PASSWORD: Byte = 0x63   // Set digit password (6 bytes)
    const val CMD_LIGHT_CTRL: Byte = 0x67     // Light control (variable length)
    const val CMD_MAX_SPEED: Byte = 0x6E      // Set max speed [0x01, km/h]
    const val CMD_SET_PARAMS: Byte = 0x6F     // Set scooter parameters (variable)

    // --- Read/status commands ---
    const val CMD_STATUS: Byte = 0x70         // Read vehicle settings (39 bytes response)
    const val CMD_TRIP_DATA: Byte = 0x71      // Read driving/trip data
    const val CMD_BATTERY: Byte = 0x72        // Read battery status (34+ bytes)
    const val CMD_FIRMWARE: Byte = 0x73       // Read firmware versions (16+ bytes)
    const val CMD_SERIAL: Byte = 0x74         // Read serial number (17 bytes)
    const val CMD_BATTERY_SN: Byte = 0x75     // Read battery serial number
    const val CMD_DRIVE_HISTORY: Byte = 0x76  // Read drive history
    const val CMD_BATTERY_EXTRA: Byte = 0x79  // Read battery extra info
    const val CMD_PASSWORD_STATUS: Byte = 0x7A // Read password & switch status

    // --- Auth commands ---
    const val CMD_AUTH: Byte = 0x30           // Auth challenge/identity
    const val CMD_AUTH_KEY: Byte = 0x31       // Encrypted response/key

    // --- Unsolicited telemetry ---
    const val CMD_TELEMETRY_90: Byte = 0x90.toByte()  // Home page telemetry (15+ bytes)
    const val CMD_TELEMETRY_91: Byte = 0x91.toByte()  // Realtime status v0 (9 bytes)
    const val CMD_TELEMETRY_92: Byte = 0x92.toByte()  // Realtime status v1 (14+ bytes)

    // Speed modes
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
    fun tripRequest() = buildFrame(CMD_DRIVE_HISTORY)
    fun batteryRequest() = buildFrame(CMD_BATTERY)
    fun batterySNRequest() = buildFrame(CMD_BATTERY_SN)
    fun batteryExtraRequest() = buildFrame(CMD_BATTERY_EXTRA)

    // Write commands
    fun setLock(locked: Boolean) = buildFrame(CMD_LOCK, byteArrayOf(if (locked) 0x01 else 0x00))
    fun setCruise(on: Boolean) = buildFrame(CMD_CRUISE, byteArrayOf(if (on) 0x01 else 0x00))
    fun setSpeedMode(mode: Byte) = buildFrame(CMD_SPEED_MODE, byteArrayOf(mode))
    fun setERS(level: Byte) = buildFrame(CMD_ERS, byteArrayOf(level))
    fun setAmbientLight(value: Byte) = buildFrame(CMD_AMBIENT_LIGHT, byteArrayOf(value))
    fun setProximityKey(on: Boolean) = buildFrame(CMD_PROXIMITY_KEY, byteArrayOf(if (on) 0x01 else 0x00))
    fun setStartupSpeed(level: Byte) = buildFrame(CMD_STARTUP_SPEED, byteArrayOf(level))

    /** Set max speed in absolute km/h. Data format: [0x01, speed_kmh]. */
    fun setMaxSpeed(kmh: Int) = buildFrame(CMD_MAX_SPEED, byteArrayOf(0x01, kmh.toByte()))

    /** Set custom speed limit. Bit 7 = enabled, bits 0-6 = speed in km/h. */
    fun setCustomSpeedLimit(kmh: Int, enabled: Boolean): ByteArray {
        val value = if (enabled) (0x80 or (kmh and 0x7F)) else 0x00
        return buildFrame(CMD_SPEED_LIMIT, byteArrayOf(value.toByte()))
    }

    /** Light control (multi-byte). */
    fun setLight(data: ByteArray) = buildFrame(CMD_LIGHT_CTRL, data)

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

    /** Extract PID from BLE scan record bytes 6-8 (little-endian 16-bit). */
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

/**
 * Full 39-byte status response from CMD_STATUS (0x70).
 * Byte indices based on official Navee APK decompilation.
 */
data class ScooterState(
    // Byte 0: binding status
    val bound: Boolean = false,
    // Byte 1: driving mode (3=ECO, 5=SPORT)
    val speedMode: Int = 3,
    // Byte 2: lock status
    val locked: Boolean = false,
    // Byte 3: cruise control
    val cruiseOn: Boolean = false,
    // Byte 4: tail light
    val taillightOn: Boolean = false,
    // Byte 5: ERS/regen level
    val ersLevel: Int = 3,
    // Byte 6: mileage algorithm
    val mileageAlgo: Int = 0,
    // Byte 7: mileage unit (0=MPH, 1=KM)
    val mileageUnit: Int = 1,
    // Byte 8: auto sensor
    val autoSensor: Boolean = false,
    // Byte 9: tyre switch
    val tyreSwitch: Boolean = false,
    // Byte 10: ambient light
    val ambientLight: Int = 0,
    // Byte 11: TCS switch
    val tcsSwitch: Boolean = false,
    // Byte 12: turn sound
    val turnSound: Boolean = false,
    // Byte 13: proximity key
    val proximityKey: Boolean = false,
    // Byte 14: night mode
    val nightMode: Boolean = false,
    // Byte 19: startup speed (0-5)
    val startupSpeed: Int = 3,
    // Byte 20: speed limit (bit7=enabled, bits0-6=km/h)
    val speedLimitEnabled: Boolean = false,
    val speedLimitKmh: Int = 0,
    // Byte 25: max speed (absolute km/h)
    val maxSpeed: Int = 0,
    // Byte 26: drive mode via ECU
    val driveMode: Int = 0,
    // Headlight — derived from light control, not in 0x70 response
    val headlightOn: Boolean = false,
)

data class ScooterTelemetry(
    val battery: Int = 0,
    val speed: Int = 0,             // raw value, /10 for km/h
    val temperature: Int = 0,
    val totalDistance: Int = 0,      // raw, /10 for km
)

data class BatteryInfo(
    val voltage: Int = 0,           // mV
    val current: Int = 0,           // mA
    val temperature: Int = 0,
    val cycles: Int = 0,
    val health: Int = 0,            // %
)

/**
 * Parse 0x70 status response.
 * Actual data from device (37 bytes after cmd+len):
 *   [0]=00 [1]=01 [2]=05 [3]=01 [4]=00 [5]=00 [6]=5A [7]=00 [8]=01
 *   [9]=00 [10]=00 [11]=00 [12]=00 [13]=00 [14]=02 [15]=00 [16]=01
 *   [17]=00 [18]=00 [19]=00 [20]=03 [21]=00 [22]=00 [23]=00 [24]=00
 *   [25]=00 [26]=16 [27]=00 ...
 *
 * Official APK mapping (b4/a.java):
 *   0=bind, 1=driveMode, 2=lock, 3=CCS, 4=taillight, 5=ERS,
 *   6=mileAlgo, 7=mileUnit, 8=autoSensor, 9=tyreSwitch, 10=ambientLight,
 *   11=TCS, 12=turnSound, 13=proximityKey, 14=nightMode, 15=mileAlgoMode,
 *   16=lightE, 17=lightD, 18=lightS, 19=startSpeed, 20=limitSpeed,
 *   21=volume, 22=reportLang, 23=logoLight, 24=dayRunLight,
 *   25=maxSpeed, 26=driveMode2, ...
 */
fun parseStatus(data: ByteArray, previousState: ScooterState = ScooterState()): ScooterState? {
    if (data.size < 6) return null
    return ScooterState(
        bound = data[0] != 0x00.toByte(),
        speedMode = data[1].toInt() and 0xFF,
        locked = data[2].toInt() and 0xFF != 0,
        cruiseOn = data[3] == 0x01.toByte(),
        taillightOn = data[4] == 0x01.toByte(),
        ersLevel = data[5].toInt() and 0xFF,
        mileageAlgo = if (data.size > 6) data[6].toInt() and 0xFF else 0,
        mileageUnit = if (data.size > 7) data[7].toInt() and 0xFF else 1,
        autoSensor = data.size > 8 && data[8] == 0x01.toByte(),
        tyreSwitch = data.size > 9 && data[9] == 0x01.toByte(),
        ambientLight = if (data.size > 10) data[10].toInt() and 0xFF else 0,
        tcsSwitch = data.size > 11 && data[11] == 0x01.toByte(),
        turnSound = data.size > 12 && data[12] == 0x01.toByte(),
        proximityKey = data.size > 13 && data[13] == 0x01.toByte(),
        nightMode = data.size > 14 && data[14] == 0x01.toByte(),
        startupSpeed = if (data.size > 19) data[19].toInt() and 0xFF else 3,
        speedLimitEnabled = data.size > 20 && (data[20].toInt() and 0x80) != 0,
        speedLimitKmh = if (data.size > 20) data[20].toInt() and 0x7F else 0,
        maxSpeed = if (data.size > 26) data[26].toInt() and 0xFF else
                   if (data.size > 25) data[25].toInt() and 0xFF else 0,
        driveMode = if (data.size > 26) data[26].toInt() and 0xFF else 0,
        headlightOn = previousState.headlightOn,
    )
}

/**
 * Parse 0x90 telemetry (15+ bytes).
 */
fun parseTelemetry(data: ByteArray): ScooterTelemetry? {
    if (data.size < 11) return null
    return ScooterTelemetry(
        battery = data[3].toInt() and 0xFF,
        speed = ((data[5].toInt() and 0xFF) or ((data[6].toInt() and 0xFF) shl 8)),
        temperature = data[7].toInt() and 0xFF,
        totalDistance = ((data[9].toInt() and 0xFF) or ((data[10].toInt() and 0xFF) shl 8)),
    )
}

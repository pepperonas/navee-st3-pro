package de.pepperonas.navee.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import de.pepperonas.navee.ble.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ScooterViewModel(app: Application) : AndroidViewModel(app) {

    companion object {
        private const val TAG = "ScooterVM"

        fun getMaxSpeedOptionsForPID(pid: Int?): List<Int> = when (pid) {
            2509 -> listOf(25, 30, 35, 40)
            2511, 2516 -> listOf(25, 32, 45, 50)
            2547 -> listOf(25, 32, 40, 50, 60)
            2585 -> listOf(25, 32, 40, 50, 70)
            2544 -> listOf(25, 30, 35, 40, 45, 50, 55, 60)
            2449 -> listOf(25, 30, 35, 40, 45, 50, 55, 60, 65)
            2416, 2443, 2529 -> listOf(25, 32, 45, 50)
            2611, 2612, 2643 -> listOf(25, 32)
            else -> listOf(20, 25, 30, 32, 35, 40)
        }
    }

    val ble = NaveeBleManager(app.applicationContext)
    val connectionState = ble.connectionState
    val deviceName = ble.deviceName
    val pid = ble.pid

    private val _state = MutableStateFlow(ScooterState())
    val state: StateFlow<ScooterState> = _state

    private val _telemetry = MutableStateFlow(ScooterTelemetry())
    val telemetry: StateFlow<ScooterTelemetry> = _telemetry

    private val _serial = MutableStateFlow("")
    val serial: StateFlow<String> = _serial

    private val _firmware = MutableStateFlow("")
    val firmware: StateFlow<String> = _firmware

    private val _authenticated = MutableStateFlow(false)
    val authenticated: StateFlow<Boolean> = _authenticated

    private var pollingJob: Job? = null
    private var commandCooldown = false

    val maxSpeedOptions: StateFlow<List<Int>> = pid.map { pid ->
        getMaxSpeedOptionsForPID(pid)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, listOf(25, 32, 40))

    init {
        NaveeAuth.init(app.applicationContext)

        viewModelScope.launch {
            ble.incomingFrames.collect { frame -> handleFrame(frame) }
        }

        viewModelScope.launch {
            ble.connectionState.collect { connState ->
                when (connState) {
                    ConnectionState.CONNECTED -> {
                        _authenticated.value = false
                        pollingJob?.cancel()
                        startAuthThenPoll()
                    }
                    ConnectionState.DISCONNECTED -> {
                        _authenticated.value = false
                        pollingJob?.cancel()
                        delay(3000)
                        if (ble.connectionState.value == ConnectionState.DISCONNECTED) {
                            ble.startScan()
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    fun connect() = ble.startScan()
    fun disconnect() = ble.disconnect()

    fun toggleLock() {
        _state.value = _state.value.copy(locked = !_state.value.locked)
        ble.send(NaveeProtocol.setLock(_state.value.locked))
        requestStatusDelayed()
    }

    fun toggleCruise() {
        _state.value = _state.value.copy(cruiseOn = !_state.value.cruiseOn)
        ble.send(NaveeProtocol.setCruise(_state.value.cruiseOn))
        requestStatusDelayed()
    }

    fun toggleLight() {
        val on = !_state.value.autoHeadlight
        Log.i(TAG, "toggleLight -> $on")
        _state.value = _state.value.copy(autoHeadlight = on)
        ble.send(NaveeProtocol.buildFrame(NaveeProtocol.CMD_AUTO_HEADLIGHT, byteArrayOf(if (on) 0x01 else 0x00)))
        requestStatusDelayed()
    }

    fun toggleTcs() {
        val on = !_state.value.tcsOn
        _state.value = _state.value.copy(tcsOn = on)
        ble.send(NaveeProtocol.buildFrame(0x5F, byteArrayOf(if (on) 0x01 else 0x00)))
        requestStatusDelayed()
    }

    fun toggleTurnSound() {
        val on = !_state.value.turnSound
        _state.value = _state.value.copy(turnSound = on)
        ble.send(NaveeProtocol.buildFrame(NaveeProtocol.CMD_TURN_SOUND, byteArrayOf(if (on) 0x01 else 0x00)))
        requestStatusDelayed()
    }

    fun setSpeedMode(eco: Boolean) {
        val mode = if (eco) NaveeProtocol.SPEED_MODE_ECO else NaveeProtocol.SPEED_MODE_SPORT
        ble.send(NaveeProtocol.setSpeedMode(mode))
        requestStatusDelayed()
    }

    fun setMaxSpeed(kmh: Int) {
        ble.send(NaveeProtocol.setMaxSpeed(kmh))
        requestStatusDelayed()
    }

    fun setErsLevel(level: Int) {
        ble.send(NaveeProtocol.setERS(level.toByte()))
        requestStatusDelayed()
    }

    private fun requestStatusDelayed() {
        viewModelScope.launch {
            commandCooldown = true
            delay(1500)
            commandCooldown = false
            ble.send(NaveeProtocol.statusRequest())
        }
    }

    private fun startAuthThenPoll() {
        viewModelScope.launch {
            if (NaveeAuth.hasCredentials()) {
                Log.i(TAG, "Authenticating...")
                NaveeAuth.buildAuthRequest()?.let { ble.send(it) }
                delay(5000)
                if (!_authenticated.value) {
                    Log.w(TAG, "Auth timeout")
                    startPolling()
                }
            } else {
                startPolling()
            }
        }
    }

    private fun startPolling() {
        pollingJob?.cancel()
        pollingJob = viewModelScope.launch {
            ble.send(NaveeProtocol.serialRequest())
            delay(200)
            ble.send(NaveeProtocol.firmwareRequest())
            delay(200)
            ble.send(NaveeProtocol.statusRequest())

            while (ble.connectionState.value == ConnectionState.CONNECTED) {
                delay(2000)
                ble.send(NaveeProtocol.statusRequest())
            }
        }
    }

    private fun handleFrame(frame: NaveeProtocol.ParsedFrame) {
        when (frame.cmd) {
            NaveeProtocol.CMD_AUTH -> {
                val success = frame.data.isNotEmpty() && frame.data[0] == 0x00.toByte()
                _authenticated.value = success
                Log.i(TAG, "Auth: ${if (success) "OK" else "FAILED (${frame.data.getOrNull(0)?.toInt()?.and(0xFF)})"}")
                if (success) {
                    NaveeAuth.buildPostAuthParams()?.let { ble.send(it) }
                }
                viewModelScope.launch {
                    delay(200)
                    startPolling()
                }
            }
            NaveeProtocol.CMD_STATUS -> {
                if (!commandCooldown) {
                    parseStatus(frame.data)?.let { _state.value = it }
                }
            }
            NaveeProtocol.CMD_TELEM_HOME -> {
                parseHomeTelemetry(frame.data)?.let { home ->
                    _telemetry.value = _telemetry.value.copy(
                        battery = home.battery,
                        remainRange = home.remainRange,
                        batteryVoltage = home.batteryVoltage,
                    )
                }
            }
            NaveeProtocol.CMD_TELEM_DRIVE -> {
                parseDriveTelemetry(frame.data, _telemetry.value)?.let { drive ->
                    _telemetry.value = drive
                }
            }
            NaveeProtocol.CMD_SERIAL -> {
                _serial.value = frame.data.drop(1)
                    .takeWhile { it != 0x00.toByte() }
                    .toByteArray()
                    .toString(Charsets.US_ASCII)
            }
            NaveeProtocol.CMD_FIRMWARE -> {
                _firmware.value = frame.data.drop(1)
                    .takeWhile { it != 0x00.toByte() }
                    .toByteArray()
                    .toString(Charsets.US_ASCII)
            }
            else -> {}
        }
    }

    override fun onCleared() {
        super.onCleared()
        ble.disconnect()
    }
}

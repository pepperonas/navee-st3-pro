package de.pepperonas.navee.ble

import android.annotation.SuppressLint
import android.bluetooth.*
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

enum class ConnectionState { DISCONNECTED, SCANNING, CONNECTING, CONNECTED }

@SuppressLint("MissingPermission")
class NaveeBleManager(private val context: Context) {

    companion object {
        private const val TAG = "NaveeBLE"
    }

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var bluetoothGatt: BluetoothGatt? = null
    private var writeChar: BluetoothGattCharacteristic? = null
    private var notifyChar: BluetoothGattCharacteristic? = null

    private val _connectionState = MutableStateFlow(ConnectionState.DISCONNECTED)
    val connectionState: StateFlow<ConnectionState> = _connectionState

    private val _deviceName = MutableStateFlow<String?>(null)
    val deviceName: StateFlow<String?> = _deviceName

    private val _macAddress = MutableStateFlow<String?>(null)
    val macAddress: StateFlow<String?> = _macAddress

    /** Product ID extracted from BLE scan record bytes 6-8. */
    private val _pid = MutableStateFlow<Int?>(null)
    val pid: StateFlow<Int?> = _pid

    private val _incomingFrames = MutableSharedFlow<NaveeProtocol.ParsedFrame>(extraBufferCapacity = 64)
    val incomingFrames: SharedFlow<NaveeProtocol.ParsedFrame> = _incomingFrames

    private val writeQueue = Channel<ByteArray>(capacity = 32)
    private val writeComplete = Channel<Unit>(capacity = 1)
    private var writeJob: Job? = null

    private val prefs = context.getSharedPreferences("navee_ble", Context.MODE_PRIVATE)

    private val adapter: BluetoothAdapter?
        get() = (context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager)?.adapter

    /** Try direct connect to last known MAC, fall back to scan. */
    fun startScan() {
        val lastMac = prefs.getString("last_mac", null)
        if (lastMac != null) {
            Log.i(TAG, "Trying direct connect to $lastMac")
            _connectionState.value = ConnectionState.CONNECTING
            val device = adapter?.getRemoteDevice(lastMac)
            if (device != null) {
                device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
                // Timeout: if not connected in 5s, fall back to scan
                scope.launch {
                    delay(5000)
                    if (_connectionState.value == ConnectionState.CONNECTING) {
                        Log.i(TAG, "Direct connect timeout, falling back to scan")
                        bluetoothGatt?.close()
                        bluetoothGatt = null
                        startBLEScan()
                    }
                }
                return
            }
        }
        startBLEScan()
    }

    private fun startBLEScan() {
        val scanner = adapter?.bluetoothLeScanner ?: run {
            Log.e(TAG, "BLE scanner not available")
            return
        }
        _connectionState.value = ConnectionState.SCANNING

        val settings = ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
            .build()

        scanner.startScan(null, settings, scanCallback)

        scope.launch {
            delay(15_000)
            if (_connectionState.value == ConnectionState.SCANNING) {
                scanner.stopScan(scanCallback)
                _connectionState.value = ConnectionState.DISCONNECTED
            }
        }
    }

    fun disconnect() {
        writeJob?.cancel()
        bluetoothGatt?.disconnect()
        bluetoothGatt?.close()
        bluetoothGatt = null
        writeChar = null
        notifyChar = null
        _connectionState.value = ConnectionState.DISCONNECTED
        _deviceName.value = null
        _macAddress.value = null
        _pid.value = null
    }

    fun send(data: ByteArray) {
        writeQueue.trySend(data)
    }

    private val scanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            val device = result.device
            val name = device.name ?: return

            if (!name.startsWith("Navee", ignoreCase = true) &&
                !name.startsWith("NV", ignoreCase = true) &&
                !name.startsWith("ST3", ignoreCase = true)) {
                return
            }

            adapter?.bluetoothLeScanner?.stopScan(this)
            _deviceName.value = name
            _macAddress.value = device.address
            prefs.edit().putString("last_mac", device.address).apply()
            Log.i(TAG, "Found Navee: $name (${device.address})")

            val scanRecord = result.scanRecord?.bytes
            val pid = NaveeProtocol.extractPID(scanRecord)
            _pid.value = pid
            Log.i(TAG, "PID=$pid, scanRecord=${scanRecord?.joinToString(" ") { "%02X".format(it) }}")

            _connectionState.value = ConnectionState.CONNECTING
            device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
        }

        override fun onScanFailed(errorCode: Int) {
            Log.e(TAG, "Scan failed: $errorCode")
            _connectionState.value = ConnectionState.DISCONNECTED
        }
    }

    private val gattCallback = object : BluetoothGattCallback() {

        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            when (newState) {
                BluetoothProfile.STATE_CONNECTED -> {
                    Log.i(TAG, "Connected, discovering services...")
                    bluetoothGatt = gatt
                    gatt.requestMtu(247)
                }
                BluetoothProfile.STATE_DISCONNECTED -> {
                    Log.i(TAG, "Disconnected")
                    writeJob?.cancel()
                    _connectionState.value = ConnectionState.DISCONNECTED
                    gatt.close()
                    bluetoothGatt = null
                }
            }
        }

        override fun onMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
            Log.i(TAG, "MTU changed to $mtu")
            gatt.discoverServices()
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            if (status != BluetoothGatt.GATT_SUCCESS) {
                Log.e(TAG, "Service discovery failed: $status")
                return
            }
            val service = gatt.getService(NaveeProtocol.SERVICE_UUID)
            if (service == null) {
                Log.e(TAG, "Navee service not found!")
                return
            }

            writeChar = service.getCharacteristic(NaveeProtocol.WRITE_CHAR_UUID)
            notifyChar = service.getCharacteristic(NaveeProtocol.NOTIFY_CHAR_UUID)

            // Enable notifications
            notifyChar?.let { char ->
                gatt.setCharacteristicNotification(char, true)
                val descriptor = char.getDescriptor(NaveeProtocol.CCCD_UUID)
                descriptor?.let {
                    it.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                    gatt.writeDescriptor(it)
                }
            }

            _connectionState.value = ConnectionState.CONNECTED
            startWriteProcessor()
            Log.i(TAG, "Ready — write=${writeChar != null}, notify=${notifyChar != null}")
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            Log.i(TAG, "Descriptor write status=$status")
            // Signal that GATT is ready for characteristic writes
            writeComplete.trySend(Unit)
        }

        override fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
            // Signal write completion so next write can proceed
            writeComplete.trySend(Unit)
        }

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic
        ) {
            val raw = characteristic.value ?: return
            Log.d(TAG, "RX: ${raw.joinToString(" ") { "%02X".format(it) }}")
            NaveeProtocol.parseFrame(raw)?.let { frame ->
                Log.d(TAG, "Frame: cmd=%02X data=[${frame.data.joinToString(" ") { "%02X".format(it) }}]".format(frame.cmd))
                _incomingFrames.tryEmit(frame)
            }
        }
    }

    private fun startWriteProcessor() {
        writeJob = scope.launch {
            // Wait for descriptor write to complete first
            withTimeoutOrNull(2000) { writeComplete.receive() }

            for (data in writeQueue) {
                val gatt = bluetoothGatt ?: continue
                val char = writeChar ?: continue
                char.value = data
                char.writeType = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
                val ok = gatt.writeCharacteristic(char)
                Log.d(TAG, "TX: ${data.joinToString(" ") { "%02X".format(it) }} ok=$ok")
                if (ok) {
                    // Wait for onCharacteristicWrite callback or timeout
                    withTimeoutOrNull(500) { writeComplete.receive() }
                } else {
                    // Write failed, wait a bit before retry
                    delay(100)
                }
                delay(50) // minimum gap between writes
            }
        }
    }
}

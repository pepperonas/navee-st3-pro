package de.pepperonas.navee.ble

import android.util.Log
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * Navee BLE authentication — AES-ECB challenge-response.
 * 5 hardcoded keys from official APK (b4/a.java line 61).
 */
object NaveeAuth {

    private const val TAG = "NaveeAuth"

    private val KEYS: Array<ByteArray> = arrayOf(
        byteArrayOf(
            0xA0.toByte(), 0xA1.toByte(), 0xA2.toByte(), 0xA3.toByte(),
            0xA4.toByte(), 0xA5.toByte(), 0xA6.toByte(), 0xA7.toByte(),
            0xA8.toByte(), 0xA9.toByte(), 0xAA.toByte(), 0xAB.toByte(),
            0xAC.toByte(), 0xAD.toByte(), 0xAE.toByte(), 0xAF.toByte()
        ),
        byteArrayOf(
            0x44, 0x6D, 0x10, 0x72, 0x6D, 0xBE.toByte(), 0x05, 0xF6.toByte(),
            0x62, 0xDF.toByte(), 0xAA.toByte(), 0xF0.toByte(), 0x13, 0x27, 0x30, 0x3F
        ),
        byteArrayOf(
            0xA2.toByte(), 0x85.toByte(), 0xCC.toByte(), 0xEC.toByte(),
            0x81.toByte(), 0x4F, 0xE9.toByte(), 0x61,
            0x74, 0x29, 0x95.toByte(), 0xE8.toByte(),
            0xEB.toByte(), 0xA9.toByte(), 0x22, 0x47
        ),
        byteArrayOf(
            0x3F, 0xEE.toByte(), 0x80.toByte(), 0xFF.toByte(),
            0x9A.toByte(), 0xDF.toByte(), 0x5C, 0xF5.toByte(),
            0x42, 0xEA.toByte(), 0xAC.toByte(), 0x93.toByte(),
            0x28, 0x1F, 0xE5.toByte(), 0x29
        ),
        byteArrayOf(
            0x4E, 0xB4.toByte(), 0xD4.toByte(), 0x64,
            0xD6.toByte(), 0xEF.toByte(), 0x53, 0xED.toByte(),
            0x6C, 0xE9.toByte(), 0x45, 0x58,
            0xDE.toByte(), 0x9A.toByte(), 0x5E, 0xE3.toByte()
        ),
    )

    /** Currently selected key index (0-4). */
    var selectedKeyIndex: Int = 0
        private set

    /** Device ID extracted from BT capture of official Navee app. */
    private val DEVICE_ID = byteArrayOf(
        0x88.toByte(), 0x00, 0x02, 0x77, 0x53, 0xED.toByte()
    )

    /** Params sent by official app right after auth success. */
    private val POST_AUTH_PARAMS = byteArrayOf(
        0x06, 0x69, 0xB8.toByte(), 0xA9.toByte(), 0x94.toByte()
    )

    /**
     * Build AUTH request (0x30) matching official app's exact format.
     * Key index 1 + device ID from user's Navee account.
     */
    fun buildAuthRequest(): ByteArray {
        selectedKeyIndex = 1  // official app uses key index 1
        val data = byteArrayOf(selectedKeyIndex.toByte(), 0x00) + DEVICE_ID + byteArrayOf(0x00)
        Log.i(TAG, "Auth request: keyIndex=$selectedKeyIndex, deviceId=${DEVICE_ID.joinToString(" ") { "%02X".format(it) }}")
        return NaveeProtocol.buildFrame(NaveeProtocol.CMD_AUTH, data)
    }

    /** Build the SET_PARAMS (0x6F) command sent right after auth. */
    fun buildPostAuthParams(): ByteArray {
        Log.i(TAG, "Sending post-auth params")
        return NaveeProtocol.buildFrame(NaveeProtocol.CMD_SET_PARAMS, POST_AUTH_PARAMS)
    }

    /**
     * Process AUTH response (0x30) from scooter.
     * Returns the AUTH_KEY frame (0x31) to send back, or null if auth failed.
     */
    fun processAuthResponse(data: ByteArray): ByteArray? {
        if (data.isEmpty()) {
            Log.e(TAG, "Empty auth response")
            return null
        }

        val errorCode = data[0].toInt() and 0xFF
        if (errorCode != 0) {
            Log.e(TAG, "Auth error code: $errorCode")
            // Try with error code as a hint; some firmwares put status here
        }

        // Extract encrypted challenge (everything after error code byte)
        val challenge = data.copyOfRange(1, data.size)
        if (challenge.isEmpty()) {
            Log.e(TAG, "No challenge data in auth response")
            return null
        }

        Log.i(TAG, "Challenge (${challenge.size} bytes): ${challenge.joinToString(" ") { "%02X".format(it) }}")

        // Decrypt the challenge
        val decrypted = decryptChallenge(challenge)
        if (decrypted == null) {
            Log.e(TAG, "Failed to decrypt challenge")
            return null
        }

        Log.i(TAG, "Decrypted: ${decrypted.joinToString(" ") { "%02X".format(it) }}")

        // Echo back decrypted challenge as AUTH_KEY (0x31)
        return NaveeProtocol.buildFrame(NaveeProtocol.CMD_AUTH_KEY, decrypted)
    }

    /**
     * Check AUTH_KEY response (0x31) from scooter.
     * Returns true if authentication succeeded.
     */
    fun checkAuthKeyResponse(data: ByteArray): Boolean {
        // Success if first byte is 0x00 or response is empty (ACK)
        val success = data.isEmpty() || (data[0].toInt() and 0xFF) == 0
        Log.i(TAG, "Auth key response: success=$success data=${data.joinToString(" ") { "%02X".format(it) }}")
        return success
    }

    private fun decryptChallenge(encrypted: ByteArray): ByteArray? {
        val key = KEYS[selectedKeyIndex]

        // If challenge is 16 bytes (AES block size), direct AES-ECB decrypt
        if (encrypted.size == 16) {
            return aesDecrypt(encrypted, key)
        }

        // If larger: check first byte for mode
        if (encrypted.size > 16) {
            return if (encrypted[0] == 0x00.toByte()) {
                // XOR mode
                xorDecrypt(encrypted.copyOfRange(1, encrypted.size), key)
            } else {
                // AES mode on first 16 bytes
                aesDecrypt(encrypted.copyOf(16), key)
            }
        }

        // Smaller than 16: pad to 16 and try AES
        val padded = ByteArray(16)
        encrypted.copyInto(padded)
        return aesDecrypt(padded, key)
    }

    private fun aesDecrypt(data: ByteArray, key: ByteArray): ByteArray? {
        return try {
            val cipher = Cipher.getInstance("AES/ECB/NoPadding")
            cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"))
            cipher.doFinal(data)
        } catch (e: Exception) {
            Log.e(TAG, "AES decrypt failed: ${e.message}")
            null
        }
    }

    private fun xorDecrypt(data: ByteArray, key: ByteArray): ByteArray {
        return ByteArray(data.size) { i ->
            (data[i].toInt() xor key[i % key.size].toInt()).toByte()
        }
    }
}

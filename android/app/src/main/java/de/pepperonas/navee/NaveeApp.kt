package de.pepperonas.navee

import android.app.Application
import de.pepperonas.navee.ble.NaveeAuth

class NaveeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        NaveeAuth.init(this)

        // Seed credentials on first run (extracted from BT capture)
        if (!NaveeAuth.hasCredentials()) {
            NaveeAuth.saveCredentials(
                context = this,
                deviceIdHex = "REDACTED_DEVICE_ID",
                postAuthParamsHex = "REDACTED_POST_AUTH"
            )
        }

        // Seed last known MAC for direct connect
        val blePrefs = getSharedPreferences("navee_ble", MODE_PRIVATE)
        if (blePrefs.getString("last_mac", null) == null) {
            blePrefs.edit().putString("last_mac", "XX:XX:XX:XX:XX:XX").apply()
        }
    }
}

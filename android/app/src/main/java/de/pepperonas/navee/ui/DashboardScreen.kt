package de.pepperonas.navee.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.pepperonas.navee.ble.ConnectionState
import de.pepperonas.navee.ble.ScooterState
import de.pepperonas.navee.ble.ScooterTelemetry
import de.pepperonas.navee.viewmodel.ScooterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(viewModel: ScooterViewModel) {
    val connState by viewModel.connectionState.collectAsState()
    val deviceName by viewModel.deviceName.collectAsState()
    val state by viewModel.state.collectAsState()
    val telemetry by viewModel.telemetry.collectAsState()
    val serial by viewModel.serial.collectAsState()
    val firmware by viewModel.firmware.collectAsState()
    val pid by viewModel.pid.collectAsState()
    val maxSpeedOptions by viewModel.maxSpeedOptions.collectAsState()
    val authenticated by viewModel.authenticated.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Navee ST3 Pro", fontWeight = FontWeight.Bold)
                        if (connState == ConnectionState.CONNECTED && deviceName != null) {
                            Text(
                                deviceName ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                color = NaveeGreen
                            )
                        }
                    }
                },
                actions = {
                    ConnectionButton(connState, viewModel)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = NaveeDark
                )
            )
        },
        containerColor = NaveeDark
    ) { padding ->
        if (connState != ConnectionState.CONNECTED) {
            DisconnectedView(connState, Modifier.padding(padding), viewModel)
        } else {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(Modifier.height(4.dp))
                BatteryAndSpeedCard(telemetry, state)
                ControlsGrid(state, viewModel)
                SpeedModeCard(state, viewModel)
                MaxSpeedCard(state, maxSpeedOptions, viewModel)
                ErsCard(state, viewModel)
                InfoCard(serial, firmware, telemetry, pid, state, authenticated)
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun ConnectionButton(state: ConnectionState, viewModel: ScooterViewModel) {
    when (state) {
        ConnectionState.DISCONNECTED -> {
            IconButton(onClick = { viewModel.connect() }) {
                Icon(Icons.Default.BluetoothSearching, "Verbinden", tint = Color.Gray)
            }
        }
        ConnectionState.SCANNING, ConnectionState.CONNECTING -> {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp).padding(end = 8.dp),
                strokeWidth = 2.dp,
                color = NaveeOrange
            )
        }
        ConnectionState.CONNECTED -> {
            IconButton(onClick = { viewModel.disconnect() }) {
                Icon(Icons.Default.BluetoothConnected, "Verbunden", tint = NaveeGreen)
            }
        }
    }
}

@Composable
private fun DisconnectedView(state: ConnectionState, modifier: Modifier, viewModel: ScooterViewModel) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.ElectricScooter,
            contentDescription = null,
            modifier = Modifier.size(96.dp),
            tint = Color.Gray
        )
        Spacer(Modifier.height(24.dp))
        Text(
            when (state) {
                ConnectionState.SCANNING -> "Suche Navee ST3 Pro..."
                ConnectionState.CONNECTING -> "Verbinde..."
                else -> "Nicht verbunden"
            },
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Gray
        )
        Spacer(Modifier.height(16.dp))
        if (state == ConnectionState.DISCONNECTED) {
            Button(
                onClick = { viewModel.connect() },
                colors = ButtonDefaults.buttonColors(containerColor = NaveeGreen)
            ) {
                Icon(Icons.Default.Bluetooth, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Verbinden", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        } else {
            CircularProgressIndicator(color = NaveeGreen)
        }
    }
}

@Composable
private fun BatteryAndSpeedCard(telemetry: ScooterTelemetry, state: ScooterState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = NaveeCard)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Battery
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val batteryColor = when {
                    telemetry.battery > 50 -> NaveeGreen
                    telemetry.battery > 20 -> NaveeOrange
                    else -> NaveeRed
                }
                Text(
                    "${telemetry.battery}%",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = batteryColor
                )
                Text("Akku", color = Color.Gray, fontSize = 14.sp)
            }

            HorizontalDivider(
                modifier = Modifier.height(60.dp).width(1.dp),
                color = Color.Gray.copy(alpha = 0.3f)
            )

            // Speed
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "${telemetry.speed / 10}.${telemetry.speed % 10}",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text("km/h", color = Color.Gray, fontSize = 14.sp)
            }

            HorizontalDivider(
                modifier = Modifier.height(60.dp).width(1.dp),
                color = Color.Gray.copy(alpha = 0.3f)
            )

            // Temperature
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "${telemetry.temperature}",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (telemetry.temperature > 50) NaveeOrange else NaveeBlue
                )
                Text("\u00B0C", color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}

@Composable
private fun ControlsGrid(state: ScooterState, viewModel: ScooterViewModel) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ToggleCard(
                modifier = Modifier.weight(1f),
                icon = if (state.locked) Icons.Default.Lock else Icons.Default.LockOpen,
                label = if (state.locked) "Gesperrt" else "Entsperrt",
                active = state.locked,
                activeColor = NaveeRed,
                onClick = { viewModel.toggleLock() }
            )
            ToggleCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Lightbulb,
                label = "Frontlicht",
                active = state.headlightOn,
                activeColor = NaveeOrange,
                onClick = { viewModel.toggleHeadlight() }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ToggleCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.TripOrigin,
                label = "R\u00fccklicht",
                active = state.taillightOn,
                activeColor = NaveeRed,
                onClick = { viewModel.toggleTaillight() }
            )
            ToggleCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Speed,
                label = "Tempomat",
                active = state.cruiseOn,
                activeColor = NaveeBlue,
                onClick = { viewModel.toggleCruise() }
            )
        }
    }
}

@Composable
private fun ToggleCard(
    modifier: Modifier,
    icon: ImageVector,
    label: String,
    active: Boolean,
    activeColor: Color,
    onClick: () -> Unit
) {
    val bgColor by animateColorAsState(
        if (active) activeColor.copy(alpha = 0.15f) else NaveeCard,
        animationSpec = tween(300)
    )
    val borderColor by animateColorAsState(
        if (active) activeColor else Color.Transparent,
        animationSpec = tween(300)
    )

    Card(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(1.5.dp, borderColor, RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                icon,
                contentDescription = label,
                modifier = Modifier.size(32.dp),
                tint = if (active) activeColor else Color.Gray
            )
            Spacer(Modifier.height(8.dp))
            Text(
                label,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = if (active) Color.White else Color.Gray
            )
        }
    }
}

@Composable
private fun SpeedModeCard(state: ScooterState, viewModel: ScooterViewModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = NaveeCard)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Fahrmodus", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ModeButton(
                    modifier = Modifier.weight(1f),
                    label = "ECO",
                    selected = state.speedMode == 3,
                    color = NaveeGreen,
                    onClick = { viewModel.setSpeedMode(eco = true) }
                )
                ModeButton(
                    modifier = Modifier.weight(1f),
                    label = "SPORT",
                    selected = state.speedMode == 5,
                    color = NaveeOrange,
                    onClick = { viewModel.setSpeedMode(eco = false) }
                )
            }
        }
    }
}

@Composable
private fun MaxSpeedCard(state: ScooterState, options: List<Int>, viewModel: ScooterViewModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = NaveeCard)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Max Speed", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                if (state.maxSpeed > 0) {
                    Text(
                        "Aktuell: ${state.maxSpeed} km/h",
                        fontSize = 13.sp,
                        color = NaveeOrange,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
            // Speed buttons in rows of 4
            options.chunked(4).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { kmh ->
                        val isActive = state.maxSpeed == kmh
                        val color = when {
                            kmh > 25 -> NaveeOrange
                            else -> NaveeBlue
                        }
                        ModeButton(
                            modifier = Modifier.weight(1f),
                            label = "$kmh",
                            selected = isActive,
                            color = color,
                            onClick = { viewModel.setMaxSpeed(kmh) }
                        )
                    }
                    // Spacers to fill remaining slots
                    repeat(4 - row.size) {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
            Text(
                "km/h — Werte > 20 nur auf Privatgelände",
                fontSize = 11.sp,
                color = Color.Gray.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
private fun ErsCard(state: ScooterState, viewModel: ScooterViewModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = NaveeCard)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Energier\u00fcckgewinnung", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                listOf(1 to "Niedrig", 2 to "Mittel", 3 to "Hoch").forEach { (level, label) ->
                    ModeButton(
                        modifier = Modifier.weight(1f),
                        label = label,
                        selected = state.ersLevel == level,
                        color = NaveeGreen,
                        onClick = { viewModel.setErsLevel(level) }
                    )
                }
            }
        }
    }
}

@Composable
private fun ModeButton(
    modifier: Modifier,
    label: String,
    selected: Boolean,
    color: Color,
    onClick: () -> Unit
) {
    val bgColor by animateColorAsState(
        if (selected) color else Color.Transparent,
        animationSpec = tween(300)
    )

    Box(
        modifier = modifier
            .height(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .border(
                1.dp,
                if (selected) Color.Transparent else Color.Gray.copy(alpha = 0.3f),
                RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            fontSize = 14.sp,
            color = if (selected) Color.Black else Color.Gray
        )
    }
}

@Composable
private fun InfoCard(serial: String, firmware: String, telemetry: ScooterTelemetry, pid: Int?, state: ScooterState, authenticated: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = NaveeCard)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Info", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(Modifier.height(12.dp))
            InfoRow("Auth", if (authenticated) "OK" else "Nicht authentifiziert")
            if (pid != null) {
                InfoRow("PID", "$pid")
            }
            if (serial.isNotEmpty()) {
                InfoRow("Seriennummer", serial)
            }
            if (firmware.isNotEmpty()) {
                InfoRow("Firmware", firmware)
            }
            if (state.maxSpeed > 0) {
                InfoRow("Max Speed (FW)", "${state.maxSpeed} km/h")
            }
            if (state.speedLimitEnabled) {
                InfoRow("Speed Limit", "${state.speedLimitKmh} km/h")
            }
            if (telemetry.totalDistance > 0) {
                InfoRow("Gesamtstrecke", String.format("%.1f km", telemetry.totalDistance / 10.0))
            }
            InfoRow("Modus", if (state.speedMode == 5) "SPORT" else "ECO")
            InfoRow("ERS Level", "${state.ersLevel}")
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.Gray, fontSize = 14.sp)
        Text(value, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

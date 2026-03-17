package de.pepperonas.navee.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val NaveeGreen = Color(0xFF00C853)
val NaveeDark = Color(0xFF121212)
val NaveeSurface = Color(0xFF1E1E1E)
val NaveeCard = Color(0xFF2A2A2A)
val NaveeOrange = Color(0xFFFF6D00)
val NaveeRed = Color(0xFFFF1744)
val NaveeBlue = Color(0xFF448AFF)

private val DarkColorScheme = darkColorScheme(
    primary = NaveeGreen,
    secondary = NaveeBlue,
    tertiary = NaveeOrange,
    background = NaveeDark,
    surface = NaveeSurface,
    surfaceVariant = NaveeCard,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = NaveeRed,
)

@Composable
fun NaveeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography(),
        content = content
    )
}

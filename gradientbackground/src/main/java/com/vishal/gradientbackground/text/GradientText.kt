package com.vishal.gradientbackground.text


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlin.math.sin

enum class GradientPreset(val colors: List<Color>) {
    BlueGreen(listOf(Color(0xFF40FFAA), Color(0xFF4079FF))),
    PurplePink(listOf(Color(0xFFFF40AA), Color(0xFFAA40FF))),
    Sunset(listOf(Color(0xFFFF9966), Color(0xFFFF5E62))),
    Ocean(listOf(Color(0xFF0077B6), Color(0xFF00B4D8))),
    NightSky(listOf(Color(0xFF0B2447), Color(0xFF19376D))),
    Mint(listOf(Color(0xFFB2F7EF), Color(0xFF89C2D9))),
    Ice(listOf(Color(0xFFE0FFFF), Color(0xFFADD8E6))),
    DeepSea(listOf(Color(0xFF001C30), Color(0xFF176B87))),
    Forest(listOf(Color(0xFF228B22), Color(0xFF3CB371))),
    Desert(listOf(Color(0xFFD2B48C), Color(0xFFDEB887))),
    Stone(listOf(Color(0xFF808080), Color(0xFFD3D3D3))),
    Moss(listOf(Color(0xFF6B8E23), Color(0xFF9ACD32))),
    Clay(listOf(Color(0xFFB22222), Color(0xFFCD5C5C))),
    Rainbow(listOf(Color(0xFF9400D3), Color(0xFF4B0082), Color(0xFF0000FF), Color(0xFF00FF00), Color(0xFFFFFF00), Color(0xFFFF7F00), Color(0xFFFF0000))),
    Neon(listOf(Color(0xFF00FF00), Color(0xFFFFFF00))),
    Tropical(listOf(Color(0xFF00FFFF), Color(0xFF00FF7F))),
    Candy(listOf(Color(0xFFFF69B4), Color(0xFFEE82EE))),
    Electric(listOf(Color(0xFF0000FF), Color(0xFF00FFFF))),
    BabyBlue(listOf(Color(0xFF89CFF0), Color(0xFFB0E0E6))),
    Lavender(listOf(Color(0xFFE6E6FA), Color(0xFFDDA0DD))),
    Rose(listOf(Color(0xFFFFC0CB), Color(0xFFF08080))),
    MintGreen(listOf(Color(0xFF98FB98), Color(0xFF90EE90))),
    Lemon(listOf(Color(0xFFFFFACD), Color(0xFFFFFFE0)))

}

@Composable
fun GradientText(
    text: String,
    gradientPreset: GradientPreset = GradientPreset.BlueGreen, // Default gradient
    animationSpeed: Int = 5,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Gradient Animation")

    val animationProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationSpeed * 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Color Shift"
    )

    val animatedGradient = Brush.linearGradient(
        gradientPreset.colors.mapIndexed { index, color ->
            val shift = sin((animationProgress + index * 0.3) * Math.PI).toFloat()
            color.copy(alpha = shift.coerceIn(0.4f, 1f))
        }
    )

    Text(
        text = text,
        style = TextStyle(
            brush = animatedGradient,  // ✅ Gradient applies only to text
            fontSize = 24.sp
        ),
        modifier = modifier
    )
}
package com.vishal.gradientbackground.loader

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun LoadingScreen(
    speed: Int = 1000,       // User can set animation speed (default: 1000ms)
    circleColor: Color = Color.Gray  // User can set color (default: Gray)
) {
    val delays = listOf(0, 300, 600, 900) // Delays for staggered effect

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        delays.forEach { delayMs ->
            AnimatedCircle(delayMillis = delayMs, speed = speed, circleColor = circleColor)
        }
    }
}

@Composable
fun AnimatedCircle(
    delayMillis: Int,
    speed: Int,
    circleColor: Color
) {
    val transition = rememberInfiniteTransition() // Correct usage in 1.6.1

    val scale = transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(speed, easing = FastOutSlowInEasing, delayMillis = delayMillis),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale_animation"
    )

    val alpha = transition.animateFloat(
        initialValue = 1f,
        targetValue = 0.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(speed, easing = LinearEasing, delayMillis = delayMillis),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha_animation"
    )

    Box(
        modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(circleColor.copy(alpha = alpha.value)) // Fix transparency issue
            .graphicsLayer(scaleX = scale.value, scaleY = scale.value) // Apply scaling
    )
}
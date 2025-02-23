package com.vishal.gradientbackground.loader

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VerticalLineLoadingScreen(
    barColor: Color = Color.White.copy(alpha = 0.5f), // Default color with transparency
    animationSpeed: Int = 1000 // Animation speed in milliseconds
) {
    val transition = rememberInfiniteTransition()

    val scale1 = transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationSpeed, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale1"
    )

    val scale2 = transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationSpeed, easing = LinearEasing, delayMillis = 250),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale2"
    )

    val scale3 = transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationSpeed, easing = LinearEasing, delayMillis = 500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale3"
    )

    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Bar(scale1.value, barColor, 20.dp)
        Bar(scale2.value, barColor, 35.dp) // Middle bar is taller
        Bar(scale3.value, barColor, 20.dp)
    }
}

@Composable
fun Bar(scale: Float, color: Color, height: androidx.compose.ui.unit.Dp) {
    Box(
        modifier = Modifier
            .width(3.dp)
            .height(height)
            .scale(1f, scale) // Apply vertical scaling animation
            .background(color, shape = RoundedCornerShape(10.dp))
    )
}
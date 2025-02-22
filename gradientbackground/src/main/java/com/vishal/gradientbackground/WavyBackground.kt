package com.vishal.gradientbackground

import androidx.compose.ui.graphics.asAndroidPath


import android.graphics.Paint
import android.graphics.PathEffect
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WavyBackground(
    modifier: Modifier = Modifier,
    waveColor: Color = Color(0xFF2196F3), // Blue color
    waveHeight: Float = 100f, // Adjust the wave height
    speed: Int = 5000 // Speed of animation in milliseconds
) {
    // Animation to shift the waves
    val infiniteTransition = rememberInfiniteTransition(label = "WaveAnimation")
    val waveOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f, // Move the wave horizontally
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = speed, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "WaveOffset"
    )

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, height / 2)

            val waveLength = width / 1.5f
            val amplitude = waveHeight

            for (i in 0 until 2) { // Two wave cycles
                val startX = i * waveLength
                quadraticBezierTo(
                    startX + waveLength / 4, height / 2 - amplitude,
                    startX + waveLength / 2, height / 2
                )
                quadraticBezierTo(
                    startX + 3 * waveLength / 4, height / 2 + amplitude,
                    startX + waveLength, height / 2
                )
            }

            lineTo(width, height)
            lineTo(0f, height)
            close()
        }

        drawPath(
            path = path,
            color = waveColor.copy(alpha = 0.5f) // Semi-transparent for better effect
        )

        // Optional: Add stroke effect
        drawContext.canvas.nativeCanvas.apply {
            val paint = Paint().apply {
                color = android.graphics.Color.WHITE
                strokeWidth = 5f
                style = Paint.Style.STROKE
            }
            drawPath(path.asAndroidPath(), paint)
        }
    }
}
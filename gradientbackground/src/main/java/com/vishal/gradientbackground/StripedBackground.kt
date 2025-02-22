package com.vishal.gradientbackground

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun StripedBackground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val stripeColor = Color(0xFFF0F0F0) // Light gray stripes
        val stripeWidth = 2.dp.toPx() // Thickness of stripes
        val spacingX = 96.dp.toPx() // Horizontal spacing (6rem ≈ 96dp)
        val spacingY = 64.dp.toPx() // Vertical spacing (4rem ≈ 64dp)

        // Draw vertical stripes
        for (x in 0 until size.width.toInt() step spacingX.toInt()) {
            drawLine(
                color = stripeColor,
                start = Offset(x.toFloat(), 0f),
                end = Offset(x.toFloat(), size.height),
                strokeWidth = stripeWidth
            )
        }

        // Draw horizontal stripes
        for (y in 0 until size.height.toInt() step spacingY.toInt()) {
            drawLine(
                color = stripeColor,
                start = Offset(0f, y.toFloat()),
                end = Offset(size.width, y.toFloat()),
                strokeWidth = stripeWidth
            )
        }
    }
}


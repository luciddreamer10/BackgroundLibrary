package com.vishal.gradientbackground

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DottedBackground(
    dotColor: Color = Color.Blue,
    backgroundColor: Color = Color.White,
    dotSize: Dp = 5.dp,
    dotSpacing: Dp = 15.dp,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Canvas(modifier = modifier.background(backgroundColor)) {
        val dotPx = dotSize.toPx()
        val spacingPx = dotSpacing.toPx()
        val rows = (size.height / (dotPx + spacingPx)).toInt()
        val cols = (size.width / (dotPx + spacingPx)).toInt()

        for (i in 0..cols) {
            for (j in 0..rows) {
                drawCircle(
                    color = dotColor,
                    radius = dotPx / 2,
                    center = Offset(i * (dotPx + spacingPx), j * (dotPx + spacingPx))
                )
            }
        }
    }
}

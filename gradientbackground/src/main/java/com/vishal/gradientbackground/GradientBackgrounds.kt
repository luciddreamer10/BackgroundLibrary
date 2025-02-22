package com.vishal.gradientbackground

// Gradients.kt

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object BackgroundGradients {
    val BlueToGreen = Brush.linearGradient(
        colors = listOf(Color(0xFF2196F3), Color(0xFF4CAF50))
    )
    val SunsetOrange = Brush.linearGradient(
        colors = listOf(Color(0xFFFF9800), Color(0xFFFF5722))
    )
    val PurpleToPink = Brush.linearGradient(
        colors = listOf(Color(0xFF9C27B0), Color(0xFFE91E63))
    )
    val CottonCandy = Brush.linearGradient(
        colors = listOf(Color(0xFFF8BBD0), Color(0xFFBBDEFB))
    )
    val RainbowSherbet = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFFCDD2), // Light Red
            Color(0xFFFFF9C4), // Light Yellow
            Color(0xFFCCFF90), // Light Green
            Color(0xFFB2EBF2), // Light Blue
            Color(0xFFE1BEE7)  // Light Purple
        )
    )
    val SmokeyQuartz = Brush.linearGradient(
        colors = listOf(Color(0xFF424242), Color(0xFF795548))
    )
    val GoldenHour = Brush.linearGradient(
        colors = listOf(Color(0xFFFFD600), Color(0xFFFF9800))
    )
    val MidnightBloom = Brush.linearGradient(
        colors = listOf(Color(0xFF1A237E), Color(0xFF4A148C))
    )
}
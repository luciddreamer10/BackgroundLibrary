package com.vishal.backgroundlibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vishal.gradientbackground.BackgroundGradients
import com.vishal.gradientbackground.GradientButton
import com.vishal.gradientbackground.NeonGlowButton

@Composable
fun ButtonDemoScreen() {
    Box(modifier = Modifier.background(BackgroundGradients.GoldenHour).fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GradientButton("Sample1") { }
            NeonGlowButton("Sample2") { }
        }

    }
}
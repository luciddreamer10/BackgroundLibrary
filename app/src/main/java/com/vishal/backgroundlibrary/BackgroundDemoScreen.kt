package com.vishal.backgroundlibrary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vishal.gradientbackground.background.WavyBackground

@Composable
fun BackgroundDemoScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

            WavyBackground()
    }
}

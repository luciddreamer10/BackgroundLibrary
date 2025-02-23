package com.vishal.backgroundlibrary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vishal.gradientbackground.text.AnimatedText
import com.vishal.gradientbackground.text.GradientPreset
import com.vishal.gradientbackground.text.GradientText
import com.vishal.gradientbackground.text.PopOnHoverText

@Composable
fun TextDemoScreen() {
    Box(modifier = Modifier
        .fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, // Center the text horizontally
            verticalArrangement = Arrangement.Center
        ) {
            GradientText("BottomBar() ", GradientPreset.DeepSea, animationSpeed = 1)
            PopOnHoverText("PopOnHoverText() ")
            AnimatedText("AnimatedText() ")
        }

    }
}
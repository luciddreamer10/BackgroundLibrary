package com.vishal.backgroundlibrary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vishal.gradientbackground.slider.ElasticSlider

@Composable
fun SliderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElasticSlider(
            defaultValue = 50f,
            startingValue = 0f,
            maxValue = 100f,
            isStepped = true,
            stepSize = 10f
        )
    }
}
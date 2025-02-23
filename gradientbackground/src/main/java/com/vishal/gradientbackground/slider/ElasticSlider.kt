package com.vishal.gradientbackground.slider

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishal.gradientbackground.R
import kotlinx.coroutines.launch

@Composable
fun ElasticSlider(
    defaultValue: Float = 50f,
    startingValue: Float = 0f,
    maxValue: Float = 100f,
    isStepped: Boolean = false,
    stepSize: Float = 1f,
    leftIcon: @Composable () -> Unit = { Icon(Icons.Filled.Home, contentDescription = "Volume Down") },
    rightIcon: @Composable () -> Unit = { Icon(Icons.Filled.Home, contentDescription = "Volume Up") },
) {
    var value by remember { mutableStateOf(defaultValue) }
    val sliderWidth = remember { Animatable(0f) }
    val sliderScale = remember { Animatable(1f) }
    val iconScale = remember { Animatable(1f) }
    val coroutineScope = rememberCoroutineScope()

    // Calculate the percentage of the slider's range
    val rangePercentage = ((value - startingValue) / (maxValue - startingValue)).coerceIn(0f, 1f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left Icon
            Box(
                modifier = Modifier
                    .scale(iconScale.value)
                    .pointerInput(Unit) {
                        detectDragGestures { change, _ ->
                            coroutineScope.launch {
                                iconScale.animateTo(1.4f, tween(100))
                                iconScale.animateTo(1f, tween(100))
                            }
                        }
                    }
            ) {
                leftIcon()
            }

            // Slider Track
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 24.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            val newValue = value + (dragAmount.x / size.width) * (maxValue - startingValue)
                            value = newValue.coerceIn(startingValue, maxValue)

                            // Elastic effect when dragging beyond bounds
                            if (value <= startingValue || value >= maxValue) {
                                coroutineScope.launch {
                                    sliderWidth.animateTo(
                                        targetValue = 1.2f,
                                        animationSpec = spring(stiffness = Spring.StiffnessLow)
                                    )
                                    sliderWidth.animateTo(1f)
                                }
                            }
                        }
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .background(Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(rangePercentage)
                            .height(6.dp)
                            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(4.dp))
                    )
                }
            }

            // Right Icon
            Box(
                modifier = Modifier
                    .scale(iconScale.value)
                    .pointerInput(Unit) {
                        detectDragGestures { change, _ ->
                            coroutineScope.launch {
                                iconScale.animateTo(1.4f, tween(100))
                                iconScale.animateTo(1f, tween(100))
                            }
                        }
                    }
            ) {
                rightIcon()
            }
        }

        // Value Indicator
        Text(
            text = value.toInt().toString(),
            modifier = Modifier.align(Alignment.TopCenter),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
package com.vishal.gradientbackground.text

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text // Use Text instead of BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun AnimatedText(
    text: String,
    modifier: Modifier = Modifier,
    delayMillis: Int = 100,
    animationFrom: Pair<Float, Float> = Pair(0f, 40f),
    animationTo: Pair<Float, Float> = Pair(1f, 0f),
    easing: Easing = CubicBezierEasing(0.25f, 1f, 0.5f, 1f),
    onLetterAnimationComplete: (() -> Unit)? = null
) {
    val words = text.split(" ").map { it.toList() }
    val letters = words.flatten()
    var inView by remember { mutableStateOf(false) }
    var animatedCount by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        delay(400) // Simulating IntersectionObserver trigger
        inView = true
    }

    Row(
        modifier = modifier.onGloballyPositioned {
            // Normally, you would check visibility here
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        words.forEachIndexed { wordIndex, word ->
            Row(modifier = Modifier.padding(end = 4.dp)) {
                word.forEachIndexed { letterIndex, letter ->
                    val index = words.take(wordIndex).sumOf { it.size } + letterIndex
                    val alphaAnim = remember { Animatable(animationFrom.first) }
                    val offsetYAnim = remember { Animatable(animationFrom.second) }

                    LaunchedEffect(inView) {
                        if (inView) {
                            delay(index * delayMillis.toLong())
                            alphaAnim.animateTo(
                                targetValue = animationTo.first,
                                animationSpec = tween(600, easing = easing)
                            )
                            offsetYAnim.animateTo(
                                targetValue = animationTo.second,
                                animationSpec = tween(600, easing = easing)
                            )
                            animatedCount++
                            if (animatedCount == letters.size) {
                                onLetterAnimationComplete?.invoke()
                            }
                        }
                    }

                    Text( // Replaced BasicText with Text
                        text = letter.toString(),
                        modifier = Modifier
                            .alpha(alphaAnim.value)
                            .offset(y = offsetYAnim.value.dp),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
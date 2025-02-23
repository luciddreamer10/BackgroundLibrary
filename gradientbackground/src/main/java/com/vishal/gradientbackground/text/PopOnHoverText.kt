package com.vishal.gradientbackground.text

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PopOnHoverText(
    text: String,
    modifier: Modifier = Modifier
) {
    var isHovered by remember { mutableStateOf(false) }
    val textSize by animateDpAsState(if (isHovered) 28.dp else 20.dp, label = "Text Size Animation")

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        isHovered = event.changes.any { it.pressed } // Detect hover by movement
                    }
                }
            }
            .padding(4.dp)
    ) {
        Text(
            text = text,
            fontSize = textSize.value.sp
        )
    }
}
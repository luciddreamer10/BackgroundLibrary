package com.vishal.backgroundlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vishal.backgroundlibrary.ui.theme.BackgroundLibraryTheme
import com.vishal.gradientbackground.GradientBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BackgroundLibraryTheme {
                GradientBackground()
            }
        }
    }
}

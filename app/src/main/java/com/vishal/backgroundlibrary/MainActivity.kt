package com.vishal.backgroundlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vishal.gradientbackground.bottombar.FloatingBottomBar
import com.vishal.gradientbackground.loader.LoadingScreen
import com.vishal.gradientbackground.loader.VerticalLineLoadingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = { FloatingBottomBar() }
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize() // Make the Column fill the available space
                                .padding(innerPadding),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                                // Set the background color here
                        ) {
//                            TextDemoScreen()
                            VerticalLineLoadingScreen(Color.Black,250)
                        }
                    }
                }
            }
        }
    }
}
package com.vishal.gradientbackground.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vishal.gradientbackground.R

@Composable
fun ClassicBottomBar() {
    var selectedIndex by remember { mutableStateOf(0) }
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.Search,
        Icons.Filled.Notifications,
        Icons.Filled.Person
    )

    NavigationBar(containerColor = Color.Black) {
        icons.forEachIndexed { index, icon ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Navigation Icon",
                    )
                },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
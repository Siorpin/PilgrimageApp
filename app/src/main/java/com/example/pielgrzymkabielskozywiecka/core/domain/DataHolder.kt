package com.example.pielgrzymkabielskozywiecka.core.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.core.presentation.BottomBarUI

object DataHolder {
    val bottomBarButtons = listOf(
        BottomBarUI(
            name = "Dom",
            screen = Screen.HOME,
            icon = Icons.Default.Home,
            isOnFocus = true
        ),
        BottomBarUI(
            name = "Zakładki",
            screen = Screen.AUTORZY,
            icon = Icons.Default.Star,
        ),
        BottomBarUI(
            name = "Duchowi",
            screen = Screen.AUTORZY,
            icon = Icons.Default.AccountCircle,
        )
    )
}
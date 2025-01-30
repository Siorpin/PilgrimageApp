package com.example.pielgrzymkabielskozywiecka.core.presentation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen

data class BottomBarUI(
    val name: String,
    val icon: ImageVector,
    val screen: Screen,
    val onFocusColor: androidx.compose.ui.graphics.Color,
    val isOnFocus: Boolean = false
)



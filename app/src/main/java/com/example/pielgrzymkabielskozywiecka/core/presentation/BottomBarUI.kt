package com.example.pielgrzymkabielskozywiecka.core.presentation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen

data class BottomBarUI(
    val name: String,
    val icon: ImageVector,
    val screen: Screen,
    val isOnFocus: Boolean = false
)



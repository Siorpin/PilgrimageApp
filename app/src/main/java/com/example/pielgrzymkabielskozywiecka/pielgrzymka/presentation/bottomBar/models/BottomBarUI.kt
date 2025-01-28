package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.models

import android.graphics.drawable.Icon
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.Root

data class BottomBarUI(
    val name: String,
    val icon: ImageVector,
    val onFocusShape: Shape,
    val onClick: () -> Unit
)

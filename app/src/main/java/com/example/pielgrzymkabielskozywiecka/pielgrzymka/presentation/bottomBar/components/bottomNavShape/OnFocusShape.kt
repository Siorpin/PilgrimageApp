package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.bottomNavShape

import androidx.annotation.Px
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class OnFocusShape(private val patchHeight: Float): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawOnFocusShape(size, patchHeight)
        )
    }
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.bottomNavShape

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.geometry.Size

fun drawOnFocusShape(size: Size, height: Float): Path {
    return Path().apply {
        reset()
        arcTo(
            rect = Rect(
                offset = Offset(0f,0f),
                size = size
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 360f,
            forceMoveTo = true
        )
    }
}
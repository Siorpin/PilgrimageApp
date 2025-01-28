package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.bottomNavShape

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size

fun drawOnFocusShape(size: Size, height: Float): Path {
    return Path().apply {
        reset()

        moveTo(100f, 200f) // Początkowy punkt
        cubicTo(50f, 50f, 250f, 50f, 200f, 200f) // Tworzenie górnej części
        cubicTo(250f, 400f, 50f, 400f, 100f, 200f) // Tworzenie dolnej części
        close()
    }
}
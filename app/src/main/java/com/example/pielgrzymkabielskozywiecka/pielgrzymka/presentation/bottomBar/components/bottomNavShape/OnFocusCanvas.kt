package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.bottomNavShape

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun OnFocusCanvas(
    size: Size,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            //.padding(5.dp)
    ) {
        val path = Path().apply {
            moveTo(0f, size.height.toFloat())
            cubicTo(
                x1 = 10f,
                y1 = 0f,
                x2 = size.width - 10f,
                y2 = 0f,
                x3 = size.width,
                y3 = size.height
            )
            close()
        }

        drawPath(
            path = path,
            color = Color.Red
        )
    }
}
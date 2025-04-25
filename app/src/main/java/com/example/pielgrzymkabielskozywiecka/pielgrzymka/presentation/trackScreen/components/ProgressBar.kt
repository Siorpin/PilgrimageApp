package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun ProgressBar(
    percentage: Int,
    color: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    val animateFloat = remember { Animatable(0f) }

    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = (1f * 0.01 * percentage).toFloat(),
            animationSpec = tween(durationMillis = 500, easing = EaseOut)
        )
    }

    Box(
        modifier = modifier
            .height(30.dp)
            .fillMaxWidth()
            .border(
                color = color,
                width = 1.dp,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(animateFloat.value)
                .background(
                    color = color,
                    shape = RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = "${percentage}%",
            fontSize = 20.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center),
            color = textColor
        )
    }
}
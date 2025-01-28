package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.models.BottomBarUI

@Composable
fun BottomNavButton(
    bottomBarUI: BottomBarUI,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable { bottomBarUI.onClick() }
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = bottomBarUI.onFocusShape
                clip = true
            }
            .background(
                color = MaterialTheme.colorScheme.onPrimary
            )
            .fillMaxSize()
    ) {
        Icon(
            imageVector = bottomBarUI.icon,
            contentDescription = null,
            tint = Color.Red
        )
    }
}
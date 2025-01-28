package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.BottomNavButton
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.bottomNavShape.OnFocusShape
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.models.BottomBarUI

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(
            topEnd = 16.dp,
            topStart = 16.dp
        ),
        modifier = modifier
            .height(80.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            BottomNavButton(
                BottomBarUI("", Icons.Default.Done, OnFocusShape(27f), {}),
                modifier = Modifier.weight(1f)
            )
            BottomNavButton(
                BottomBarUI("", Icons.Default.Done, RectangleShape, {}),
                modifier = Modifier.weight(1f)
            )
            BottomNavButton(
                BottomBarUI("", Icons.Default.Done, CircleShape, {}),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
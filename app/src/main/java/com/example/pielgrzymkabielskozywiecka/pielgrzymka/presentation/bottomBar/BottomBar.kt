package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 15.dp,
                    horizontal = 30.dp
                )
        ) {
            var x by remember { mutableStateOf(false) }
            BottomNavButton(
                BottomBarUI("Home",
                    Icons.Default.Home,
                    isOnFocus = x
                ) {
                    x = !x
                }
                //modifier = Modifier.weight(1f)
            )
            BottomNavButton(
                BottomBarUI("", Icons.Default.Done,false, {})
                //modifier = Modifier.weight(1f)
            )
            BottomNavButton(
                BottomBarUI("", Icons.Default.Done,false, {})
                //modifier = Modifier.weight(1f)
            )
        }
    }
}
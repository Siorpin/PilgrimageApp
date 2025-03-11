package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = CircleShape,
        modifier = modifier
            .padding(
                horizontal = 20.dp,
                vertical = 5.dp
            )
            .size(40.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Powiadomienia",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(7.dp)
        )
    }
}
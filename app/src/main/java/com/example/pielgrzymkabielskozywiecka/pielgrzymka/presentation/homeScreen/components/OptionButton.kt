package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.Root

@Composable
fun OptionButton(
    root: Root,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var enabled by remember { mutableStateOf(true) }

    Card(
        modifier = modifier
            .clickable(enabled = enabled) {
                enabled = false
                onClick(root.destination.name)
            }
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(170.dp)
            .aspectRatio(1f),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(root.name)
        }
    }
}
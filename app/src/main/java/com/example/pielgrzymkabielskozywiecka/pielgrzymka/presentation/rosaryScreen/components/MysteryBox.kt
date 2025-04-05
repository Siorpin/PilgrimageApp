package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.RosaryMysteryUI

@Composable
fun MysteryBox(
    mysteryUI: RosaryMysteryUI,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            2.dp
        ),
        modifier = modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Text(mysteryUI.title)
    }
}
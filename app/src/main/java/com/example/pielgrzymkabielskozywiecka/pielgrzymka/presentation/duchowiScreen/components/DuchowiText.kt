package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun DuchowiText(
    text: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontFamily = Poppins,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
        )
    }
}
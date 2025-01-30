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
fun AnnouncementsBox(
    modifier: Modifier = Modifier
) {
    Text("Ogłoszenia")
    Card(
        modifier = modifier
    ) {
        Text(
            text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi varius nunc est, sed gravida sem rutrum et. Etiam pharetra, eros vitae sagittis varius, urna tellus sagittis nunc, eget fermentum urna neque vitae elit. Aliquam ut arcu non nisl luctus tempus. Pellentesque id facilisis nisi. In vel lacus vitae erat sollicitudin rhoncus. Aenean ac venenatis ligula. Vestibulum maximus turpis sit amet eleifend euismod."

        )
    }
}
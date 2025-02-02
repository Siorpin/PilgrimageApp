package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun AnnouncementsBox(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        HeaderText("Ogłoszenia")
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF83B9F8),
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = modifier
                .padding(6.dp)
        ) {
            Text(
                text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi varius nunc est, sed gravida sem rutrum et. Etiam pharetra, eros vitae sagittis varius, urna tellus sagittis nunc, eget fermentum urna neque vitae elit. Aliquam ut arcu non nisl luctus tempus. Pellentesque id facilisis nisi. In vel lacus vitae erat sollicitudin rhoncus. Aenean ac venenatis ligula. Vestibulum maximus turpis sit amet eleifend euismod.",
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
            )
        }
    }
}
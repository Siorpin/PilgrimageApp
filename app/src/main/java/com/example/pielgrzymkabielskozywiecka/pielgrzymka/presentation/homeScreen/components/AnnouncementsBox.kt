package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins
import androidx.compose.ui.unit.sp

@Composable
fun AnnouncementsBox(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Ogłoszenia",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            modifier = modifier
                .fillMaxWidth()
                .padding(6.dp)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFA5CDFD),

            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            modifier = modifier
                .padding(6.dp)
//                .shadow(
//                    elevation = 40.dp,
//                    shape = RoundedCornerShape()
//                )
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
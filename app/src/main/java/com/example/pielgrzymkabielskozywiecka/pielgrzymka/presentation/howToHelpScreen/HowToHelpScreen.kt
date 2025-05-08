package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.howToHelpScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryVerticalScreen
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun HowToHelpScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    SecondaryVerticalScreen(
        name = "Pomoc pielgrzymom",
        navController = navController,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = "Pielgrzymi codziennie przechodzą około 30 kilometrów. Mierzą się oni między innymi z takimi trudnościami jak zmęczenie, głód, pragnienie, odciski na stopach i wiele więcej.",
                    fontFamily = Poppins,
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Jak im pomóc?",
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Najprostrzym sposobem żeby ich wesprzeć jest modlitwa w ich intencjach. Możesz też w zakładce \"Trasa\" sprawdzić gdzie się aktualnie znajduje pielgrzymka i przygotować dla pielgrzymów butelkę wody, coś do jedzenia, jakieś plastry, czy cokolwiek ci tylko przyjdzie do głowy, każdy gest \"ratuje życie\".\n" +
                        "        Na koniec dnia jeśli akurat zatrzymujemy się w twojej miejscowości możesz przyjąć pielgrzymów na nocleg, gwarantujemy że będą przeszczęśliwi",
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                lineHeight = 22.sp
            )
        }
    }
}
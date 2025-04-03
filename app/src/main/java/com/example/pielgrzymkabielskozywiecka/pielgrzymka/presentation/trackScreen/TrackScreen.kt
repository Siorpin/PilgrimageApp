package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryVerticalScreen

@Composable
fun TrackScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    SecondaryVerticalScreen(
        name = "Trasa",
        navController = navController,
        modifier = modifier
    )
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.howToHelpScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryVerticalScreen

@Composable
fun HowToHelpScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    SecondaryVerticalScreen(
        name = "Jak pomóc",
        navController = navController,
        modifier = modifier
    ) {

    }
}
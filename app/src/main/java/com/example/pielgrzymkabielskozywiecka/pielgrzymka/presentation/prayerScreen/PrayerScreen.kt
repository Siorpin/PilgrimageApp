package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.prayerScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar

@Composable
fun PrayerScreen(
    title: String?,
    lyrics: String?,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (title != null) {
            SecondaryScreenTopBar(
                name = title,
                navController = navController
            )
        }
    }
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryVerticalScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen.TrackScreenViewModel

@Composable
fun TrackScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel = TrackScreenViewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()

    SecondaryVerticalScreen(
        name = "Trasa",
        navController = navController,
        modifier = modifier
    ) {
        if (state.value.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    state.value.percentage.toString()
                )
            }
        }
    }
}
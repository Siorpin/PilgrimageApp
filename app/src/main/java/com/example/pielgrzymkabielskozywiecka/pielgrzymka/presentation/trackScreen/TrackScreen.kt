package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryVerticalScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen.components.ErrorScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen.components.PositiveScreen

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
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (state.value.errorMessage != null) {
                    ErrorScreen(
                        errorMessage = state.value.errorMessage!!,
                        onButtonClick = { viewModel.refreshData() }
                    )
                } else {
                    PositiveScreen(state.value.trackUI)
                }
            }
        }
    }
}
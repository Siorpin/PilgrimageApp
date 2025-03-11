package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen.components.ModlitewnikListItem
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SearchBar
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar

@Composable
fun ModlitewnikScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: ModlitewnikScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = state.contentBottomPadding)
    ) {
        SecondaryScreenTopBar(
            name = "Modlitewnik",
            navController = navController
        )
        SearchBar(
            value = state.searchedText,
            onValueChange = { text ->
                viewModel.updateText(text)
                viewModel.search(text)
            }
        )

        if (state.isLoading) {
            CircularProgressIndicator()
        }
        else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                items(state.visiblePrayers) { prayer ->
                    ModlitewnikListItem(
                        modlitwa = prayer,
                        onClick = {}
                    )
                }
            }
        }
    }
}
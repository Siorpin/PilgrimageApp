package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SearchBar
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen.components.SongbookListItem

@Composable
fun SongbookScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: SongbookScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        SecondaryScreenTopBar(
            name = "Śpiewnik",
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
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
        else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                items(state.visibleSongs) { song ->
                    SongbookListItem(
                        song = song,
                        onClick = { navController.navigate(Screen.SONG.name + "/${song.title}/${song.lyrics}") }
                    )
                }
            }
        }
    }
}
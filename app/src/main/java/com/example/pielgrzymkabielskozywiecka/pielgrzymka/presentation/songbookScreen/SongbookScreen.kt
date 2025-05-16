package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.HeaderText
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
                val keysList = state.visibleSongs.keys.toMutableList()
                keysList.sort()
                items(keysList.size) { id ->
                    val key = keysList[id]
                    when(key) {
                        1 -> TitleColumn(
                            text = "Część modlitewna",
                            song = key to state.songs.getOrDefault(key, SongUI("","")),
                            onClick = { navController.navigate(Screen.SONG.name + "/${key}") }
                        )
                        21 -> TitleColumn(
                            text = "Pieśni maryjne",
                            song = key to state.songs.getOrDefault(key, SongUI("","")),
                            onClick = { navController.navigate(Screen.SONG.name + "/${key}") }
                        )
                        101 -> TitleColumn(
                            text = "Pieśni liturgii",
                            song = key to state.songs.getOrDefault(key, SongUI("","")),
                            onClick = { navController.navigate(Screen.SONG.name + "/${key}") }
                        )
                        301 -> TitleColumn(
                            text = "Pieśni integracji",
                            song = key to state.songs.getOrDefault(key, SongUI("","")),
                            onClick = { navController.navigate(Screen.SONG.name + "/${key}") }
                        )
                        else -> SongbookListItem(
                            song = key to state.songs.getOrDefault(key, SongUI("","")),
                            onClick = { navController.navigate(Screen.SONG.name + "/${key}") }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TitleColumn(
    text: String,
    song:  Pair<Int, SongUI>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
   Column(
       modifier = modifier
           .fillMaxWidth()
   ) {
       Spacer(modifier = Modifier.height(10.dp))
       HeaderText(text)
       Spacer(modifier = Modifier.height(10.dp))
       SongbookListItem(
           song, onClick
       )
   }
}
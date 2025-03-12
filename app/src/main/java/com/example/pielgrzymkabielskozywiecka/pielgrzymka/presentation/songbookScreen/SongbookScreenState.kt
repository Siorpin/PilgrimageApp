package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.ModlitwyResponse
import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.SongsResponse

data class SongbookScreenState(
    val isLoading: Boolean = true,
    val contentBottomPadding: Dp = 0.dp,
    val searchedText: String = "",
    val songs: List<SongsResponse> = emptyList(),
    val visibleSongs: List<SongsResponse> = emptyList()
)

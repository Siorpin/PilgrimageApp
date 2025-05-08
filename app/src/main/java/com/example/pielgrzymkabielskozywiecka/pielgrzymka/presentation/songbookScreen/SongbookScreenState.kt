package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen

import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI

data class SongbookScreenState(
    val isLoading: Boolean = true,
    val searchedText: String = "",
    val songs: List<SongUI> = emptyList(),
    val visibleSongs: List<SongUI> = emptyList()
)

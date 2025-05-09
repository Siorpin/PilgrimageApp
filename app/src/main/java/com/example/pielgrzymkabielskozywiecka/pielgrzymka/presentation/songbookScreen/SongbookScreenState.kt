package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen

import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI

data class SongbookScreenState(
    val isLoading: Boolean = true,
    val searchedText: String = "",
    val songs: HashMap<Int, SongUI> = DataHolder.songs,
    val visibleSongs: HashMap<Int, SongUI> = DataHolder.songs
)

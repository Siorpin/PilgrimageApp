package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.BuildApiResponse
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.SongsResponse
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SongbookScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(SongbookScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = SongbookScreenState()
    )

    init {
        getSongs()
        delayPadding()
    }

    fun updateText(text: String) {
        _state.update { it.copy(searchedText = text) }
    }

    fun search(text: String) {
        val tempList: MutableList<SongsResponse> = mutableListOf()

        _state.value.songs.forEach{ song ->
            if (
                song.title.lowercase().contains(text.lowercase()) ||
                song.lyrics.lowercase().contains(text.lowercase())
                ) {
                tempList.add(song)
            }
        }

        _state.update { it.copy(visibleSongs = tempList) }
    }

    private fun getSongs() {
//        viewModelScope.launch {
//            _state.update { it.copy(isLoading = true) }
//            val result = BuildApiResponse.api.getSongs()
//            _state.update { it.copy(isLoading = false, songs = result.songsList, visibleSongs = result.songsList) }
//        }
        _state.update { it.copy(isLoading = false, songs = DataHolder.songs, visibleSongs = DataHolder.songs) }
    }

    private fun delayPadding() {
        viewModelScope.launch {
            delay(1000)
            _state.update { it.copy(contentBottomPadding = DataHolder.overallBottomPadding) }
        }
    }
}
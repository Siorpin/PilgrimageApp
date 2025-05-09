package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SongbookScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(SongbookScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = SongbookScreenState()
    )

    init {
        getSongs()
    }

    fun updateText(text: String) {
        _state.update { it.copy(searchedText = text) }
    }

    fun search(text: String) {
        val tempList: HashMap<Int, SongUI> = hashMapOf()

        _state.value.songs.forEach{ song ->
            if (
                song.value.title.lowercase().contains(text.lowercase()) ||
                song.value.lyrics.lowercase().contains(text.lowercase()) ||
                song.key.toString() == text
                ) {
                tempList.put(song.key, song.value)
            }
        }
        _state.update { it.copy(visibleSongs = tempList) }
    }

    private fun getSongs() {
        _state.update { it.copy(isLoading = false, songs = DataHolder.songs, visibleSongs = DataHolder.songs) }
    }
}
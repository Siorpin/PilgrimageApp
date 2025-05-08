package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.PrayerUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class ModlitewnikScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(ModlitewnikScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ModlitewnikScreenState()
    )

    init {
        getModlitwy()
    }

    fun updateText(text: String) {
        _state.update { it.copy(searchedText = text) }
    }

    fun search(text: String) {
        val tempList: MutableList<PrayerUI> = mutableListOf()

        _state.value.prayers.forEach{ prayer ->
            if (
                prayer.title.lowercase().contains(text.lowercase()) ||
                prayer.lyrics.lowercase().contains(text.lowercase())
                ) {
                tempList.add(prayer)
            }
        }

        _state.update { it.copy(visiblePrayers = tempList) }
    }

    private fun getModlitwy() {
        _state.update { it.copy(prayers = DataHolder.prayers, visiblePrayers = DataHolder.prayers) }
    }
}
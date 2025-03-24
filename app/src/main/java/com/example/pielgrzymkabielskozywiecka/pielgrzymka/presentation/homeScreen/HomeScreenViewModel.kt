package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class HomeScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        initialValue = HomeScreenState(),
        started = SharingStarted.WhileSubscribed(5000)
    )

    init {
        getAnnouncements()
    }

    fun getAnnouncements() {
        val announcement = DataHolder.announcement
        _state.update { it.copy(ogloszeniaText = announcement.text, title = announcement.title) }
    }
}
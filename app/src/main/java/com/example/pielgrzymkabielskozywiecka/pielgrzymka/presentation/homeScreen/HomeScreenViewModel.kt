package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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

    private fun getAnnouncements() {
        val announcement = DataHolder.announcement
        _state.update { it.copy(ogloszeniaText = announcement.text, title = announcement.title) }
    }

    fun togglePopUp() {
        _state.update { it.copy(popUpVisible = !_state.value.popUpVisible) }
    }

    fun refreshData() {
        viewModelScope.launch {
            DataHolder.refreshDataFunction()
            DataHolder.isAppLoaded = false
            getAnnouncements()
        }
    }
}
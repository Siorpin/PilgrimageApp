package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class DuchowiScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(DuchowiScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DuchowiScreenState()
    )

    fun togglePopUp() {
       _state.update { it.copy(popUpVisible = !state.value.popUpVisible) }
    }
}
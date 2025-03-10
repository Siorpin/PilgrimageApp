package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ZakladkiScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(ZakladkiScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ZakladkiScreenState()
    )
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.data.networking.BuildApiResponse
import com.example.pielgrzymkabielskozywiecka.core.domain.DataHolder
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ModlitewnikScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(ModlitewnikScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ModlitewnikScreenState()
    )

    init {
        getModlitwy()
        delayPadding()
    }

    private fun getModlitwy() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val result = BuildApiResponse.api.getModlitwy()
            _state.update { it.copy(isLoading = false, modlitwy = result.modlitwy) }
        }
    }

    private fun delayPadding() {
        viewModelScope.launch {
            delay(1000)
            _state.update { it.copy(contentBottomPadding = DataHolder.overallBottomPadding) }
        }
    }
}
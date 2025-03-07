package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.data.networking.BuilApiResponse
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
        getOgloszenia(false)
    }

    fun getOgloszenia(all: Boolean) {
        viewModelScope.launch {
            _state.update { it.copy(isOgloszenieLoading = true) }
            val result = BuilApiResponse.api.getOgloszenia(all)
            _state.update { it.copy(
                isOgloszenieLoading = false,
                ogloszeniaText = result.text
            ) }
        }
    }
}
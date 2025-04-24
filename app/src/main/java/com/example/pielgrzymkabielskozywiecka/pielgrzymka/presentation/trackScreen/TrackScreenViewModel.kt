package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync.TrackRepository
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.DataError
import com.example.pielgrzymkabielskozywiecka.core.data.networking.TrackResponse
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toTrackUI
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TrackScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(TrackScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = TrackScreenState()
    )

    private val repository = TrackRepository()

    init {
        refreshData()
    }

    fun refreshData() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            when(val response = repository.getData()) {
                is Result.Success -> {
                    _state.update { it.copy(
                        errorMessage = null,
                        isLoading = false,
                        trackUI = response.data.toTrackUI()
                    ) }
                }
                is Result.Error -> {
                    val errorMessage = when(response.error) {
                        DataError.Network.REQUEST_TIMEOUT -> "Przekroczono czas oczekiwania. Spróbuj ponownie później."
                        DataError.Network.NO_CONNECTION -> "Żeby sprawdzić gdzie aktualnie znajduje się pielgrzymka połącz się z internetem!"
                        DataError.Network.SERVER_ERROR -> "Wystąpił niespodziewany błąd, właśnie pracujemy nad jego rozwiązaniem. Przepraszamy!"
                        else -> "Wystąpił niespodziewany błąd, przepraszamy!"
                    }
                    _state.update { it.copy(errorMessage = errorMessage, isLoading = false) }
                }
            }
        }
    }
}
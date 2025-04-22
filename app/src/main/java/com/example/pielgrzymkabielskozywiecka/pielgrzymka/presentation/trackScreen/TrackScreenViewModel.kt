package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync.TrackRepository
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.DataError
import com.example.pielgrzymkabielskozywiecka.core.data.networking.TrackResponse
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

    init {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            when(val response = getData()) {
                is Result.Success -> {
                    _state.update { it.copy(percentage = response.data.percentage, isLoading = false) }
                }
                is Result.Error -> {
                    Log.d("error", response.error.toString())
                    _state.update { it.copy(isLoading = false) }
                }
            }
        }
    }

    suspend fun getData(): Result<TrackResponse, DataError> {
        val repository = TrackRepository()
        return repository.getData()
    }
}
package com.example.pielgrzymkabielskozywiecka

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.BuildApiResponse
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun fetchSongs() {
        viewModelScope.launch {
            val response = BuildApiResponse.api.getSongs()
        }
    }
}
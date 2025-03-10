package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.ModlitwyResponse

data class ModlitewnikScreenState(
    val isLoading: Boolean = true,
    val modlitwy: List<ModlitwyResponse> = emptyList()
)

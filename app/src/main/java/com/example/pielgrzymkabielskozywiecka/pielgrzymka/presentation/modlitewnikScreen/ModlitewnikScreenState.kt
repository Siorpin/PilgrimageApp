package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.ModlitwyResponse

data class ModlitewnikScreenState(
    val isLoading: Boolean = true,
    val contentBottomPadding: Dp = 0.dp,
    val searchedText: String = "",
    val prayers: List<ModlitwyResponse> = DataHolder.prayers,
    val visiblePrayers: List<ModlitwyResponse> = emptyList()
)

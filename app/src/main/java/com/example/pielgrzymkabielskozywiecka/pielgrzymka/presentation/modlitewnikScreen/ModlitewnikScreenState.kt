package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.ModlitwyResponse

data class ModlitewnikScreenState(
    val isLoading: Boolean = true,
    val contentBottomPadding: Dp = 0.dp,
    val modlitwy: List<ModlitwyResponse> = emptyList()
)

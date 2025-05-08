package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.PrayerUI

data class ModlitewnikScreenState(
    val isLoading: Boolean = true,
    val searchedText: String = "",
    val prayers: List<PrayerUI> = emptyList(),
    val visiblePrayers: List<PrayerUI> = emptyList()
)

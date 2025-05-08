package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen

import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.PrayerUI

data class ModlitewnikScreenState(
    val searchedText: String = "",
    val prayers: List<PrayerUI> = emptyList(),
    val visiblePrayers: List<PrayerUI> = emptyList()
)

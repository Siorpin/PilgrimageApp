package com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels

import com.example.pielgrzymkabielskozywiecka.core.presentation.enumClasses.Days

data class RosaryMysteryUI(
    val title: String,
    val text: String,
    val days: List<Days>
)

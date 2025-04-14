package com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels

import androidx.annotation.StringRes
import com.example.pielgrzymkabielskozywiecka.core.presentation.enumClasses.Days

data class RosaryMysteryUI(
    val title: String,
    @StringRes val text: Int,
    val days: List<Days>,
    val background: Int
)

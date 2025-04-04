package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen

import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.RosaryMysteryUI

data class RosaryScreenState(
    val currentDay: Int = 1,
    val primaryMystery: RosaryMysteryUI = RosaryMysteryUI("",""),
    val secondaryMystery: List<RosaryMysteryUI> = emptyList()
)
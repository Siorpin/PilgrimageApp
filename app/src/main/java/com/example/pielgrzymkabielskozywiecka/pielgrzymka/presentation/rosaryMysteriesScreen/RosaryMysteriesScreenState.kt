package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryMysteriesScreen

import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.enumClasses.Days
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.RosaryMysteryUI

data class RosaryMysteriesScreenState(
    val currentDay: Days = Days.MONDAY,
    val primaryMystery: RosaryMysteryUI = DataHolder.rosaryMysteries[0],
    val mysteries: List<RosaryMysteryUI> = DataHolder.rosaryMysteries
)
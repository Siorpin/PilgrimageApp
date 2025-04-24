package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen

import com.example.pielgrzymkabielskozywiecka.core.data.networking.TrackStop
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.TrackUI

data class TrackScreenState(
    val trackUI: TrackUI = TrackUI(
        percentage = 0,
        overallPercentage = 0,
        currentStop = TrackStop(0, ""),
        nextStop = null,
        day = 0
    ),
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)

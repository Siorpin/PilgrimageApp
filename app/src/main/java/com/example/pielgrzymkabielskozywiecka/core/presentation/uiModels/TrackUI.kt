package com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels

import com.example.pielgrzymkabielskozywiecka.core.data.networking.TrackStop

data class TrackUI(
    val percentage: Int,
    val overallPercentage: Int,
    val day: Int,
    val currentStop: TrackStop,
    val nextStop: TrackStop?
)

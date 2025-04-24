package com.example.pielgrzymkabielskozywiecka.core.presentation.mappers

import com.example.pielgrzymkabielskozywiecka.core.data.networking.TrackResponse
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.TrackUI

fun TrackResponse.toTrackUI(): TrackUI {
    return TrackUI(
        percentage = dayPercentage,
        overallPercentage = overallPercentage,
        day = day,
        currentStop = currentStop,
        nextStop = if (overallPercentage == 100) null else nextStop
    )
}
package com.example.pielgrzymkabielskozywiecka.core.data.networking

import com.google.gson.annotations.SerializedName

data class TrackResponse(
    @SerializedName("overallPercentage") val overallPercentage: Int,
    @SerializedName("dayPercentage") val dayPercentage: Int,
    @SerializedName("day") val day: Int,
    @SerializedName("currentStop") val currentStop: TrackStop,
    @SerializedName("nextStop") val nextStop: TrackStop
): Response

data class TrackStop(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
): Response

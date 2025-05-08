package com.example.pielgrzymkabielskozywiecka.core.data.networking

import com.google.gson.annotations.SerializedName

data class ConferencesResponse(
    @SerializedName("title") val title: String,
    @SerializedName("text") val text: String
): Response

data class ConferencesList (
    @SerializedName("results") val conferences: List<ConferencesResponse>
): Response

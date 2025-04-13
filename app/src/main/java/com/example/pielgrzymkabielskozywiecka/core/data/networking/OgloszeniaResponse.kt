package com.example.pielgrzymkabielskozywiecka.core.data.networking

import com.google.gson.annotations.SerializedName

data class OgloszeniaResponse(
    @SerializedName("title") val title: String,
    @SerializedName("text") val text: String
): Response

data class OgloszeniaList(
    @SerializedName("results") val results: List<OgloszeniaResponse>
): Response
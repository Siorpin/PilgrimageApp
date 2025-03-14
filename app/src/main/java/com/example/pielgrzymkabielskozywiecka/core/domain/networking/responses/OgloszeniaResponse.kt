package com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses

import com.google.gson.annotations.SerializedName

data class OgloszeniaResponse(
    @SerializedName("title") val title: String,
    @SerializedName("text") val text: String
)

data class OgloszeniaList(
    @SerializedName("results") val results: List<OgloszeniaResponse>
)
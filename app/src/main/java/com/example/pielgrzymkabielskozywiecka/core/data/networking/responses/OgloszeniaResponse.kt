package com.example.pielgrzymkabielskozywiecka.core.data.networking.responses

import com.google.gson.annotations.SerializedName

data class OgloszeniaResponse(
    //@SerializedName("title") val title: String,
    @SerializedName("text") val text: String
)

data class Results(
    @SerializedName("results") val results: List<OgloszeniaResponse>
)
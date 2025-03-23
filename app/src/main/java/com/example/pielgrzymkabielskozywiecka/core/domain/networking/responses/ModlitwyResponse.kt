package com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses

import com.google.gson.annotations.SerializedName

data class ModlitwyResponse(
    @SerializedName("title") val title: String,
    @SerializedName("lyrics") val lyrics: String
)

data class ModlitwyList(
    @SerializedName("results") val modlitwy: List<ModlitwyResponse>
)

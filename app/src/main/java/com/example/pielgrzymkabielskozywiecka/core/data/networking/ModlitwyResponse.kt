package com.example.pielgrzymkabielskozywiecka.core.data.networking

import com.google.gson.annotations.SerializedName

data class ModlitwyResponse(
    @SerializedName("title") val title: String,
    @SerializedName("lyrics") val lyrics: String
): Response

data class ModlitwyList(
    @SerializedName("results") val modlitwy: List<ModlitwyResponse>
): Response

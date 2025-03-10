package com.example.pielgrzymkabielskozywiecka.core.data.networking.responses

import com.google.gson.annotations.SerializedName

data class ModlitwyResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("lyrics") val lyrics: String
)

data class ModlitwyList(
    @SerializedName("results") val modlitwy: List<ModlitwyResponse>
)

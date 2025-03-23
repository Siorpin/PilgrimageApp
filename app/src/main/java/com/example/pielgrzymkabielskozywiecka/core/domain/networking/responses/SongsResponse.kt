package com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses

import com.google.gson.annotations.SerializedName

data class SongsResponse(
    @SerializedName("title") val title: String,
    @SerializedName("lyrics") val lyrics: String
)

data class SongsList(
    @SerializedName("results") val songsList: List<SongsResponse>
)
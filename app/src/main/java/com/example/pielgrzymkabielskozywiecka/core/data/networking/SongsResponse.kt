package com.example.pielgrzymkabielskozywiecka.core.data.networking

import com.google.gson.annotations.SerializedName

class SongsResponse(
    @SerializedName("title") val title: String,
    @SerializedName("lyrics") val lyrics: String
): Response

data class SongsList(
    @SerializedName("results") val songsList: List<SongsResponse>
): Response
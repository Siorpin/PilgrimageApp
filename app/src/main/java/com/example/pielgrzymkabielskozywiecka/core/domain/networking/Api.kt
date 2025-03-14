package com.example.pielgrzymkabielskozywiecka.core.domain.networking

import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.ModlitwyList
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.OgloszeniaList
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.SongsList
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/ogloszenia")
    suspend fun getOgloszenia(@Query("all") all: Boolean): OgloszeniaList

    @GET("/modlitwy")
    suspend fun getPrayers(): ModlitwyList

    @GET("/piosenki")
    suspend fun getSongs(): SongsList
}
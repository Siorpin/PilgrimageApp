package com.example.pielgrzymkabielskozywiecka.core.domain.networking

import com.example.pielgrzymkabielskozywiecka.core.data.networking.ModlitwyList
import com.example.pielgrzymkabielskozywiecka.core.data.networking.OgloszeniaList
import com.example.pielgrzymkabielskozywiecka.core.data.networking.SongsList
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @GET("/ogloszenia")
    suspend fun getOgloszenia(@Query("all") all: Boolean): OgloszeniaList

    @GET("/modlitwy")
    suspend fun getPrayers(): ModlitwyList

    @GET("/piosenki")
    suspend fun getSongs(): SongsList

    @POST("/register-fcm-token")
    suspend fun sendToken(@Query("token") token: String)
}
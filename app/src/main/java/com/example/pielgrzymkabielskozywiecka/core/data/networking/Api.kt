package com.example.pielgrzymkabielskozywiecka.core.data.networking

import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.OgloszeniaResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface Api {
    @GET("/ogloszenia")
    suspend fun getOgloszenia(@Body all: Boolean): OgloszeniaResponse
}
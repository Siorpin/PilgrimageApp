package com.example.pielgrzymkabielskozywiecka.core.data.networking

import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.OgloszeniaResponse
import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.Results
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/ogloszenia")
    suspend fun getOgloszenia(@Query("all") all: Boolean): Results
}
package com.example.pielgrzymkabielskozywiecka.core.data.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/ogloszenia")
    suspend fun getOgloszenia(): String // TODO
}
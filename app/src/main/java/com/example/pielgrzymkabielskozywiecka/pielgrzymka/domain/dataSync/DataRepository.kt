package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync

import com.example.pielgrzymkabielskozywiecka.core.data.networking.Response
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.DataError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result

sealed interface DataRepository {
    suspend fun getData(): Result<Response, DataError>
}
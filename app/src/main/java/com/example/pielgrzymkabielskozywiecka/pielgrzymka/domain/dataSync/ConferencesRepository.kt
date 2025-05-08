package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync

import com.example.pielgrzymkabielskozywiecka.core.data.networking.ConferencesList
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.BuildApiResponse
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.DataError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result
import okio.IOException
import retrofit2.HttpException
import java.net.UnknownHostException

class ConferencesRepository: DataRepository {
    override suspend fun getData(): Result<ConferencesList, DataError.Network> {
        return try {
            val response = BuildApiResponse.api.getConferences()
            Result.Success(response)
        } catch (e: HttpException) {
            when(e.code()) {
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                429 -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
                in 500..599 -> Result.Error(DataError.Network.SERVER_ERROR)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }
        } catch (e: IOException) {
            Result.Error(DataError.Network.NO_CONNECTION)
        } catch (e: UnknownHostException) {
            Result.Error(DataError.Network.UNKNOWN_HOST)
        }
    }
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync

import com.example.pielgrzymkabielskozywiecka.core.data.networking.OgloszeniaList
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.BuildApiResponse
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.DataError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class AnnouncementsRepository: DataRepository {
    override suspend fun getData(): Result<OgloszeniaList, DataError.Network> {
        return try {
            val response = BuildApiResponse.api.getOgloszenia(true)
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
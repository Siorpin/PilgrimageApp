package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync

import com.example.pielgrzymkabielskozywiecka.core.data.networking.TrackResponse
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.BuildApiResponse
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.DataError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class TrackRepository: DataRepository {
    override suspend fun getData(): Result<TrackResponse, DataError.Network> {
           return try {
               val response = BuildApiResponse.api.getTrack()
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
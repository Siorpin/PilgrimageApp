package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler

import android.content.ActivityNotFoundException
import android.content.Context
import androidx.compose.ui.platform.UriHandler
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result

class WWWActivityStarter(
    private val uriHandler: UriHandler,
    private val uri: String
): ActivityStarter {
    override fun startActivity(context: Context): Result<Unit, ActivityError> {
        return try {
            uriHandler.openUri(uri)

            Result.Success(Unit)
        } catch (e: ActivityNotFoundException) {
            Result.Error(ActivityError.Execution.ACTIVITY_NOT_FOUND)
        } catch (e: Error) {
            Result.Error(ActivityError.Execution.UNKNOWN)
        }
    }
}
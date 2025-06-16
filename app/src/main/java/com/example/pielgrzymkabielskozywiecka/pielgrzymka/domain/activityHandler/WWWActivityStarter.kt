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
    override fun startActivity(context: Context, afterFunction: () -> Unit): Result<() -> Unit, ActivityError> {
        try {
            uriHandler.openUri(uri)

            return Result.Success(afterFunction)
        } catch (e: ActivityNotFoundException) {
            return Result.Error(ActivityError.Execution.ACTIVITY_NOT_FOUND)
        } catch (e: Error) {
            return Result.Error(ActivityError.Execution.UNKNOWN)
        }
    }
}
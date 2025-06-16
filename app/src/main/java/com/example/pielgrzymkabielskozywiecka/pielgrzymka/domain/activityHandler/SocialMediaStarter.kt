package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result
import androidx.core.net.toUri
import androidx.navigation.ActivityNavigatorExtras

abstract class SocialMediaStarter(
    private val appPackage: String,
    private val link: String
): ActivityStarter {
    override fun startActivity(context: Context, afterFunction: () -> Unit): Result<() -> Unit, ActivityError> {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage(appPackage)
            context.startActivity(intent)

            return Result.Success(afterFunction)
        } catch (e: ActivityNotFoundException) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = link.toUri()
            context.startActivity(intent)

            return Result.Error(ActivityError.Execution.ACTIVITY_NOT_FOUND)
        }  catch (e: Error) {
            return Result.Error(ActivityError.Execution.UNKNOWN)
        }
    }
}
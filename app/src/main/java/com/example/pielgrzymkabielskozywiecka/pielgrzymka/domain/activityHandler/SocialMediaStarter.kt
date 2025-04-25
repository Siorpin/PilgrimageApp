package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result

abstract class SocialMediaStarter(
    private val appPackage: String,
    private val link: String
): ActivityStarter {
    override fun startActivity(context: Context): Result<Unit, ActivityError> {
        return try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(link)
            intent.setPackage(appPackage)
            context.startActivity(intent)

            Result.Success(Unit)
        } catch (e: ActivityNotFoundException) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(link)
            context.startActivity(intent)

            Result.Success(Unit)
        }  catch (e: Error) {
            Result.Error(ActivityError.Execution.UNKNOWN)
        }
    }
}
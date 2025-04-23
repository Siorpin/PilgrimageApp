package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result

class EmailActivityStarter(
    private val subject: String,
    private val text: String,
    private val receiver: String
): ActivityStarter {
    override fun startActivity(
        context: Context
    ): Result<Unit, ActivityError> {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "vnd.android.cursor.item/email"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receiver))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            context.startActivity(intent)

            return Result.Success(Unit)
        } catch (e: ActivityNotFoundException) {
            return Result.Error(ActivityError.Execution.ACTIVITY_NOT_FOUND)
        } catch (e: Exception) {
            return Result.Error(ActivityError.Execution.UNKNOWN)
        }
    }
}
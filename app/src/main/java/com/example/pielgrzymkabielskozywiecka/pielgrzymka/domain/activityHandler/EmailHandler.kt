package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler

import android.content.Context
import android.widget.Toast
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result

class EmailHandler(
    private val subject: String,
    private val text: String,
    private val receiver: String
) {
    fun sendEmail(context: Context, afterFunction: () -> Unit = {}) {
        val emailStarter = EmailActivityStarter(subject, text, receiver)
        val result = emailStarter.startActivity(context, afterFunction)

        if (result is Result.Error) {
            val toastMessage = when(result.error) {
                ActivityError.Execution.ACTIVITY_NOT_FOUND -> "Nie znaleziono aplikacji pocztowej!"
                ActivityError.Execution.UNKNOWN -> "Wystąpił nieznany błąd!"
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        } else if(result is Result.Success) {
            result.data()
        }
    }
}
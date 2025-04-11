package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast

class EmailHandler(
    private val receiver: String
) {
    fun sendEmail(context: Context, subject: String, text: String) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.type = "vnd.android.cursor.item/email"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receiver))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            context.startActivity(intent)
        }
        catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Nie znaleziono aplikacji pocztowej", Toast.LENGTH_LONG).show()
        }
    }
}
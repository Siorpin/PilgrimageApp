package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.emailHandler

import android.content.Context
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result

sealed interface ActivityStarter {
    fun startActivity(context: Context): Result<Unit, ActivityError>
}
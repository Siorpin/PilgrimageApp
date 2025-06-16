package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler

import android.content.Context
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result

sealed interface ActivityStarter {
    fun startActivity(
        context: Context,
        afterFunction: () -> Unit = {}
    ): Result<() -> Unit, ActivityError>
}
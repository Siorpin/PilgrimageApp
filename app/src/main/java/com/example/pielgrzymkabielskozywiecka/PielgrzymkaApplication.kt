package com.example.pielgrzymkabielskozywiecka

import android.app.Application
import com.google.firebase.FirebaseApp

class PielgrzymkaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
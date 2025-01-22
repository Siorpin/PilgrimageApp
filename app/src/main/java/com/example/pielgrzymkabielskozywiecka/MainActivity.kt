package com.example.pielgrzymkabielskozywiecka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.pielgrzymkabielskozywiecka.ui.theme.PielgrzymkaAppTheme
import com.example.pielgrzymkabielskozywiecka.core.navigation.AppNavigation
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            PielgrzymkaAppTheme (dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        startDestination = Screen.HOME,
                        padding = innerPadding
                    )
                }
            }
        }
    }
}
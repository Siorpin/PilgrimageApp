package com.example.pielgrzymkabielskozywiecka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pielgrzymkabielskozywiecka.ui.theme.PielgrzymkaAppTheme
import com.example.pielgrzymkabielskozywiecka.core.navigation.AppNavigation
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.topAppBar.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            PielgrzymkaAppTheme (dynamicColor = false) {
                // Checks what is current screen
                val backStackEntry by navController.currentBackStackEntryAsState()
                val isHidden = when(backStackEntry?.destination?.route){
                    Screen.HOME.name -> false
                    else -> true
            }

                Scaffold(
                    topBar = {
                        TopBar()
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
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
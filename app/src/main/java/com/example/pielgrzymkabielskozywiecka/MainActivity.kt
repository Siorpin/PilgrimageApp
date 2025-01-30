package com.example.pielgrzymkabielskozywiecka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pielgrzymkabielskozywiecka.core.navigation.AppNavigation
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.BottomBar
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.topBar.TopBar
import com.example.pielgrzymkabielskozywiecka.ui.theme.PielgrzymkaAppTheme

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
                    bottomBar =  { BottomBar(navController) } ,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    val topPadding = innerPadding.calculateTopPadding()
                    var bottomPadding = innerPadding.calculateBottomPadding()
                    if (bottomPadding > 0.dp) bottomPadding -= 15.dp

                    AppNavigation(
                        navController = navController,
                        startDestination = Screen.HOME,
                        padding = PaddingValues(
                            top = topPadding,
                            bottom = bottomPadding
                        )
                    )
                }
            }
        }
    }
}
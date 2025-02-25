package com.example.pielgrzymkabielskozywiecka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pielgrzymkabielskozywiecka.core.domain.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.navigation.AppNavigation
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.BottomBar
import com.example.pielgrzymkabielskozywiecka.ui.theme.PielgrzymkaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            PielgrzymkaAppTheme {
                Scaffold(
                    bottomBar =  { BottomBar(navController) } ,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    val topPadding = innerPadding.calculateTopPadding()
                    val bottomPadding = 80.dp

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
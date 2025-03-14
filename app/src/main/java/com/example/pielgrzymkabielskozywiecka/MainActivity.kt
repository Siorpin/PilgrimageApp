package com.example.pielgrzymkabielskozywiecka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
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
                // val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)

                Scaffold(
                    bottomBar =  { BottomBar(
                        navController = navController
                    ) } ,
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.navigationBars)
                ) { innerPadding ->

                    val padding = PaddingValues(
                        top = innerPadding.calculateTopPadding(),
                        start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                        end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = 0.dp
                    )

                    AppNavigation(
                        navController = navController,
                        startDestination = Screen.HOME,
                        padding = padding
                    )
                }
            }
        }
    }
}
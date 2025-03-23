package com.example.pielgrzymkabielskozywiecka

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.pielgrzymkabielskozywiecka.core.navigation.AppNavigation
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.NotificationsManager
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.BottomBar
import com.example.pielgrzymkabielskozywiecka.ui.theme.PielgrzymkaAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var notificationsManager: NotificationsManager
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {}
        notificationsManager = NotificationsManager()
        checkNotificationPermission(this, requestPermissionLauncher)

        setContent {
            val viewModel: MainViewModel = viewModel()
            val navController = rememberNavController()

            PielgrzymkaAppTheme {
                Scaffold(
                    bottomBar = { BottomBar(navController = navController) },
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

    private fun checkNotificationPermission(activity: Activity, launcher: ActivityResultLauncher<String>) {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}
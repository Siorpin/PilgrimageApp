package com.example.pielgrzymkabielskozywiecka.core.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.authorsScreen.AuthorsScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: Screen,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.name,
        modifier = modifier
            .padding(padding)
    ) {
        // HOME
        composable(
            route = Screen.HOME.name,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ){
            HomeScreen(navController)
        }

        // AUTHORS
        composable(
            route = Screen.AUTORZY.name,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            AuthorsScreen(navController)
        }
    }
}
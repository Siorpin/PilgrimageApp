package com.example.pielgrzymkabielskozywiecka.core.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.authorsScreen.AuthorsScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.DuchowiScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.HomeScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen.ModlitewnikScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen.SongbookScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen.ZakladkiScreen

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
            HomeScreen(
                navController,
                modifier = Modifier
                    .padding(bottom = DataHolder.overallBottomPadding)
            )
        }

        // ZAKŁADKI
        composable(
            route = Screen.ZAKLADKI.name,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            ZakladkiScreen(navController)
        }

        // DUCHOWI
        composable(
            route = Screen.DUCHOWI.name,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            DuchowiScreen(
                navController,
                modifier = Modifier
                    .padding(bottom = DataHolder.overallBottomPadding)
            )
        }

        // AUTHORS
        composable(
            route = Screen.AUTORZY.name,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {
            AuthorsScreen(navController)
        }

        // Modlitewnik
        composable(
            route = Screen.MODLITEWNIK.name,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {
            ModlitewnikScreen(
                navController
            )
        }

        // Songbook
        composable(
            route = Screen.SPIEWNIK.name,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {
            SongbookScreen(
                navController
            )
        }

    }
}
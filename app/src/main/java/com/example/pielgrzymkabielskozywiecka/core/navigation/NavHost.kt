package com.example.pielgrzymkabielskozywiecka.core.navigation

import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.KidsProtectionScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.authorsScreen.AuthorsScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.conferencesScreen.ConferencesScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.DuchowiScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.HomeScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen.ModlitewnikScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.mysteryScreen.MysteryScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.prayerScreen.PrayerScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryMysteriesScreen.RosaryMysteriesScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.singleConferenceScreen.SingleConferenceScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songScreen.SongScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen.SongbookScreen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen.TrackScreen
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

        // KIDS PROTECTION STANDARDS
        composable(
            route = Screen.KIDS_PROTECTION_STANDARDS.name,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {
            KidsProtectionScreen(navController)
        }

        // Modlitewnik
        composable(
            route = Screen.MODLITEWNIK.name,
            enterTransition = {
                val source = initialState.destination.route
                if(source == Screen.ZAKLADKI.name) slideInHorizontally { it }
                else EnterTransition.None
            },
            exitTransition = {
                val destination = targetState.destination.route
                if (destination == Screen.ZAKLADKI.name) slideOutHorizontally { it }
                else { ExitTransition.None }
            }
        ) {
            ModlitewnikScreen(navController)
        }

        // Songbook
        composable(
            route = Screen.SPIEWNIK.name,
            enterTransition = {
                val source = initialState.destination.route
                if(source == Screen.ZAKLADKI.name) slideInHorizontally { it }
                else EnterTransition.None
            },
            exitTransition = {
                val destination = targetState.destination.route
                if (destination == Screen.ZAKLADKI.name) slideOutHorizontally { it }
                else { ExitTransition.None }
            }
        ) {
            SongbookScreen(navController)
        }

        // mysteries of the rosary
        composable(
            route = Screen.TAJEMNICE.name,
            enterTransition = {
                val source = initialState.destination.route
                if(source == Screen.ZAKLADKI.name) slideInHorizontally { it }
                else EnterTransition.None
            },
            exitTransition = {
                val destination = targetState.destination.route
                Log.d("exit", destination.toString())
                if (destination == Screen.ZAKLADKI.name) slideOutHorizontally { it }
                else { ExitTransition.None }
            }
        ) {
            RosaryMysteriesScreen(navController)
        }

        // Mystery
        composable(
            route = Screen.MYSTERY.name + "/{title}",
            arguments = listOf(
                navArgument("title"){type = NavType.StringType}
            ),
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {  backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")

            MysteryScreen(
                mysteryUI = DataHolder.rosaryMysteries.find {
                    it.title == title
                },
                navController = navController
            )
        }

        // Prayer
        composable(
            route = Screen.PRAYER.name + "/{title}/{lyrics}",
            arguments = listOf(
                navArgument("title"){type = NavType.StringType},
                navArgument("lyrics"){type = NavType.StringType}
            ),
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {  backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val lyrics = backStackEntry.arguments?.getString("lyrics")

            PrayerScreen(
                title = title,
                lyrics = lyrics,
                navController = navController
            )
        }

        // Song
        composable(
            route = Screen.SONG.name + "/{id}",
            arguments = listOf(
                navArgument("id"){type = NavType.IntType}
            ),
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {  backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            val song = DataHolder.songs[id]

            SongScreen(
                song = song,
                navController = navController
            )
        }

        // SingleConference
        composable(
            route = Screen.SINGLE_CONFERENCE.name + "/{title}/{text}",
            arguments = listOf(
                navArgument("title"){type = NavType.StringType},
                navArgument("text"){type = NavType.StringType}
            ),
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {  backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val text = backStackEntry.arguments?.getString("text")

            SingleConferenceScreen(
                title = title,
                text = text,
                navController = navController
            )
        }

        // Track
        composable(
            route = Screen.TRACK.name,
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { it } }
        ) {
            TrackScreen(navController)
        }

        // Conferences
        composable(
            route = Screen.CONFERENCES.name,
            enterTransition = {
                val source = initialState.destination.route
                if(source == Screen.DUCHOWI.name) slideInHorizontally { it }
                else EnterTransition.None
            },
            exitTransition = {
                val destination = targetState.destination.route
                if (destination == Screen.DUCHOWI.name) slideOutHorizontally { it }
                else { ExitTransition.None }
            }
        ) {
            ConferencesScreen(navController)
        }
    }
}
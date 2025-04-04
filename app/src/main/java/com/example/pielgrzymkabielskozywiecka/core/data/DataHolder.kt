package com.example.pielgrzymkabielskozywiecka.core.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.AnnouncementUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.BottomBarUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.PrayerUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.ZakladkiUI

object DataHolder {
    val overallBottomPadding = 100.dp

    var songs: List<SongUI> = emptyList()
    var prayers: List<PrayerUI> = emptyList()
    var announcement: AnnouncementUI = AnnouncementUI("","")

    var refreshDataFunction: () -> Unit = {}

    val bottomBarButtons = listOf(
        BottomBarUI(
            name = "Dom",
            screen = Screen.HOME,
            icon = Icons.Default.Home,
            isOnFocus = true
        ),
        BottomBarUI(
            name = "Zakładki",
            screen = Screen.ZAKLADKI,
            icon = Icons.Default.Star,
        ),
        BottomBarUI(
            name = "Duchowi",
            screen = Screen.DUCHOWI,
            icon = Icons.Default.AccountCircle,
        )
    )

    val zakladki = listOf(
        ZakladkiUI(
            name = "Śpiewnik",
            destination = Screen.SPIEWNIK
        ),
        ZakladkiUI(
            name = "Modlitewnik",
            destination = Screen.MODLITEWNIK
        ),
        ZakladkiUI(
            name = "Tajemnice różańca",
            destination = Screen.TAJEMNICE
        ),
        ZakladkiUI(
            name = "Strona internetowa",
            destination = Screen.WWW
        ),
        ZakladkiUI(
            name = "Autorzy",
            destination = Screen.AUTORZY
        )
    )


}
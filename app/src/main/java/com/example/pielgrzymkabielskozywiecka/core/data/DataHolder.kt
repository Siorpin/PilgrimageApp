package com.example.pielgrzymkabielskozywiecka.core.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.R
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.core.presentation.enumClasses.Days
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.AnnouncementUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.BottomBarUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.ConferencesUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.PrayerUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.RosaryMysteryUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.ZakladkiUI

object DataHolder {
    val overallBottomPadding = 100.dp

    lateinit var songs: HashMap<Int, SongUI>
    lateinit var prayers: List<PrayerUI>
    lateinit var conferences: List<ConferencesUI>
    var announcement: AnnouncementUI = AnnouncementUI("","")

    var refreshDataFunction: () -> Unit = {}

    var isAppLoaded = false

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
        ),
        ZakladkiUI(
            name = "Standardy ochrony małoletnich",
            destination = Screen.KIDS_PROTECTION_STANDARDS
        )
    )

    val rosaryMysteries = listOf(
        RosaryMysteryUI(
            title = "Tajemnice radosne",
            text = R.string.tajemnice_radosne,
            days = listOf(Days.MONDAY, Days.SATURDAY),
            R.drawable.tajemnica_radosna_cropped
        ),
        RosaryMysteryUI(
            title = "Tajemnice światła",
            text = R.string.tajemnice_swiatla,
            days = listOf(Days.THURSDAY),
            R.drawable.tajemnica_swiatla_cropped
        ),
        RosaryMysteryUI(
            title = "Tajemnice bolesne",
            text = R.string.tajemnice_bolesne,
            days = listOf(Days.TUESDAY, Days.FRIDAY),
            R.drawable.tajemnica_bolesna_cropped
        ),
        RosaryMysteryUI(
            title = "Tajemnice chwalebne",
            text = R.string.tajemnice_chwalebne,
            days = listOf(Days.WEDNESDAY, Days.SUNDAY),
            R.drawable.tajemnica_chwalebna_cropped
        )
    )

}
package com.example.pielgrzymkabielskozywiecka.core.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.core.presentation.BottomBarUI
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.Root

object DataHolder {
    val roots: List<Root> = listOf(
        Root("Home", Screen.HOME),
        Root("Śpiewnik", Screen.SPIEWNIK),
        Root("Modlitewnik", Screen.MODLITEWNIK),
        Root("Intencje", Screen.INTENCJE),
        Root("Tajemnice różańca", Screen.TAJEMNICE),
        Root("Liturgia Słowa", Screen.LITURGIA_SLOWA),
        Root("Trasa", Screen.MAPA),
        Root("Grupy", Screen.GRUPY),
        Root("Dokumenty", Screen.DOKUMENTY),
        Root("Galeria", Screen.GALERIA),
        Root("Autorzy", Screen.AUTORZY)
    )
    val bottomBarButtons = listOf(
        BottomBarUI(
            name = "Home",
            screen = Screen.HOME,
            icon = Icons.Default.Home,
            isOnFocus = true
        ),
        BottomBarUI(
            name = "Zakładki",
            screen = Screen.OGLOSZENIA,
            icon = Icons.Default.Star,
        ),
        BottomBarUI(
            name = "Pielgrzmymi duchowi",
            screen = Screen.AUTORZY,
            icon = Icons.Default.AccountCircle,
        )
    )
}
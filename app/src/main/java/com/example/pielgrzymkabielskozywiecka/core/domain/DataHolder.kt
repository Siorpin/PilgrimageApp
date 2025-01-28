package com.example.pielgrzymkabielskozywiecka.core.domain

import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.Root

object DataHolder {
    val roots: List<Root> = listOf(
        Root("Ogłoszenia", Screen.OGLOSZENIA),
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
}
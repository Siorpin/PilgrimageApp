package com.example.pielgrzymkabielskozywiecka.core.presentation.mappers

import com.example.pielgrzymkabielskozywiecka.core.presentation.enumClasses.Days

fun Days.daysToPolish(): String {
    return when(this) {
        Days.MONDAY -> "Poniedziałek"
        Days.TUESDAY -> "Wtorek"
        Days.WEDNESDAY -> "Środa"
        Days.THURSDAY -> "Czwartek"
        Days.FRIDAY -> "Piątek"
        Days.SATURDAY -> "Sobota"
        Days.SUNDAY -> "Niedziela"
    }
}
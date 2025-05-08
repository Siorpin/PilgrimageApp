package com.example.pielgrzymkabielskozywiecka.core.presentation.mappers

import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Prayers
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.PrayerUI

fun Prayers.toPrayerUI(id: Int): PrayerUI {
    return PrayerUI(
        id = id,
        title = title,
        lyrics = lyrics
    )
}
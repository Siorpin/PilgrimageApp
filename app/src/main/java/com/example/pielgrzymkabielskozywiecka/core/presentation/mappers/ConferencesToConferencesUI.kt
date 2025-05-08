package com.example.pielgrzymkabielskozywiecka.core.presentation.mappers

import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Conferences
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.ConferencesUI

fun Conferences.toConferencesUI(id: Int): ConferencesUI {
    return ConferencesUI(
        id = id,
        text = text,
        title = title
    )
}
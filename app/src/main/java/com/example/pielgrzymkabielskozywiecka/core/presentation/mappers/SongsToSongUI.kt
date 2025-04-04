package com.example.pielgrzymkabielskozywiecka.core.presentation.mappers

import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Songs
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI

fun Songs.toSongUI(): SongUI {
    return SongUI(
        title = title,
        lyrics = lyrics
    )
}
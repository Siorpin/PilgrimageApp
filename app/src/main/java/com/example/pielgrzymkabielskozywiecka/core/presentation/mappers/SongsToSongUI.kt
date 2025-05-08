package com.example.pielgrzymkabielskozywiecka.core.presentation.mappers

import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Songs
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI

fun Songs.toSongUI(id: Int): SongUI {
    return SongUI(
        id = id,
        title = title,
        lyrics = lyrics
    )
}
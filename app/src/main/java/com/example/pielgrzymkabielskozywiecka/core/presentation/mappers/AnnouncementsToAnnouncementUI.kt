package com.example.pielgrzymkabielskozywiecka.core.presentation.mappers

import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Announcements
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.AnnouncementUI

fun Announcements.toAnnouncementUI(): AnnouncementUI {
    return AnnouncementUI(
        title = title,
        text = text
    )
}
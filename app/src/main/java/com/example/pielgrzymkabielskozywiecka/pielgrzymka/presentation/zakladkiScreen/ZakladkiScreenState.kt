package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen

import com.example.pielgrzymkabielskozywiecka.core.domain.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.ZakladkiUI

data class ZakladkiScreenState(
    val zakladki: List<ZakladkiUI> = DataHolder.zakladki
)

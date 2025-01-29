package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components

import com.example.pielgrzymkabielskozywiecka.core.domain.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.BottomBarUI

data class BottomBarState(
    val buttonsList: List<BottomBarUI> = DataHolder.bottomBarButtons
)

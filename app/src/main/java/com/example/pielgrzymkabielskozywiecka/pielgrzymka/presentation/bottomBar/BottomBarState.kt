package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.BottomBarUI

data class BottomBarState(
    val buttonsList: List<BottomBarUI> = DataHolder.bottomBarButtons,
    val isVisible: Boolean = true
)

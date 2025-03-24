package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.UIModels.BottomBarUI

data class BottomBarState(
    val buttonsList: List<BottomBarUI> = DataHolder.bottomBarButtons,
    val isVisible: Boolean = true
)

package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.domain.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.BottomBarUI
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.BottomBarState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class BottomBarViewModel: ViewModel() {
    private val _state = MutableStateFlow(BottomBarState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = BottomBarState(
            buttonsList = DataHolder.bottomBarButtons
        )
    )

    fun changeButtonsState(clickedButton: BottomBarUI) {
        val temp: MutableList<BottomBarUI> = mutableListOf()
        _state.value.buttonsList.forEach{ el ->
            if (el == clickedButton)
                temp.add(el.copy(isOnFocus = true))
            else
                temp.add(el.copy(isOnFocus = false))
        }

        _state.update { it.copy(buttonsList = temp) }
    }
}
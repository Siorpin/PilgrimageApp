package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.core.presentation.UIModels.BottomBarUI
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

    fun updateViewModel(route: String?) {
        when(route) {
            Screen.HOME.name -> {
                toggleVisible(true)
                changeButtonsState(0)
            }
            Screen.ZAKLADKI.name -> {
                toggleVisible(true)
                changeButtonsState(1)
            }
            Screen.DUCHOWI.name -> {
                toggleVisible(true)
                changeButtonsState(2)
            }
            else -> {
                toggleVisible(false)
            }
        }
    }

    private fun changeButtonsState(clickedButtonIndex: Int) {
        if (
            _state.value.buttonsList.find {
                it == _state.value.buttonsList[clickedButtonIndex].copy(isOnFocus = true)
            } != null
            )
        {
            return
        }

        val temp: MutableList<BottomBarUI> = mutableListOf()
        _state.value.buttonsList.forEach{ el ->
            if (el ==  _state.value.buttonsList[clickedButtonIndex])
                temp.add(el.copy(isOnFocus = true))
            else
                temp.add(el.copy(isOnFocus = false))
        }

        _state.update { it.copy(buttonsList = temp) }
    }

    private fun toggleVisible(toVisible: Boolean) {
        if (toVisible) _state.update { it.copy(isVisible = true) }
        else _state.update { it.copy(isVisible = false) }
    }
}
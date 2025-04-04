package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen

import android.icu.util.Calendar
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update


class RosaryScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(RosaryScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        initialValue = RosaryScreenState(),
        started = SharingStarted.WhileSubscribed(5000)
    )
    init {
        getCurrentDay()
        setTodayMystery()
    }

    private fun getCurrentDay() {
        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        _state.update { it.copy(currentDay = currentDay) }
    }

    private fun setTodayMystery() {
        when(_state.value.currentDay) {
            2, 7 -> {} // radosne
            5 -> {} // swiatla
            3, 6 -> {} // bolesne
            1, 4 -> {} // chwalebne
        }
    }
}
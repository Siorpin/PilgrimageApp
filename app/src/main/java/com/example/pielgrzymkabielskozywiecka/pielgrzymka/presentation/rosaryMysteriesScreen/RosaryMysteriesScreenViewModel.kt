package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryMysteriesScreen

import android.icu.util.Calendar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pielgrzymkabielskozywiecka.core.presentation.enumClasses.Days
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update


class RosaryMysteriesScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(RosaryMysteriesScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        initialValue = RosaryMysteriesScreenState(),
        started = SharingStarted.WhileSubscribed(5000)
    )
    init {
        getCurrentDay()
        setTodayMystery()
        swapMysteries()
    }

    private fun getCurrentDay() {
        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        _state.update { it.copy(currentDay = when(currentDay) {
            1 -> Days.SUNDAY
            2 -> Days.MONDAY
            3 -> Days.TUESDAY
            4 -> Days.WEDNESDAY
            5 -> Days.THURSDAY
            6 -> Days.FRIDAY
            7 -> Days.SATURDAY
            else -> Days.MONDAY
        }) }
    }

    private fun setTodayMystery() {
        _state.value.mysteries.forEach { mystery ->
            if (mystery.days.contains(_state.value.currentDay)) {
                _state.update { it.copy(
                    primaryMystery = mystery
                ) }
            }
        }
    }

    private fun swapMysteries() {
        val tempList = _state.value.mysteries.toMutableList()
        _state.value.mysteries.forEach { mystery ->
            if (mystery == _state.value.primaryMystery) {
                tempList[0] = mystery
                tempList[_state.value.mysteries.indexOf(mystery)] = _state.value.mysteries[0]

                _state.update { it.copy(mysteries = tempList) }
                return
            }
        }
    }
}
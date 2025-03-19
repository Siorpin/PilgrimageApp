package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen

import android.icu.util.Calendar
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn


class RosaryScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(RosaryScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        initialValue = RosaryScreenState(),
        started = SharingStarted.WhileSubscribed(5000)
    )
    val date = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    init {
        Log.d("date", date.toString())
    }
}
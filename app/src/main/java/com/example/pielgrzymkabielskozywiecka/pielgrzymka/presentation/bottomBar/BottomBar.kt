package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.BottomNavButton
import com.example.pielgrzymkabielskozywiecka.core.presentation.BottomBarUI

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: BottomBarViewModel = viewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()

    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(
            topEnd = 16.dp,
            topStart = 16.dp
        ),
        modifier = modifier
            .height(80.dp)
            .fillMaxWidth()
    ) {
        LazyRow (
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 15.dp,
                    horizontal = 30.dp
                )
        ) {
            items(state.value.buttonsList) { button ->
                BottomNavButton(button){
                    navController.navigate(button.screen.name)
                    viewModel.changeButtonsState(button)
                }
            }
        }
    }
}
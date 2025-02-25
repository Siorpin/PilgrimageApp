package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.BottomNavButton

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val viewModel: BottomBarViewModel = viewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()

    viewModel.updateViewModel(backStackEntry?.destination?.route)

    AnimatedVisibility(
        visible = state.value.isVisible,
        enter = slideInVertically { it },
        exit = slideOutVertically { it }
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(
                topEnd = 16.dp,
                topStart = 16.dp
            ),
            modifier = modifier
                .shadow(
                    elevation = 16.dp,
                    ambientColor = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(
                        topEnd = 16.dp,
                        topStart = 16.dp
                    )
                )
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
                    }
                }
            }
        }
    }
}
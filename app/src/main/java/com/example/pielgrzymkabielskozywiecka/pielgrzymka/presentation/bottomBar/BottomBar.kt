package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.BottomNavButton

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: BottomBarViewModel = viewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()

    Surface(
        color = Color(0xfffdfdfd),
        shape = RoundedCornerShape(
            topEnd = 16.dp,
            topStart = 16.dp
        ),
        modifier = modifier
            .shadow(
                elevation = 16.dp,
                ambientColor = Color(0xFF83B9F8),
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
                    viewModel.changeButtonsState(button)
                }
            }
        }
    }
}
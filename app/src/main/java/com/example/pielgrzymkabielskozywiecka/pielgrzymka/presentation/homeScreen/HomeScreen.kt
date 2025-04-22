package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.AnnouncementsBox
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.HelloSegment
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.OptionsRow
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.TopBar
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.PopUp

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: HomeScreenViewModel = viewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(
                        topEnd = 16.dp,
                        topStart = 16.dp
                    )
                )
        ) {
            TopBar()
            HelloSegment()
            AnnouncementsBox(
                title = state.value.title,
                text = state.value.ogloszeniaText,
                refreshDataFunction = { viewModel.refreshData() }
            )
            OptionsRow(viewModel, navController)
        }
        PopUp(
            activated = state.value.popUpVisible,
            onBackgroundTap = { viewModel.togglePopUp() }
        ) {
            Text("no elo elo")
        }
    }
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen.components.MysteryBox
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar
import com.example.pielgrzymkabielskozywiecka.ui.theme.PielgrzymkaAppTheme

@Composable
fun RosaryScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: RosaryScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val pagerState = rememberPagerState(pageCount = {
        state.mysteries.size
    })
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        SecondaryScreenTopBar(
            name = "Tajemnice różańca",
            navController = navController
        )
        VerticalPager(
            state = pagerState
        ) { page ->
            MysteryBox(
                mysteryUI = state.mysteries[page],
                isTodaysMystery = page == 0,
                onClick = {}
            )
        }

    }

}

@PreviewLightDark
@Composable
fun RosaryScreenPreview(modifier: Modifier = Modifier) {
    PielgrzymkaAppTheme {
        RosaryScreen(
            navController = rememberNavController()
        )
    }
}
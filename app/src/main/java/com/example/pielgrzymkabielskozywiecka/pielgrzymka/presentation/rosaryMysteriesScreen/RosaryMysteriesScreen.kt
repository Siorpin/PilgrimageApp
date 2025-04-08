package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryMysteriesScreen

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
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryMysteriesScreen.components.MysteryBox
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar
import com.example.pielgrzymkabielskozywiecka.ui.theme.PielgrzymkaAppTheme

@Composable
fun RosaryMysteriesScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: RosaryMysteriesScreenViewModel = viewModel()
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
                onClick = { navController.navigate("${Screen.MYSTERY}/${state.mysteries[page].title}") }
            )
        }

    }

}

@PreviewLightDark
@Composable
fun RosaryScreenPreview(modifier: Modifier = Modifier) {
    PielgrzymkaAppTheme {
        RosaryMysteriesScreen(
            navController = rememberNavController()
        )
    }
}
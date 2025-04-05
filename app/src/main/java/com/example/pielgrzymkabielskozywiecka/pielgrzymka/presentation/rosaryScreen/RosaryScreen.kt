package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen.components.MysteryBox
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen.components.TodayMysteryBox
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
        state.secondaryMystery.size
    })

    VerticalPager(
        state = pagerState
    ) { page ->
        MysteryBox(state.secondaryMystery[page])
    }
}

@PreviewLightDark
@Composable
fun RosaryScreenPreveiw(modifier: Modifier = Modifier) {
    PielgrzymkaAppTheme {
        RosaryScreen(
            navController = rememberNavController()
        )
    }
}
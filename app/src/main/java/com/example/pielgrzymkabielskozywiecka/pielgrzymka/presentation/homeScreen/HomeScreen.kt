package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.AnnouncementsBox
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.HelloSegment
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.TopBar

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF4F7FC),
                shape = RoundedCornerShape(
                    topEnd = 16.dp,
                    topStart = 16.dp
                )
            )
    ) {
        TopBar()
        HelloSegment()
        AnnouncementsBox()
    }
}
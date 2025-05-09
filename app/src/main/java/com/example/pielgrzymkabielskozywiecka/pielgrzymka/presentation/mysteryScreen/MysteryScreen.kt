package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.mysteryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.RosaryMysteryUI
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun MysteryScreen(
    mysteryUI: RosaryMysteryUI?,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (mysteryUI != null) {
            SecondaryScreenTopBar(
                name = mysteryUI.title,
                navController = navController
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = rememberScrollState())
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(mysteryUI.text),
                    fontFamily = Poppins,
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}
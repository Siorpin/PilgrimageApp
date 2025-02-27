package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.R
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.components.DuchowiHeader
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.components.DuchowiText

@Composable
fun DuchowiScreen(
    nacController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(
                20.dp
            )
    ) {
        DuchowiHeader(text = "Pielgrzymi duchowi")
        DuchowiText(text = stringResource(R.string.duchowi_text))
    }
}

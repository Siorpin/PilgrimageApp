package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.RosaryMysteryUI
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun TodayMysteryBox(
    mysteryUI: RosaryMysteryUI,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Dzisiejsza tajemnica",
            fontFamily = Poppins,
            fontSize = 20.sp
        )
        Card(
            onClick = { TODO() }
        ) {

        }
    }
}
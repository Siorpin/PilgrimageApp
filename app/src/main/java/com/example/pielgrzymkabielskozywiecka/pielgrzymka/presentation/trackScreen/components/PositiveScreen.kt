package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.TrackUI
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun PositiveScreen(
    trackUI: TrackUI,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Text(
                text = "Pielgrzymka nie jest łatwa... W trakcie tej duchowej drogi należy nie zapominać o modlitwie i bliskości z Panem Bogiem. Warto też zdawać sobie sprawę z tego, jak daleko zaszliśmy",
                lineHeight = 24.sp,
                fontSize = 22.sp,
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(14.dp)
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Dzień: ${trackUI.day}",
            lineHeight = 26.sp,
            fontSize = 24.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Gdzie jesteśmy: ${trackUI.currentStop.name}",
            lineHeight = 26.sp,
            fontSize = 24.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(30.dp))
        if (trackUI.nextStop != null) {
            Text(
                text = "Następny postój: ${trackUI.nextStop.name}",
                lineHeight = 26.sp,
                fontSize = 24.sp,
                fontFamily = Poppins,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
        Text(
            text = "Postęp dzisiaj:",
            lineHeight = 26.sp,
            fontSize = 24.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Left
        )
        ProgressBar(
            percentage = trackUI.percentage,
            color = MaterialTheme.colorScheme.primary,
            textColor = if(trackUI.percentage < 60) {
                MaterialTheme.colorScheme.outline
            } else MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Postęp całej trasy:",
            lineHeight = 26.sp,
            fontSize = 24.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Left
        )
        ProgressBar(
            percentage = trackUI.overallPercentage,
            color = MaterialTheme.colorScheme.primary,
            textColor = if(trackUI.overallPercentage < 50) {
                MaterialTheme.colorScheme.outline
            } else MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(DataHolder.overallBottomPadding))
    }
}
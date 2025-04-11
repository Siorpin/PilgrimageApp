package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.rosaryMysteriesScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.RosaryMysteryUI
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun MysteryBox(
    mysteryUI: RosaryMysteryUI,
    isTodaysMystery: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            2.dp
        ),
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 40.dp,
                vertical = 80.dp
            ).clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(mysteryUI.background),
                contentDescription = stringResource(mysteryUI.text),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f))
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = 60.dp,
                        horizontal = 20.dp
                    )
            ) {
                if (isTodaysMystery) {
                    Text(
                        text = "Różaniec na dziś",
                        fontFamily = Poppins,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Light,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 38.sp,
                    )
                }
                Text(
                    text = mysteryUI.title,
                    fontFamily = Poppins,
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 38.sp
                )
            }
        }
    }
}
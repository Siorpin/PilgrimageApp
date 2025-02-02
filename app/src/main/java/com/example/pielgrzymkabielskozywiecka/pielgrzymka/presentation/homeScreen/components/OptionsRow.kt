package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun OptionsRow(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        HeaderText("Warto zobaczyć")
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
        ) {
            OptionButton(
                buttonText = "Galeria",
                color = Color(0xFFA6AAF3),
                onClick = {},
                modifier = Modifier
                    .weight(1f)
            )
            OptionButton(
                buttonText = "Strona internetowa",
                color = Color(0xFFC4C5FF),
                onClick = {},
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}
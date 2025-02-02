package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun OptionsRow(
    navHost: NavHostController,
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
                onClick = { navHost.navigate("") }, //TODO
                modifier = Modifier
                    .weight(1f)
            )
            OptionButton(
                buttonText = "Strona internetowa",
                color = Color(0xFFC4C5FF),
                onClick = { navHost.navigate("") }, //TODO
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.OptionButton

@Composable
fun OptionsRow(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        HeaderText("Warto zobaczyć")
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
        ) {
            OptionButton(
                buttonText = "Trasa",
                color = MaterialTheme.colorScheme.tertiary,
                onClick = { navController.navigate(Screen.TRACK.name) },
                modifier = Modifier
                    .weight(1f)
            )
            OptionButton(
                buttonText = "Media społecznościowe",
                color = MaterialTheme.colorScheme.secondary,
                onClick = {  },
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}
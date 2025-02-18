package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.authorsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AuthorsScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("back")
        }
        Text("Aplikację stworzył Kuba Sierpień")
    }
}
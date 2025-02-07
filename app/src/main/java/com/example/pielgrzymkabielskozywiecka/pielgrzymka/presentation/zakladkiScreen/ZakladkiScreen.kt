package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun ZakladkiScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: ZakladkiScreenViewModel = viewModel()

    LazyColumn(

    ) {
        items(viewModel.state.value.zakladki) { it ->

        }
    }
}
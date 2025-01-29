package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.core.domain.DataHolder
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components.OptionButton

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.FixedSize(170.dp),
        verticalArrangement = Arrangement.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 4.dp),
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        items(DataHolder.roots) { item ->
            OptionButton(
                item,
                onClick = { destination -> navController.navigate(destination) }
            )
        }
    }
}
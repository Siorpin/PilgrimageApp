package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun SongScreen(
    title: String?,
    lyrics: String?,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (title != null && lyrics != null) {
            SecondaryScreenTopBar(
                name = title,
                navController = navController
            )
            Text(
                text = lyrics,
                fontFamily = Poppins,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }
}
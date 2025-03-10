package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.authorsScreen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun AuthorsText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontFamily = Poppins,
        fontSize = 20.sp,
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    )
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun ZakladkiHeader(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .height(40.dp)
    ) {
        Text(
            text = "Zakładki",
            fontFamily = Poppins,
            fontWeight = FontWeight.W500,
            fontSize = 36.sp
        )
    }
}
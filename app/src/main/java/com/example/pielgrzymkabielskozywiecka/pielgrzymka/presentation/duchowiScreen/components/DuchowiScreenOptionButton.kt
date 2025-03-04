package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins
import androidx.compose.ui.unit.sp

@Composable
fun DuchowiScreenOptionButton(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = name,
            fontFamily = Poppins,
            fontSize = 16.sp
        )
    }
}
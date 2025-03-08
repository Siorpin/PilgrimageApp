package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun OptionButton(
    buttonText: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .height(50.dp)
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        modifier = modifier
            .fillMaxHeight()
    ) {
        Text(
            text = buttonText,
            fontFamily = Poppins,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}
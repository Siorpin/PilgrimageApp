package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins
import kotlinx.coroutines.coroutineScope
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OptionButton(
    buttonText: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    var isButtonEnabled by remember {
        mutableStateOf(true) }

    Button(
        onClick = {
            if(isButtonEnabled) {
                coroutineScope.launch{
                    isButtonEnabled = false
                    onClick()
                    delay(400)
                    isButtonEnabled = true
                }
            } },
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
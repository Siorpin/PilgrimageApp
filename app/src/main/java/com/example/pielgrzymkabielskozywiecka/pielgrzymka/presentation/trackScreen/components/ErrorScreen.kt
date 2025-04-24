package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.trackScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.pielgrzymkabielskozywiecka.R
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.OptionButton
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun ErrorScreen(
    errorMessage: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 20.dp, end = 20.dp, bottom = 200.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.error),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "Coś poszło nie tak...",
            lineHeight = 30.sp,
            fontSize = 28.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Center
        )
        Text(
            text = errorMessage,
            lineHeight = 18.sp,
            fontSize = 16.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(100.dp))
        OptionButton(
            onClick = { onButtonClick() },
            color = MaterialTheme.colorScheme.secondary,
            buttonText = "Odśwież",
            modifier = Modifier
                .height(70.dp)
                .width(140.dp)
        )
    }
}
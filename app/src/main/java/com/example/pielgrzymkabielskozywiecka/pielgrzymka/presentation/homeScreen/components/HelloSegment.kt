package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.R
import com.example.pielgrzymkabielskozywiecka.ui.theme.Montserrat
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun HelloSegment(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo_white),
            colorFilter = ColorFilter.tint(Color(0xFFA5CDFD)),
            contentDescription = "logo",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(150.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.CenterStart)
        ) {
            Text(
                text = "Witaj pielgrzymie!",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )
            Text(
                text = "Miłego dnia",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                fontFamily = Poppins,
                fontStyle = FontStyle.Italic,
                color = Color.Gray
            )
        }

    }
}
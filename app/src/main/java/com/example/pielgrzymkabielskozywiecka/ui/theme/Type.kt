package com.example.pielgrzymkabielskozywiecka.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.pielgrzymkabielskozywiecka.R

val AppTypography = Typography()

val Poppins = FontFamily(
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light)
)

val Montserrat = FontFamily(
    Font(
        resId = R.font.montserrat,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.montserrat_italic,
        style = FontStyle.Italic
    )
)

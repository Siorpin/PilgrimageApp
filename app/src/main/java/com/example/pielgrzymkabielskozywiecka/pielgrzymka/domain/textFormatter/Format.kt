package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.textFormatter

import androidx.compose.ui.text.TextStyle

/*
* text - text given for formatting
*
* formatSymbol - marker starting and ending this format style
*/
interface Format {
    val formatSymbol: Char
    fun formatText(text: String): TextStyle
}
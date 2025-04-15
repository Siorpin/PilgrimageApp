package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.textFormatter.formats

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.textFormatter.Format

class Bold: Format {
    override val formatSymbol: Char = 'b'

    override fun formatText(text: String): TextStyle {
        return TextStyle(
            fontWeight = FontWeight.Bold
        )
    }
}
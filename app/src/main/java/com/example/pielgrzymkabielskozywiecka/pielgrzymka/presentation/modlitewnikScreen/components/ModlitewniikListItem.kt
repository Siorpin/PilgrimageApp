package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.modlitewnikScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.ModlitwyResponse
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun ModlitewnikListItem(
    id: Int,
    modlitwa: ModlitwyResponse,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var enabled by remember{ mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(MaterialTheme.colorScheme.surface)
            .shadow(
                elevation = 1.dp,
                spotColor = MaterialTheme.colorScheme.onBackground
            )
            .clickable(enabled) {
                onClick()
                enabled = false
            }
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "${id}.",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            text = modlitwa.title,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    }
}
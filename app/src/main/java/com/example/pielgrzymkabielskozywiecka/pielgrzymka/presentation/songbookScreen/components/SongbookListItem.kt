package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.songbookScreen.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.ModlitwyResponse
import com.example.pielgrzymkabielskozywiecka.core.data.networking.responses.SongsResponse
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun SongbookListItem(
    song: SongsResponse,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
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
            .clickable { onClick() }
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "${song.id}.",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            text = song.title,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    }
}
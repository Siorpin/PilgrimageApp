package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.core.presentation.ZakladkiUI
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun ZakladkiListItem(
    zakladkiUI: ZakladkiUI,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(20.dp)
                .clickable { onClick() }
        ) {
            Text(
                text = zakladkiUI.name,
                fontFamily = Poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400
            )
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 2.dp,
            modifier = Modifier
                .padding(end = 20.dp)
        )
    }
}
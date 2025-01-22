package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.topAppBar

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    isHidden: Boolean = false
) {
    val height by animateDpAsState(
        if (isHidden) 0.dp else 80.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.Unspecified,
                shape = RoundedCornerShape(
                    bottomEnd = 60.dp,
                    bottomStart = 60.dp
                )
            )
            .height(height),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text("Test")
            }
        }
    )
}
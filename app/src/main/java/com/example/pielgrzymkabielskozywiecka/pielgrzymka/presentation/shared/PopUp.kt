package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared

import android.util.Size
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun PopUp(
    activated: Boolean,
    modifier: Modifier = Modifier,
    onBackgroundTap: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(if (activated) 1f else 0f)
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.9f))
            .pointerInput(Unit) { onBackgroundTap() }
    ) {
        AnimatedVisibility(
            visible = activated,
            enter = scaleIn(),
            exit = shrinkOut(),
            modifier = modifier
                .fillMaxSize()
                .pointerInput(Unit){}
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(
                        vertical = 200.dp,
                        horizontal = 40.dp
                    )
                    .fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    content()
                }
            }
        }
    }
}
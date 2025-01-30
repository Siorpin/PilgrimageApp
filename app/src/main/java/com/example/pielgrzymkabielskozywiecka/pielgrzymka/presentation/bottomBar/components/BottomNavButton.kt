package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.core.presentation.BottomBarUI

@Composable
fun BottomNavButton(
    bottomBarUI: BottomBarUI,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val aspectRatio by animateFloatAsState(
        targetValue = if (bottomBarUI.isOnFocus) 3f else 1f,
        animationSpec = tween(400),
        label = "Expand/Shrink button animation"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures { onClick() }
            }
            .background(
                color = if(bottomBarUI.isOnFocus) (Color(0xFFA5CDFD))
                    else Color(0xFFA5CDFD),
                shape = RoundedCornerShape(45.dp)
            )
            .fillMaxHeight()
            .aspectRatio(aspectRatio)
            .animateContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Icon(
                imageVector = bottomBarUI.icon,
                contentDescription = null,
                tint = Color(0xfffdfdfd)
            )
            AnimatedVisibility(
                visible = bottomBarUI.isOnFocus,
                enter = scaleIn(tween(400)) + expandVertically(expandFrom = Alignment. CenterVertically),
                exit = shrinkOut()
            ) {
                Text(
                    text = bottomBarUI.name,
                    color = Color.Black
                )
            }
        }
    }
}
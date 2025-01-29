package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.components.bottomNavShape.OnFocusCanvas
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.bottomBar.models.BottomBarUI

@Composable
fun BottomNavButton(
    bottomBarUI: BottomBarUI,
    modifier: Modifier = Modifier
) {
    var enable by remember { mutableStateOf(false) }
    var sizePx by remember { mutableStateOf(IntSize.Zero) }
    val aspectRatio by animateFloatAsState(if (bottomBarUI.isOnFocus) 3f else 1f)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable { bottomBarUI.onClick() }
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(45.dp)
            )
            .fillMaxHeight()
            .aspectRatio(aspectRatio)
            .animateContentSize()
           // .onSizeChanged { sizePx = it }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Icon(
                imageVector = bottomBarUI.icon,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    //.clickable { enable = !enable }
                    .onSizeChanged { sizePx = it }
            )
            AnimatedVisibility(
                visible = bottomBarUI.isOnFocus,
                //enter = ,
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
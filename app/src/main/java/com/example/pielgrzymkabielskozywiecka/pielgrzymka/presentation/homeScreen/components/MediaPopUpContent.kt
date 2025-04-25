package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pielgrzymkabielskozywiecka.R
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler.mediaStarters.FacebookStarter
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler.mediaStarters.InstagramStarter
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler.mediaStarters.TikTokStarter
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun MediaPopUpContent(
    modifier: Modifier = Modifier
) {
    val content = LocalContext.current
    val facebook = FacebookStarter()
    val instagram = InstagramStarter()
    val tikTok = TikTokStarter()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Nasze media społecznościowe",
            fontFamily = Poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 20.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                ImageLink(R.drawable.facebook, Modifier.weight(1f)) {
                    facebook.startActivity(context = content)
                }
                ImageLink(R.drawable.instagram, Modifier.weight(1f)) {
                    instagram.startActivity(context = content)
                }
                ImageLink(R.drawable.tiktok, Modifier.weight(1f)) {
                    tikTok.startActivity(context = content)
                }
            }
        }
    }
}

@Composable
fun ImageLink(
    image: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}
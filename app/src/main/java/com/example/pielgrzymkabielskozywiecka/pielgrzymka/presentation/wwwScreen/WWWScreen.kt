package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.wwwScreen

import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryScreenTopBar

@Composable
fun WWWScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
    ) {
        SecondaryScreenTopBar(
            name = "",
            navController = navController
        )
        WebPage(url = "https://pielgrzymka.bielsko.pl/")
    }
}

@Composable
fun WebPage(url: String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                loadUrl(url)
            }
        }
    )
}

package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.R
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler.WWWActivityStarter
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.ActivityError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen.components.ZakladkiHeader
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.zakladkiScreen.components.ZakladkiListItem
import disableSplitMotionEvents

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun ZakladkiScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: ZakladkiScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val handler = LocalUriHandler.current
    val uri = "https://pielgrzymka.bielsko.pl/"
    val wwwStarter = WWWActivityStarter(handler, uri)
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.bird_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 0.4f,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp)
        ) {
            ZakladkiHeader()
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(
                modifier = Modifier
                    .disableSplitMotionEvents()
            ) {
                items(state.zakladki) {
                    if (it.name == "Strona internetowa") {
                        ZakladkiListItem(
                            zakladkiUI = it,
                            onClick = {
                                val result = wwwStarter.startActivity(context)

                                if (result is Result.Error) {
                                    val toastMessage = when(result.error) {
                                        ActivityError.Execution.ACTIVITY_NOT_FOUND -> "Nie znaleziono przeglądarki!"
                                        ActivityError.Execution.UNKNOWN -> "Wystąpił nieznany błąd!"
                                    }

                                    Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
                                }
                            }
                        )
                    }
                    else {
                        ZakladkiListItem(
                            zakladkiUI = it,
                            onClick = {
                                navController.navigate(it.destination.name)
                            }
                        )
                    }
                }
            }
        }
    }
}
package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.core.navigation.Screen
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.activityHandler.EmailHandler
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.duchowiScreen.DuchowiScreenViewModel
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.OptionButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ButtonsBox(
    navHostController: NavHostController,
    viewModel: DuchowiScreenViewModel,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .size(100.dp)
            .padding(6.dp)
    ) {
        val context = LocalContext.current
        val emailHandler = EmailHandler(
            subject = "Intencje na pielgrzymkę na Jasną Górę",
            text = "Szczęść Boże. Piszę z prośbą o modlitwę na pielgrzymce w intencji:\n\n",
            receiver = "kubasierpien05@gmail.com"
        )

        OptionButton(
            buttonText = "Konferencje",
            color = Color(0xFFA6AAF3),
            onClick = { navHostController.navigate(Screen.CONFERENCES.name) },
            modifier = Modifier
                .weight(1f)
        )
        OptionButton(
            buttonText = "Wyślij intencje",
            color = Color(0xFFC4C5FF),
            onClick = {
                emailHandler.sendEmail(
                    context = context
                ) {
                    scope.launch {
                        delay(500)
                        viewModel.togglePopUp()
                    }
                }
            },
            modifier = Modifier
                .weight(1f)
        )
    }
}
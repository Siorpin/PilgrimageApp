package com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pielgrzymkabielskozywiecka.R
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.ZakladkiUI
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.presentation.shared.SecondaryVerticalScreen
import com.example.pielgrzymkabielskozywiecka.ui.theme.Poppins

@Composable
fun KidsProtectionScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    SecondaryVerticalScreen(
        name = "Standardy ochrony małoletnich",
        navController = navController,
    ) {
        Column(modifier.verticalScroll(rememberScrollState())) {
            Spacer(Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.kids_protection_standards),
                fontFamily = Poppins,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                modifier = modifier
                    .padding(horizontal = 20.dp)
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}
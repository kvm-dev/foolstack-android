package ru.local.screening.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.local.screening.viewModel.ScreeningViewModel
import ru.local.ui.components.BaseBox
import ru.local.ui.components.BaseText

@Composable
fun ScreeningScreen(screeningViewModel: ScreeningViewModel = viewModel()) {
    BaseBox()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BaseText(text = "Screening Screen")
        Spacer(modifier = Modifier.height(30.dp))
    }
}
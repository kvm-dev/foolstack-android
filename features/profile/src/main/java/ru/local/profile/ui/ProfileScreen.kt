package ru.local.profile.ui

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
import ru.local.profile.viewModel.ProfileViewModel
import ru.local.ui.components.BaseButton
import ru.local.ui.components.BaseText

@Composable
fun ProfileScreen(onClick: () -> Unit, profileViewModel: ProfileViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BaseText(text = "Profile Screen")
        Spacer(modifier = Modifier.height(30.dp))
        BaseButton(onClick = onClick, text = "Go to Splash Screen")
    }
}
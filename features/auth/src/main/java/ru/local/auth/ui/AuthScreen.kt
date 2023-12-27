package ru.local.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.local.ui.components.BaseButton
import ru.local.ui.components.BaseText

@Composable
    fun AuthScreen(onClick: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BaseText(text = "AuthScreen")
            Spacer(modifier = Modifier.height(30.dp))
            BaseButton(onClick = onClick, text ="GoToProfileScreen")
        }
    }
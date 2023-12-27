package ru.local.authorized.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.local.authorized.viewModel.AuthorizedViewModel
import ru.local.ui.components.AuthorizedMainScaffold

@Composable
fun AuthorizedScreen(tech: @Composable () -> Unit = {}, screening: @Composable () -> Unit = {}, tests: @Composable () -> Unit = {}, authorizedViewModel: AuthorizedViewModel = viewModel()) {
    AuthorizedMainScaffold(tech = tech, screening = screening, tests = tests)
}
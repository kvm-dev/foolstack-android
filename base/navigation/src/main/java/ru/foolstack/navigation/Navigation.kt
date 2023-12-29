package ru.foolstack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.foolstack.auth.ui.AuthScreen
import ru.foolstack.authorized.ui.AuthorizedScreen
import ru.foolstack.authorized.viewModel.AuthorizedViewModel
import ru.foolstack.screening.ui.ScreeningScreen
import ru.foolstack.splash.ui.SplashScreen
import ru.foolstack.tech.ui.TechScreen
import ru.foolstack.tests.ui.TestsScreen


@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
        NavHost(
            navController = navController,
            startDestination = "splashScreen"
        ) {
            composable("splashScreen") {
                SplashScreen(
                    onClick = { navController.navigate(route = "authScreen"){
                        popUpTo("splashScreen") {
                            inclusive = true
                        }
                    } }
                )
            }
            composable("authScreen") {
                AuthScreen(
                    onClick = { navController.navigate(route = "authorizedScreen"){
                        popUpTo("authScreen") {
                            inclusive = true
                        }
                    } },
                )
            }
            composable("authorizedScreen") {
                AuthorizedScreen(
                    tech = { TechScreen() }, screening = { ScreeningScreen() }, tests = { TestsScreen() },
                    authorizedViewModel = AuthorizedViewModel()
                )
            }
        }
}

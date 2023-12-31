package ru.foolstack.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinContext
import ru.local.navigation.AppNavGraph
import ru.local.ui.theme.FoolStackTheme
import ru.foolstack.splash.ui.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FoolStackTheme {
                KoinContext {
                AppNavGraph(navController = navController)
//                ComposeScaffold()
            }
        }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    FoolStackTheme {
        SplashScreen(onClick = ({ }))
    }
}
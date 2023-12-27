package ru.foolstack.splash.ui
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import org.koin.androidx.compose.koinViewModel
import ru.foolstack.splash.R
import ru.foolstack.splash.viewModel.SplashViewModel
import ru.local.ui.components.BigAppTitle
import ru.local.ui.components.BottomSplashScreen
import ru.local.ui.components.SplashBackground

//@Composable
//fun SplashScreen(onClick: () -> Unit, splashViewModel:  SplashViewModel = viewModel()) {
//    SplashBackground()
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        BigAppTitle("FoolStack")
////        BaseText(text = "Splash Screen", size = 30.sp)
////        Spacer(modifier = Modifier.height(30.dp))
////        BaseButton(onClick = onClick, text = "Go to Auth Screen")
//        val bitmap = ImageBitmap.imageResource(ru.foolstack.splash.R.drawable.splash_img)
////        BottomSplashScreen(bitmap, onClick, onClick)
//    }
////    val (isVisible, setVisible) = remember { mutableStateOf(true) }
////    SimpleSnackbar(isVisible = isVisible, message = "Jetpack Compose Snackbar Demo")
//    //https://androidwave.com/how-to-create-the-snackbar-in-jetpack-compose/
//}

@Composable
fun SplashScreen(onClick: () -> Unit, splashViewModel: SplashViewModel = koinViewModel()) {
    SplashBackground()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BigAppTitle("FoolStack")
//        BaseText(text = "Splash Screen", size = 30.sp)
//        Spacer(modifier = Modifier.height(30.dp))
//        BaseButton(onClick = onClick, text = "Go to Auth Screen")
        if(splashViewModel.getLocal()=="RU"){
            val bitmap = ImageBitmap.imageResource(R.drawable.splash_img)
        BottomSplashScreen(bitmap, onClick, onClick)
        }
    }
    Log.d("что с коннектом", "${splashViewModel.getNetworkStatus()}")
    Log.d("что там", "${splashViewModel.getLocal()}")
//    val (isVisible, setVisible) = remember { mutableStateOf(true) }
//    SimpleSnackbar(isVisible = isVisible, message = "Jetpack Compose Snackbar Demo")
    //https://androidwave.com/how-to-create-the-snackbar-in-jetpack-compose/
}
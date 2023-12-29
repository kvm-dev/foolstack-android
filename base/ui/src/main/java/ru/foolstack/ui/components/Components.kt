package ru.foolstack.ui.components

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.foolstack.ui.R
import ru.foolstack.ui.ext.bounceClick
import ru.foolstack.ui.theme.BaseText
import ru.foolstack.ui.theme.BottomScreenBackground
import ru.foolstack.ui.theme.DisabledButtonContent
import ru.foolstack.ui.theme.DisabledColor
import ru.foolstack.ui.theme.EnabledButtonContent
import ru.foolstack.ui.theme.EnabledButtonFirstBackground
import ru.foolstack.ui.theme.EnabledButtonSecondBackground
import ru.foolstack.ui.theme.FoolStackTheme
import ru.foolstack.ui.theme.GradientColorSplash0
import ru.foolstack.ui.theme.GradientColorSplash2
import ru.foolstack.ui.theme.MainGreen
import ru.foolstack.ui.theme.MainOrange
import ru.foolstack.ui.theme.oswaldSansFamily

@Composable
fun BaseButton(onClick: () -> Unit, text: String){
    Button(
        onClick = {
            onClick()
        }
    ) {
        Text(text = text)
    }
}

@Composable
fun BaseBox(){
    FoolStackTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.MainGreen))
    }
}

@Composable
fun SplashBackground(){
    FoolStackTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition")
        val offset by infiniteTransition.animateFloat(
            initialValue = 200f,
            targetValue = 4000f,
            animationSpec = infiniteRepeatable(tween(30*1000, easing = LinearOutSlowInEasing)), label = "splashOffset"
        )

        val gradients = listOf(MaterialTheme.colorScheme.GradientColorSplash0, MaterialTheme.colorScheme.GradientColorSplash2)
        val brush = Brush.linearGradient(
            gradients,
            start = Offset(offset, offset),
            end = Offset(offset + 1000f, offset + 1000f),
            tileMode = TileMode.Mirror
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = brush)
         )
    }
}

@Composable
fun BottomSplashScreen(bitmap:ImageBitmap, onclickLogin: ()->Unit, onclickGuest: ()->Unit){
    var offset by remember { mutableFloatStateOf(0f) }
    var isAnimated by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isAnimated, label = "transition")
    val bottomHeight by transition.animateDp(transitionSpec = {
        tween(3*1000)
    }, "") { animated ->
        if (!animated) 0.dp else 1000.dp
    }
    val shape = RoundedCornerShape(32.dp, 32.dp)
    Column(modifier = Modifier
        .fillMaxSize()
        .scrollable(
            orientation = Orientation.Vertical,
            state = rememberScrollableState { delta ->
                offset += delta
                delta
            }
        ),
        verticalArrangement = Arrangement.Bottom) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(bottomHeight)
                    //                               .wrapContentSize()
                    .clip(shape)
                    .background(MaterialTheme.colorScheme.BottomScreenBackground),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(110.dp, 10.dp),
                    bitmap = bitmap,
                    contentDescription = "FoolStack"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Title(text = "Поможем найти работу")
                Spacer(modifier = Modifier.height(10.dp))
                BaseText(text = "Техническое собеседование или скрининг с HR? - Поможем подготовиться.\n\nНе хватает практики? Проверь себя в наших тестовых заданиях и получи обратную связь.")
                Spacer(modifier = Modifier.weight(1f))
                GeneralButton(onClickLogin = { /*TODO*/ }, text = "Войти в АЙТИ")
                SplashGuestButton("Войти как гость", onClickGuest = { /*TODO*/ })
            }
    }

    val timer = object : CountDownTimer(1000, 500) {
        override fun onTick(seconds: Long) {
            isAnimated = true
            cancel()
        }
        override fun onFinish() {
            cancel()
        }
    }
    timer.start()
    }

//bottom navigation bar

enum class BottomIcons {
    TECH, HR, TESTS
}

@Composable
fun BottomAppBarCompose(selectedState: MutableState<BottomIcons>) {
    BottomAppBar(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(32.dp, 32.dp, 0.dp, 0.dp)), containerColor = MaterialTheme.colorScheme.MainGreen,
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row() {
                    IconButton(
                        onClick = {
                            selectedState.value = BottomIcons.HR
                    }) {
                        val icon = painterResource(id = R.drawable.hr_interview)
                        Icon(
                            painter = icon,
                            contentDescription = null,
                            tint = if (selectedState.value == BottomIcons.HR) MaterialTheme.colorScheme.MainOrange else MaterialTheme.colorScheme.DisabledColor
                        )
                    }
                }
                Row() {
                    IconButton(onClick = {
                        selectedState.value = BottomIcons.TESTS
                    }) {
                        val icon = painterResource(id = R.drawable.tests)
                        Icon(
                            painter = icon,
                            contentDescription = null,
                            tint = if (selectedState.value == BottomIcons.TESTS) MaterialTheme.colorScheme.MainOrange else MaterialTheme.colorScheme.DisabledColor
                        )
                    }
                }
            }
        })
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
    fun AuthorizedMainScaffold(tech: @Composable () -> Unit = {}, screening: @Composable () -> Unit = {}, tests: @Composable () -> Unit = {}) {
    val selected = remember { mutableStateOf(BottomIcons.TECH) }
//    val context = LocalContext.current
    Scaffold(bottomBar = { BottomAppBarCompose(selected) },
        floatingActionButton = { FabCompose(selected) },
        floatingActionButtonPosition = FabPosition.Center,
        content = {
        // Add Main UI
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.background)
        ) {
            when(selected.value){
                BottomIcons.TECH-> tech()
                BottomIcons.HR-> screening()
                BottomIcons.TESTS-> tests()
            }
        }
    }
    )
}
//fun makeToast(ctx: Context, msg: String) {
//    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
//}
@Composable
fun FabCompose(selectedState: MutableState<BottomIcons>) {
    FloatingActionButton(
        modifier = Modifier
            .size(64.dp)
            .offset(y = 50.dp)
            .border(
                width = 3.dp,
                color = MaterialTheme.colorScheme.MainGreen,
                shape = RoundedCornerShape(50.dp)
            ),
        interactionSource = remember { MutableInteractionSource() },
        shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 100)),
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = Color.Black,
        //elevation = FloatingActionButtonDefaults.elevation(),
        onClick = {
            selectedState.value = BottomIcons.TECH
        },
    ) {
        val icon = painterResource(id = R.drawable.tech_interview)
        Icon(painter = icon, contentDescription = null,
            tint = if (selectedState.value == BottomIcons.TECH) MaterialTheme.colorScheme.MainOrange else MaterialTheme.colorScheme.DisabledColor)
    }
}

@Composable
fun BigAppTitle(text: String){
    var visible by remember {
        mutableStateOf(false)
    }
    val animatedAlpha by animateFloatAsState(
        targetValue = if (visible) 1.0f else 0f,
        animationSpec = (tween(1000*3)),
        label = "applicationTitle"
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 60.dp)
            .graphicsLayer {
                alpha = animatedAlpha
            }
            .clip(RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = text, fontFamily = oswaldSansFamily, fontWeight = FontWeight.Bold, style = TextStyle(
            fontSize = 32.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
        ))
    }
    val timer = object : CountDownTimer(5000, 500) {
        override fun onTick(seconds: Long) {
            visible = true
            cancel()
        }
        override fun onFinish() {
            cancel()
        }
    }
    timer.start()
}

@Composable
fun Title(text: String){
    Text(modifier = Modifier,
        text =text, fontFamily = oswaldSansFamily, fontWeight = FontWeight.Normal, style = TextStyle(
        fontSize = 22.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
    ))
}

@Composable
fun BaseText(text: String){
    Text(modifier = Modifier.padding(vertical = 12.dp, horizontal = 38.dp), text =text, fontFamily = oswaldSansFamily, fontWeight = FontWeight.Normal, style = TextStyle(
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.BaseText,
            textAlign = TextAlign.Center
        ))
}

@Composable
fun GeneralButton(
    text: String,
    onClickLogin: () -> Unit = { },
) {
    val shape = RoundedCornerShape(5.dp)
    val gradient = Brush.verticalGradient(listOf(MaterialTheme.colorScheme.EnabledButtonFirstBackground, MaterialTheme.colorScheme.EnabledButtonSecondBackground))
    val modifier = Modifier
        .background(Color.Transparent)
        .padding(horizontal = 16.dp)
        .clip(shape)
        .bounceClick()
        .fillMaxWidth()
    Button(
        modifier = modifier
            .padding(horizontal = 0.dp)
            .then(modifier),
        shape = shape,
        colors = ButtonColors(containerColor = Color.Transparent, contentColor = MaterialTheme.colorScheme.EnabledButtonContent, disabledContainerColor = Color.Transparent, disabledContentColor = MaterialTheme.colorScheme.DisabledButtonContent),
        onClick = { onClickLogin() },
    ) {
        Box(
            modifier = modifier
                .background(gradient)
                .fillMaxWidth()
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(modifier = modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .then(modifier),
                text = text,
                textAlign = TextAlign.Center,
                fontFamily = oswaldSansFamily, fontWeight = FontWeight.Medium, style = TextStyle(
                fontSize = 16.sp))
        }
    }
}

@Composable
fun SplashGuestButton(
    text: String,
    onClickGuest: () -> Unit = { },
) {
    val shape = RoundedCornerShape(5.dp)
    val modifier = Modifier
        .background(Color.Transparent)
        .padding(horizontal = 16.dp)
        .fillMaxWidth()
        .bounceClick()

    Button(
        modifier = modifier
            .wrapContentWidth()
            .padding(vertical = 10.dp),
        shape = shape,
        colors = ButtonColors(containerColor = Color.Transparent, contentColor = MaterialTheme.colorScheme.EnabledButtonFirstBackground, disabledContainerColor = Color.Transparent, disabledContentColor = MaterialTheme.colorScheme.EnabledButtonSecondBackground),
        onClick = { onClickGuest() },
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(modifier = modifier
                .padding(horizontal = 16.dp)
                .then(modifier),
                text = text,
                textAlign = TextAlign.Center,
                fontFamily = oswaldSansFamily, fontWeight = FontWeight.Medium, style = TextStyle(
                    fontSize = 22.sp))
        }
    }
}

@Composable
fun SimpleSnackbar(isVisible: Boolean, message: String) {
    Scaffold { contentPadding ->

        if (isVisible) {
            Snackbar(modifier = Modifier.padding(contentPadding), content = { Text(message) })
        }
    }
}
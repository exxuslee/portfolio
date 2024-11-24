package org.haos.portfolio.app.modules.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import org.haos.portfolio.app.modules.home.models.HomeEvent
import org.haos.portfolio.app.modules.home.models.HomeViewState
import org.haos.portfolio.app.theme.AppTheme
import org.haos.portfolio.app.theme.ComposeAppTheme
import org.haos.portfolio.app.theme.LocalThemeIsDark
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import portfolio.composeapp.generated.resources.*


@Composable
fun HomeViewV(
    viewState: HomeViewState, eventHandler: (HomeEvent) -> Unit
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.cyclone),
            fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular)),
            style = MaterialTheme.typography.displayLarge
        )

        var isAnimate by remember { mutableStateOf(false) }
        val transition = rememberInfiniteTransition()
        val rotate by transition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing)
            )
        )

        Image(
            modifier = Modifier
                .size(250.dp)
                .padding(16.dp)
                .run { if (isAnimate) rotate(rotate) else this },
            imageVector = vectorResource(Res.drawable.ic_cyclone),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = null
        )

        ElevatedButton(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .widthIn(min = 200.dp),
            onClick = { isAnimate = !isAnimate },
            content = {
                Icon(vectorResource(Res.drawable.ic_rotate_right), contentDescription = null)
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    stringResource(if (isAnimate) Res.string.stop else Res.string.run)
                )
            }
        )

        var isDark by LocalThemeIsDark.current
        val icon = remember(isDark) {
            if (isDark) Res.drawable.ic_light_mode
            else Res.drawable.ic_dark_mode
        }

        ElevatedButton(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
            onClick = { isDark = !isDark },
            content = {
                Icon(vectorResource(icon), contentDescription = null)
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(Res.string.theme))
            }
        )

        TextButton(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
            onClick = { eventHandler.invoke(HomeEvent.Counter)},
        ) {
            Text(viewState.counter.toString())
        }
    }
}


@Composable
@Preview
fun HomeViewV_Preview() {
    AppTheme {
        HomeViewV(viewState = HomeViewState()) {}
    }
}
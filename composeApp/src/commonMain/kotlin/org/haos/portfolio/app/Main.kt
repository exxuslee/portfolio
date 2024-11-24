package org.haos.portfolio.app

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import org.haos.portfolio.app.core.navigations.ScreenGraph
import org.haos.portfolio.app.modules.home.HomeScreen
import org.haos.portfolio.app.modules.portfolio.presentation.PortfolioScreen
import org.haos.portfolio.app.modules.profile.ProfileScreen
import org.haos.portfolio.app.theme.ComposeAppTheme
import org.haos.portfolio.app.ui.caption_tyler
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import portfolio.composeapp.generated.resources.*

@Composable
fun Main() {
    var selectedScreen by remember { mutableStateOf(ScreenGraph.Home) }
    var isMobile by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = selectedScreen, label = "Screen Transition")

    val offsetX by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 500) },
        label = "Parallax Offset"
    ) { index ->
        -index.ordinal * 200F
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .onGloballyPositioned { coordinates ->
                isMobile = coordinates.size.height > coordinates.size.width
            },
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(Res.drawable.background),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(scaleX = 2f, scaleY = 2f)
                .offset { IntOffset(offsetX.toInt(), 0) },
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        Scaffold(
            modifier = if (isMobile) Modifier.fillMaxWidth() else Modifier.width(1280.dp),
            bottomBar = {
//            if (isMobile)
                BottomNavigation(backgroundColor = MaterialTheme.colorScheme.scrim) {
                    ScreenGraph.entries.forEach { screen ->
                        val icon = when (screen) {
                            ScreenGraph.Profile -> vectorResource(Res.drawable.ic_account_balance_fill1) to vectorResource(
                                Res.drawable.ic_account_balance_fill0
                            )

                            ScreenGraph.Home -> Icons.Rounded.Home to Icons.Outlined.Home
                            ScreenGraph.Portfolio -> vectorResource(Res.drawable.ic_sports_fill1) to vectorResource(Res.drawable.ic_sports_fill0)
                        }

                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    if (selectedScreen == screen) icon.first else icon.second,
                                    contentDescription = screen.name,
                                    tint = ComposeAppTheme.colors.tyler
                                )
                            },
                            label = { caption_tyler(text = stringResource(screen.label), maxLines = 1) },
                            selected = screen == selectedScreen,
                            onClick = { selectedScreen = screen },
                        )
                    }
                }
            }, content = { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    when (selectedScreen) {
                        ScreenGraph.Profile -> Navigator(ProfileScreen(isMobile))
                        ScreenGraph.Home -> Navigator(HomeScreen(isMobile))
                        ScreenGraph.Portfolio -> Navigator(PortfolioScreen(isMobile))
                    }
                }
            }
        )
    }

}
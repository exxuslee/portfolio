package org.haos.portfolio.app

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import org.haos.portfolio.app.navigations.ScreenGraph
import org.haos.portfolio.app.modules.home.HomeScreen
import org.haos.portfolio.app.modules.portfolio.presentation.PortfolioScreen
import org.haos.portfolio.app.modules.profile.ProfileScreen
import org.haos.portfolio.app.theme.ComposeAppTheme
import org.haos.portfolio.app.ui.caption_tyler
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import portfolio.composeapp.generated.resources.*

@Composable
fun Main() {
    var selectedScreen by remember { mutableStateOf(ScreenGraph.entries.first()) }
    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colorScheme.scrim) {
            ScreenGraph.entries.forEach { screen ->
                val icon = when (screen) {
                    ScreenGraph.Home -> Icons.Rounded.Home to Icons.Outlined.Home
                    ScreenGraph.Portfolio -> vectorResource(Res.drawable.ic_sports_fill1) to vectorResource(Res.drawable.ic_sports_fill0)
                    ScreenGraph.Profile -> vectorResource(Res.drawable.ic_account_balance_fill1) to vectorResource(Res.drawable.ic_account_balance_fill0)
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
    }, content = {
        when (selectedScreen) {
            ScreenGraph.Home -> Navigator(HomeScreen())
            ScreenGraph.Portfolio -> Navigator(PortfolioScreen())
            ScreenGraph.Profile -> Navigator(ProfileScreen())
        }
    })
}
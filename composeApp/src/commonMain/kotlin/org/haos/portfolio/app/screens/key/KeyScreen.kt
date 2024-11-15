package org.haos.portfolio.app.screens.key

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.transitions.ScreenTransition
import org.haos.portfolio.app.navigations.SlideTransition
import org.haos.portfolio.app.theme.ComposeAppTheme

@OptIn(ExperimentalVoyagerApi::class)
class KeyScreen : Screen, ScreenTransition by SlideTransition() {
    @Composable
    override fun Content() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = ComposeAppTheme.colors.elenaD) {

        }
    }
}
package org.haos.portfolio.app.screens.portfolio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.transitions.ScreenTransition
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import org.haos.portfolio.app.navigations.SlideTransition
import org.haos.portfolio.app.screens.about.AboutScreenModel
import org.haos.portfolio.app.screens.about.AboutView
import org.haos.portfolio.app.theme.ComposeAppTheme

@OptIn(ExperimentalVoyagerApi::class)
class PortfolioScreen : Screen, ScreenTransition by SlideTransition() {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { PortfolioScreenModel() }
        val viewState by screenModel.viewStates().collectAsState()
        val viewAction by screenModel.viewActions().collectAsState(null)

        PortfolioView(viewState = viewState) { event ->
            screenModel.obtainEvent(event)
        }

        when (viewAction) {
            null -> {}
        }
    }
}
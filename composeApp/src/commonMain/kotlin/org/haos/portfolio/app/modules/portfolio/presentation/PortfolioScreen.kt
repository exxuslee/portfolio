package org.haos.portfolio.app.modules.portfolio.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.transitions.ScreenTransition
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioAction
import org.haos.portfolio.app.core.navigations.SlideTransition
import org.haos.portfolio.app.modules.home.HomeViewH
import org.haos.portfolio.app.modules.home.HomeViewV

@OptIn(ExperimentalVoyagerApi::class)
class PortfolioScreen(private val isMobile: Boolean) : Screen, ScreenTransition by SlideTransition() {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { PortfolioScreenModel() }
        val viewState by screenModel.viewStates().collectAsState()
        val viewAction by screenModel.viewActions().collectAsState(null)


        if (isMobile) PortfolioViewV(viewState = viewState) { event ->
            screenModel.obtainEvent(event)
        }
        else PortfolioViewH(viewState = viewState) { event ->
            screenModel.obtainEvent(event)
        }

        when (viewAction) {
            null -> {}
            PortfolioAction.Init -> {}
        }
    }
}
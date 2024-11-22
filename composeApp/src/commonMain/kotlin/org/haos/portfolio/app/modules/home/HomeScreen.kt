package org.haos.portfolio.app.modules.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.transitions.ScreenTransition
import org.haos.portfolio.app.core.navigations.SlideTransition

@OptIn(ExperimentalVoyagerApi::class)
class HomeScreen(private val isMobile: Boolean) : Screen, ScreenTransition by SlideTransition() {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { HomeScreenModel() }
        val viewState by screenModel.viewStates().collectAsState()
        val viewAction by screenModel.viewActions().collectAsState(null)

        if (isMobile) HomeViewV(viewState = viewState) { event ->
            screenModel.obtainEvent(event)
        }
        else HomeViewH(viewState = viewState) { event ->
            screenModel.obtainEvent(event)
        }

        when (viewAction) {
            null -> {}
        }
    }
}
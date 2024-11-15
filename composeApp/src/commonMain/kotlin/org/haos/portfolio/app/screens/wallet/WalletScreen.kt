package org.haos.portfolio.app.screens.wallet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.transitions.ScreenTransition
import org.haos.portfolio.app.navigations.SlideTransition
import org.haos.portfolio.app.screens.wallet.WalletScreenModel
import org.haos.portfolio.app.screens.wallet.WalletView


@OptIn(ExperimentalVoyagerApi::class)
class WalletScreen : Screen , ScreenTransition by SlideTransition() {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { WalletScreenModel() }
        val viewState by screenModel.viewStates().collectAsState()
        val viewAction by screenModel.viewActions().collectAsState(null)

        WalletView(viewState = viewState) { event ->
            screenModel.obtainEvent(event)
        }

        when (viewAction) {
            null -> {}
        }
    }

}
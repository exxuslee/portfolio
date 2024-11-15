package org.haos.portfolio.app.screens.wallet

import org.haos.portfolio.app.core.BaseScreenModel
import org.haos.portfolio.app.screens.wallet.models.WalletAction
import org.haos.portfolio.app.screens.wallet.models.WalletEvent
import org.haos.portfolio.app.screens.wallet.models.WalletViewState

class WalletScreenModel : BaseScreenModel<WalletViewState, WalletAction, WalletEvent>(initialState = WalletViewState()) {
    override fun obtainEvent(viewEvent: WalletEvent) {

    }

}
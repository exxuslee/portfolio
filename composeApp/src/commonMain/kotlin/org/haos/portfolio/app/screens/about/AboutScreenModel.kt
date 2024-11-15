package org.haos.portfolio.app.screens.about

import org.haos.portfolio.app.core.BaseScreenModel
import org.haos.portfolio.app.screens.portfolio.models.PortfolioAction
import org.haos.portfolio.app.screens.portfolio.models.PortfolioEvent
import org.haos.portfolio.app.screens.portfolio.models.PortfolioViewState

class AboutScreenModel : BaseScreenModel<PortfolioViewState, PortfolioAction, PortfolioEvent>(initialState = PortfolioViewState()) {
    override fun obtainEvent(viewEvent: PortfolioEvent) {

    }

}
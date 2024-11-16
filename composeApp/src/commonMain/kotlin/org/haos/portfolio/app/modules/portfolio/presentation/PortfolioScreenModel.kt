package org.haos.portfolio.app.modules.portfolio.presentation

import org.haos.portfolio.app.core.BaseScreenModel
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioAction
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioEvent
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioViewState

class PortfolioScreenModel : BaseScreenModel<PortfolioViewState, PortfolioAction, PortfolioEvent>(initialState = PortfolioViewState()) {

    init {

    }

    override fun obtainEvent(viewEvent: PortfolioEvent) {

    }

}
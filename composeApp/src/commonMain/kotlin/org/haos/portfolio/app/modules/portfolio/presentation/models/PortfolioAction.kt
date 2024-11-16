package org.haos.portfolio.app.modules.portfolio.presentation.models

sealed class PortfolioAction {
    data object Init : PortfolioAction()
}
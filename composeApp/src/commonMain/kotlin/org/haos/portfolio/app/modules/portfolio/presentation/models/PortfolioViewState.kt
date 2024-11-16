package org.haos.portfolio.app.modules.portfolio.presentation.models

import org.haos.portfolio.app.modules.portfolio.data.model.Count


data class PortfolioViewState(
    val count: Count = Count(emptyList()),
)
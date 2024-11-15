package org.haos.portfolio.app.screens.home

import org.haos.portfolio.app.core.BaseScreenModel
import org.haos.portfolio.app.screens.home.models.HomeAction
import org.haos.portfolio.app.screens.home.models.HomeEvent
import org.haos.portfolio.app.screens.home.models.HomeViewState

class HomeScreenModel : BaseScreenModel<HomeViewState, HomeAction, HomeEvent>(initialState = HomeViewState()) {
    override fun obtainEvent(viewEvent: HomeEvent) {
        when (viewEvent) {
            HomeEvent.ToggleTheme -> viewState = viewState.copy(isDark = !viewState.isDark)
            HomeEvent.Counter -> viewState = viewState.copy(counter = viewState.counter.inc())
        }

    }

}
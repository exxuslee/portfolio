package org.haos.portfolio.app.modules.home.models

sealed class HomeEvent {
    data object ToggleTheme : HomeEvent()
    data object Counter : HomeEvent()
}
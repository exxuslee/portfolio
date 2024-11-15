package org.haos.portfolio.app.screens.home.models

sealed class HomeEvent {
    data object ToggleTheme : HomeEvent()
    data object Counter : HomeEvent()
}
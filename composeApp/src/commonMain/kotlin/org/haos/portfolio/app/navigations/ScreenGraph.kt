package org.haos.portfolio.app.navigations

import org.jetbrains.compose.resources.StringResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.home
import portfolio.composeapp.generated.resources.portfolio
import portfolio.composeapp.generated.resources.about_me

enum class ScreenGraph(val label: StringResource) {
    Home(Res.string.home), Portfolio(Res.string.portfolio), AboutMe(Res.string.about_me),
}

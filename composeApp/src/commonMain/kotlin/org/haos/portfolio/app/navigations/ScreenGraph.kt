package org.haos.portfolio.app.navigations

import org.jetbrains.compose.resources.StringResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.home
import portfolio.composeapp.generated.resources.key
import portfolio.composeapp.generated.resources.wallet

enum class ScreenGraph(val label: StringResource) {
    Home(Res.string.home), Key(Res.string.key), Wallet(Res.string.wallet),
}

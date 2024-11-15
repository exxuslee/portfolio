package org.haos.portfolio.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.haos.portfolio.app.theme.ComposeAppTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ic_arrow_right

@Composable
fun HsRow(
    icon: DrawableResource,
    titleContent: @Composable () -> Unit,
    onClick: (() -> Unit)? = null,
    arrowRight: Boolean = false,
    valueContent: @Composable () -> Unit,
) {
    RowUniversal(modifier = Modifier.padding(horizontal = 12.dp), onClick = onClick) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(ComposeAppTheme.colors.tyler),
        )
        titleContent()
        Spacer(Modifier.weight(1f))
        valueContent()
        if (arrowRight) Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(Res.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }
}

@Composable
fun HsRow(
    icon: ImageVector,
    titleContent: @Composable () -> Unit,
    onClick: (() -> Unit)? = null,
    arrowRight: Boolean = false,
    valueContent: (@Composable () -> Unit)? = null,
) {
    RowUniversal(modifier = Modifier.padding(horizontal = 12.dp), onClick = onClick) {
        Icon(
            icon,
            modifier = Modifier.size(30.dp),
            contentDescription = null,
            tint = ComposeAppTheme.colors.tyler
        )
        titleContent()
        Spacer(Modifier.weight(1f))
        if (valueContent != null) valueContent()

        if (arrowRight) Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(Res.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }
}
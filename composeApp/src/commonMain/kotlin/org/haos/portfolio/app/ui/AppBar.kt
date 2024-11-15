package org.haos.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import org.haos.portfolio.app.theme.ComposeAppTheme
import org.haos.portfolio.app.ui.HsIconButton
import org.haos.portfolio.app.ui.title3_leah
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.painterResource

data class MenuItem(
    val title: String,
    val icon: Int? = null,
    val enabled: Boolean = true,
    val tint: Color = Color.Unspecified,
    val onClick: () -> Unit,
)

@OptIn(InternalResourceApi::class)
@Composable
fun AppBarMenuButton(
    icon: Int,
    onClick: () -> Unit,
    description: String,
    enabled: Boolean = true,
    tint: Color = Color.Unspecified,
) {
    HsIconButton(
        onClick = onClick,
        enabled = enabled,
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(DrawableResource(icon.toString(), setOf())),
            contentDescription = description,
            tint = tint
        )
    }
}

@Composable
fun AppBar(
    title: String? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    menuItems: List<MenuItem> = listOf(),
    showSpinner: Boolean = false,
    backgroundColor: Color = ComposeAppTheme.colors.tyler
) {
    val titleComposable: @Composable () -> Unit = {
        title?.let {
            title3_leah(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

    AppBar(
        title = titleComposable,
        navigationIcon = navigationIcon,
        menuItems = menuItems,
        showSpinner = showSpinner,
        backgroundColor = backgroundColor
    )
}

@Composable
fun AppBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (() -> Unit)? = null,
    menuItems: List<MenuItem> = listOf(),
    showSpinner: Boolean = false,
    backgroundColor: Color = ComposeAppTheme.colors.tyler
) {
    TopAppBar(
        modifier = Modifier.height(64.dp),
        title = title,
        backgroundColor = backgroundColor,
        navigationIcon = navigationIcon?.let {
            {
                navigationIcon()
            }
        },
        actions = {
            if (showSpinner) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 16.dp)
                        .size(24.dp),
                    color = ComposeAppTheme.colors.grey,
                    strokeWidth = 2.dp
                )
            }
            menuItems.forEach { menuItem ->
                val color = if (menuItem.enabled) {
                    if (menuItem.tint == Color.Unspecified)
                        ComposeAppTheme.colors.jacob
                    else
                        menuItem.tint
                } else {
                    ComposeAppTheme.colors.grey50
                }

                if (menuItem.icon != null) {
                    AppBarMenuButton(
                        icon = menuItem.icon,
                        onClick = menuItem.onClick,
                        enabled = menuItem.enabled,
                        tint = color,
                        description = menuItem.title
                    )
                } else {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable(
                                enabled = menuItem.enabled,
                                onClick = menuItem.onClick
                            ),
                        text = menuItem.title.toUpperCase(Locale.current),
                        style = ComposeAppTheme.typography.headline2,
                        color = color
                    )
                }
            }
        },
        elevation = 0.dp
    )
}





@OptIn(InternalResourceApi::class)
@Composable
fun AppBarMenuButton(
    icon: Int,
    onClick: () -> Unit,
    enabled: Boolean = true,
    tint: Color = ComposeAppTheme.colors.jacob,
) {
    IconButton(
        onClick = { onClick() },
        enabled = enabled
    ) {
        if(enabled){
            Icon(
                painter = painterResource(DrawableResource(icon.toString(), setOf()) ),
                contentDescription = null,
                tint = tint
            )}
    }
}
@Composable
fun AppBar(
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    menuItems: List<MenuItem> = listOf(),
    space: Boolean = false
) {
    TopAppBar(
        modifier = Modifier.height(56.dp),
        title = {
            Text(
                modifier = if (space) {
                    Modifier.offset(x = (-25).dp)
                } else {
                    Modifier
                },
                text = title,
                style = ComposeAppTheme.typography.title3,
                color = ComposeAppTheme.colors.oz,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = ComposeAppTheme.colors.transparent,
        navigationIcon = navigationIcon?.let {
            {
                navigationIcon()
            }
        },
        actions = {
            menuItems.forEach { menuItem ->
                AppBarMenuButton(
                    icon = menuItem.icon!!,
                    onClick = menuItem.onClick,
                    enabled = menuItem.enabled,
                    tint = menuItem.tint
                )
            }
        },
        elevation = 0.dp
    )
}
package org.haos.portfolio.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.haos.portfolio.app.theme.ComposeAppTheme

@Composable
fun CellMultilineLawrenceSection(
    composableItems: List<@Composable () -> Unit>
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        composableItems.forEachIndexed { index, composable ->
            CellMultilineLawrence(borderTop = index != 0) {
                composable()
            }
        }
    }
}

@Composable
fun CellMultilineLawrenceSection(
    content: @Composable () -> Unit
) {
    CellMultilineLawrenceSection(listOf(content))
}

@Composable
fun <T> CellMultilineLawrenceSection(
    items: Iterable<T>,
    itemContent: @Composable (T) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        items.forEachIndexed { index, marketDataLine ->
            CellMultilineLawrence(borderTop = index != 0) {
                itemContent(marketDataLine)
            }
        }
    }
}

@Composable
fun CellMultilineLawrence(
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(ComposeAppTheme.colors.lawrence)
    ) {
        if (borderTop) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        if (borderBottom) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        content.invoke()
    }
}

@Composable
fun <T> CellSingleLineLawrenceSection(
    items: List<T>,
    itemContent: @Composable (T) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        items.forEachIndexed { index, marketDataLine ->
            CellSingleLineLawrence(borderTop = index != 0) {
                itemContent(marketDataLine)
            }
        }
    }

}

@Composable
fun CellSingleLineLawrenceSection(
    content: @Composable () -> Unit
) {
    CellSingleLineLawrenceSection(listOf(content))
}

@Composable
fun CellSingleLineLawrenceSection(
    composableItems: List<@Composable () -> Unit>
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        composableItems.forEachIndexed { index, composable ->
            CellSingleLineLawrence(borderTop = index != 0) {
                composable()
            }
        }
    }

}

@Composable
fun HSSectionRounded(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp)),
    ) {
        content()
    }
}

@Composable
fun Item(content: @Composable () -> Unit) {
    CellSingleLineLawrence(
        content = content
    )
}

@Composable
fun CellSingleLineLawrence(
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    content: @Composable () -> Unit,
) {
    CellSingleLine(
        borderTop = borderTop,
        borderBottom = borderBottom,
        color = ComposeAppTheme.colors.lawrence,
        content = content
    )
}

@Composable
fun CellSingleLine(
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    color: Color? = null,
    content: @Composable () -> Unit,
) {
    val colorModifier = when {
        color != null -> Modifier.background(color)
        else -> Modifier
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .then(colorModifier)
    ) {
        if (borderTop) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        if (borderBottom) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        content.invoke()
    }
}


@Composable
fun CellMultilineClear(
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    height: Dp = 56.dp,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val clickableModifier = when (onClick) {
        null -> Modifier
        else -> Modifier.clickable {
            onClick.invoke()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .then(clickableModifier)
    ) {
        if (borderTop) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        if (borderBottom) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        content.invoke()
    }
}

@Composable
fun CellSingleLineClear(
    modifier: Modifier = Modifier,
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        if (borderTop) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        if (borderBottom) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

@Composable
fun RowUniversal(
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 8.dp,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    onClick: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val clickableModifier = when (onClick) {
        null -> Modifier
        else -> Modifier.clickable {
            onClick.invoke()
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 24.dp)
            .then(clickableModifier)
            .then(modifier)
            .padding(vertical = verticalPadding),
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
        content = content
    )
}

@Composable
fun CellUniversalSection(
    content: @Composable () -> Unit
) {
    CellUniversalSection(listOf(content))
}

@Composable
fun CellUniversalSection(
    composableItems: List<@Composable () -> Unit>
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        composableItems.forEachIndexed { index, composable ->
            SectionUniversalItem(
                borderTop = index != 0,
            ) {
                composable()
            }
        }
    }
}

@Composable
fun <T> CellUniversalSection(
    items: Iterable<T>,
    showFrame: Boolean = false,
    itemContent: @Composable (T) -> Unit
) {
    val frameModifier = if (showFrame) {
        Modifier.border(1.dp, ComposeAppTheme.colors.steel20, RoundedCornerShape(12.dp))
    } else {
        Modifier
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(ComposeAppTheme.colors.lawrence)
            .then(frameModifier)
    ) {
        items.forEachIndexed { index, itemData ->
            SectionUniversalItem(
                borderTop = index != 0,
            ) {
                itemContent(itemData)
            }
        }
    }
}

@Composable
fun CellUniversalSection(
    showFrame: Boolean = false,
    content: @Composable () -> Unit
) {
    val frameModifier = if (showFrame) {
        Modifier.border(1.dp, ComposeAppTheme.colors.steel20, RoundedCornerShape(12.dp))
    } else {
        Modifier
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(ComposeAppTheme.colors.lawrence)
            .then(frameModifier)
    ) {
        SectionUniversalItem {
            content()
        }
    }
}


@Composable
fun SectionUniversalItem(
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    content: @Composable () -> Unit,
) {

    //content items should use RowUniversal

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (borderTop) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        if (borderBottom) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        content.invoke()
    }

}

@Composable
fun SectionItemBorderedRowUniversalClear(
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    onClick: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit,
) {
    Column {
        if (borderTop) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
            )
        }
        RowUniversal(
            modifier = Modifier.padding(horizontal = 16.dp),
            onClick = onClick,
            content = content
        )
        if (borderBottom) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
            )
        }
    }
}

@Composable
fun CellBorderedRowUniversal(
    modifier: Modifier = Modifier,
    borderTop: Boolean = false,
    borderBottom: Boolean = false,
    backgroundColor: Color = Color.Transparent,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        if (borderTop) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        if (borderBottom) {
            Divider(
                thickness = 1.dp,
                color = ComposeAppTheme.colors.steel10,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        RowUniversal(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            content = content
        )
    }
}

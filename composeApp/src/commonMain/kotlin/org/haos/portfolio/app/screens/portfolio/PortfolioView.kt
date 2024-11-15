package org.haos.portfolio.app.screens.portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.haos.portfolio.app.screens.portfolio.models.PortfolioEvent
import org.haos.portfolio.app.screens.portfolio.models.PortfolioViewState
import org.haos.portfolio.app.theme.AppTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PortfolioView(
    viewState: PortfolioViewState, eventHandler: (PortfolioEvent) -> Unit
) {
    var selectedPhoto by remember { mutableStateOf<DrawableResource?>(null) }

    if (selectedPhoto != null) {
        Dialog(onDismissRequest = { selectedPhoto = null }) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(selectedPhoto!!),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { selectedPhoto = null },
                    contentScale = ContentScale.Fit
                )
            }
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(viewState.photos) { photoRes ->
            Image(
                painter = painterResource(photoRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clickable { selectedPhoto = photoRes },
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
@Preview
fun PortfolioView_Preview(photos: List<DrawableResource>) {
    AppTheme {
        PortfolioView(viewState = PortfolioViewState()) {}
    }
}
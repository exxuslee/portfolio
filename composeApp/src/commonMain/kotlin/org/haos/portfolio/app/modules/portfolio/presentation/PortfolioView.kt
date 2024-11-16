package org.haos.portfolio.app.modules.portfolio.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioEvent
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioViewState
import org.haos.portfolio.app.theme.AppTheme
import org.haos.portfolio.app.ui.headline2_jacob
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PortfolioView(
    viewState: PortfolioViewState,
    eventHandler: (PortfolioEvent) -> Unit,
) {
    var selectedPhoto by remember { mutableStateOf<String?>(null) }
    val imageLoader = ImageLoader.Builder(LocalPlatformContext.current).build()
    if (selectedPhoto != null) {
        Dialog(onDismissRequest = { selectedPhoto = null }) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalPlatformContext.current)
                        .data(selectedPhoto)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clickable { selectedPhoto = null },
                    contentScale = ContentScale.Inside,
                    imageLoader = imageLoader,
                )
            }
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        viewState.count.projects.forEach { project ->
            item(span = { GridItemSpan(2) }) {
                headline2_jacob(
                    text = project.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            items(project.count) { count ->
                val url = "https://exxuslee.github.io/portfolio/gallery/${project.folder}/$count.jpg"
                AsyncImage(
                    model = url,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .widthIn(max = 480.dp)
                        .clickable { selectedPhoto = url },
                    contentScale = ContentScale.Fit,
                    imageLoader = imageLoader
                )
            }
        }

    }
}


@Composable
@Preview
fun PortfolioView_Preview(photos: List<DrawableResource>) {
    AppTheme { PortfolioView(viewState = PortfolioViewState()) {} }
}
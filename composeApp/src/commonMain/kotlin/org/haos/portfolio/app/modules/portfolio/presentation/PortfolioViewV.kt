package org.haos.portfolio.app.modules.portfolio.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioEvent
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioViewState
import org.haos.portfolio.app.theme.AppTheme
import org.haos.portfolio.app.theme.ComposeAppTheme
import org.haos.portfolio.app.ui.HSpacer
import org.haos.portfolio.app.ui.headline1_leah
import org.haos.portfolio.app.ui.headline2_leah
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PortfolioViewV(
    viewState: PortfolioViewState,
    eventHandler: (PortfolioEvent) -> Unit,
) {
    var selectedPhoto by remember { mutableStateOf<String?>(null) }
    val imageLoader = ImageLoader.Builder(LocalPlatformContext.current).build()
    if (selectedPhoto != null) {
        Dialog(onDismissRequest = { selectedPhoto = null }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalPlatformContext.current)
                        .data(selectedPhoto)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().clickable { selectedPhoto = null },
                    contentScale = ContentScale.Fit,
                    imageLoader = imageLoader,
                )
            }
        }
    }

    LazyColumn(
        modifier = Modifier.background(ComposeAppTheme.colors.greenD),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            val url = "https://exxuslee.github.io/portfolio/gallery/common/portfolio_header.jpg"
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current).data(url).build(),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit,
                imageLoader = imageLoader,
            )
        }
        viewState.count.projects.forEach { project ->
            stickyHeader {
                Row(
                    modifier = Modifier.fillMaxWidth().background(ComposeAppTheme.colors.background),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    headline2_leah(
                        text = project.title,
                        modifier = Modifier.padding(16.dp)
                    )
                    HSpacer(0.dp)
                    HSpacer(0.dp)
                    HSpacer(0.dp)
                }
            }

            items(project.count / 2 + project.count % 2) { count ->
                val url0 = "https://exxuslee.github.io/portfolio/gallery/${project.folder}/${count * 2}.jpg"
                val url1 = if (count * 2 + 1 < project.count)
                    "https://exxuslee.github.io/portfolio/gallery/${project.folder}/${count * 2 + 1}.jpg" else ""
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = url0,
                        contentDescription = null,
                        modifier = Modifier
                            .widthIn(max = 480.dp)
                            .aspectRatio(1f)
                            .clickable { selectedPhoto = url0 },
                        contentScale = ContentScale.Fit,
                        imageLoader = imageLoader
                    )
                    if (url1.isNotEmpty()) {
                        HSpacer(16.dp)
                        AsyncImage(
                            model = url1,
                            contentDescription = null,
                            modifier = Modifier
                                .widthIn(max = 480.dp)
                                .aspectRatio(1f)
                                .clickable { selectedPhoto = url1 },
                            contentScale = ContentScale.Fit,
                            imageLoader = imageLoader
                        )
                    }
                }
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
        item {
            headline1_leah(
                text = "Thanks for watching",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
    }
}


@Composable
@Preview
fun PortfolioViewV_Preview(photos: List<DrawableResource>) {
    AppTheme { PortfolioViewV(viewState = PortfolioViewState()) {} }
}
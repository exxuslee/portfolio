package org.haos.portfolio.app.modules.portfolio.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
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
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.portfolio_header

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

    val listState = remember { LazyListState() }
    LazyColumn(
        state = listState,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(Res.drawable.portfolio_header),
                contentDescription = "portfolio_header",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit,
            )
        }
        viewState.count.projects.forEach { project ->
            stickyHeader {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    headline2_leah(
                        text = project.title,
                        modifier = Modifier.clip(RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)).alpha(0.7f)
                            .background(ComposeAppTheme.colors.background).padding(vertical = 8.dp, horizontal = 48.dp),
                    )
                    HSpacer(0.dp)
                    HSpacer(0.dp)
                    HSpacer(0.dp)
                }
            }

            items(project.count) { count ->
                val url = "https://exxuslee.github.io/portfolio/gallery/${project.folder}/${count}.jpg"
                AsyncImage(
                    model = url,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                        .clickable { selectedPhoto = url },
                    contentScale = ContentScale.Fit,
                    imageLoader = imageLoader
                )
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
        item { Spacer(modifier = Modifier.height(48.dp)) }
    }
}


@Composable
@Preview
fun PortfolioViewV_Preview(photos: List<DrawableResource>) {
    AppTheme { PortfolioViewV(viewState = PortfolioViewState()) {} }
}
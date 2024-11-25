package org.haos.portfolio.app.modules.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.haos.portfolio.app.modules.profile.models.ProfileEvent
import org.haos.portfolio.app.modules.profile.models.ProfileViewState
import org.haos.portfolio.app.theme.AppTheme
import org.haos.portfolio.app.ui.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import portfolio.composeapp.generated.resources.*

@Composable
fun ProfileViewV(
    viewState: ProfileViewState, eventHandler: (ProfileEvent) -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        title3_leah(stringResource(Res.string.profile))
        RowUniversal(
            verticalPadding = 16.dp,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(Res.drawable.avatar),
                contentDescription = "avatar",
                modifier = Modifier.height(360.dp).border(2.dp, MaterialTheme.colorScheme.outline),
            )
            Column {
                headline2_tyler(stringResource(Res.string.skils))
                body_leah(stringResource(Res.string.Ds_max))
                body_leah(stringResource(Res.string.Corona))
                body_leah(stringResource(Res.string.Photoshop))
                body_leah(stringResource(Res.string.Illustrator))
                body_leah(stringResource(Res.string.Blender))
            }
        }

        VSpacer(8.dp)
        Column {
            headline1_tyler(
                stringResource(Res.string.about_me),
                Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
            )
            Text(
                stringResource(Res.string.I_am_ready_to_provide),
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
        VSpacer(16.dp)
        headline1_tyler(
            stringResource(Res.string.contacts),
            Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
        )
        CellUniversalSection(
            listOf(
                {
                    HsRow(
                        icon = Icons.Outlined.Email,
                        titleContent = {
                            Text(
                                "irynalinnik@gmail.com",
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        },
                        onClick = {},
                        arrowRight = true,
                    )
                },
                {
                    HsRow(
                        icon = Icons.Outlined.Phone,
                        titleContent = {
                            Text(
                                "+380(66)372-71-02",
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        },
                        onClick = {},
                        arrowRight = true,
                    )
                },
                {
                    HsRow(
                        icon = vectorResource(Res.drawable.ic_telegram),
                        titleContent = {
                            Text(
                                "t.me/irynalinnik_visualizer",
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        },
                        onClick = {},
                        arrowRight = true,
                    )
                },
                {
                    HsRow(
                        icon = vectorResource(Res.drawable.ic_instagram),
                        titleContent = {
                            Text(
                                "www.instagram.com/irinalinnik01/",
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        },
                        onClick = {},
                        arrowRight = true,
                    )
                },
                {
                    HsRow(
                        icon = vectorResource(Res.drawable.ic_behance),
                        titleContent = {
                            Text(
                                "www.behance.net/irinalinnik",
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        },
                        onClick = {},
                        arrowRight = true,
                    )
                },
                {
                    HsRow(
                        icon = vectorResource(Res.drawable.ic_linkedin),
                        titleContent = {
                            Text(
                                "www.linkedin.com/in/irinalinnik-visualizer/",
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        },
                        onClick = {},
                        arrowRight = true,
                    )
                },
            )
        )
        VSpacer(32.dp)
    }
}


@Composable
@Preview
fun ProfileViewV_Preview() {
    AppTheme {
        ProfileViewV(viewState = ProfileViewState()) {}
    }
}
package org.haos.portfolio.app.modules.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
import org.jetbrains.compose.ui.tooling.preview.Preview
import portfolio.composeapp.generated.resources.*

@Composable
fun ProfileViewV(
    viewState: ProfileViewState, eventHandler: (ProfileEvent) -> Unit
) {
    Surface(
        modifier = Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.scrim
                ),
            ),
        ),
        color = Color.Transparent,
    ) {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            RowUniversal(
                verticalPadding = 0.dp,
                horizontalArrangement = Arrangement.Center
            ) {
                title3_leah(stringResource(Res.string.profile))
            }
            VSpacer(8.dp)
            Image(
                painter = painterResource(Res.drawable.avatar),
                contentDescription = "avatar",
                modifier = Modifier.height(360.dp),
            )
            VSpacer(8.dp)
            Column {
                headline2_tyler(stringResource(Res.string.about_me))
                body_leah(stringResource(Res.string.I_am_ready_to_provide))
            }
            VSpacer(8.dp)
            Column {
                headline2_tyler(stringResource(Res.string.skils))
                body_leah(stringResource(Res.string.Ds_max))
                body_leah(stringResource(Res.string.Corona))
                body_leah(stringResource(Res.string.Photoshop))
                body_leah(stringResource(Res.string.Illustrator))
                body_leah(stringResource(Res.string.Blender))
            }
            VSpacer(8.dp)

            CellUniversalSection(
                listOf(
                    {
                        HsRow(
                            icon = Icons.Outlined.FavoriteBorder,
                            titleContent = {
                                headline2_tyler(
                                    text = stringResource(Res.string.election_history),
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 12.dp)
                                )
                            },
                            onClick = {},
                            arrowRight = true,
                            valueContent = {}
                        )
                    },
                    {
                        HsRow(
                            icon = Res.drawable.ic_account_balance_fill0,
                            titleContent = {
                                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                                    headline2_tyler(text = stringResource(Res.string.about_me))
                                    subhead1_grey(text = "UQB_C6…ZDro")
                                }
                            },
                            arrowRight = false,
                            valueContent = {
                                ButtonPrimaryGrey(
                                    title = stringResource(Res.string.disable),
                                    onClick = {}
                                )
                            }
                        )
                    },
                    {
                        HsRow(
                            icon = Icons.Outlined.Call,
                            titleContent = {
                                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                                    headline2_tyler(text = stringResource(Res.string.invite_friends))
                                    subhead1_grey(text = "И получить BONES")
                                }
                            },
                            arrowRight = false,
                            valueContent = {
                                ButtonPrimaryGrey(
                                    title = stringResource(Res.string.invite),
                                    onClick = {}
                                )
                            }
                        )
                    },
                )
            )
            HorizontalDivider()
            headline1_tyler(
                stringResource(Res.string.about_game),
                Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
            )
            CellUniversalSection(
                listOf(
                    {
                        HsRow(
                            icon = Icons.Outlined.Info,
                            titleContent = {
                                headline2_tyler(
                                    text = stringResource(Res.string.game_rules),
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 12.dp)
                                )
                            },
                            onClick = {},
                            arrowRight = true,
                        )
                    },
                    {
                        HsRow(
                            icon = Icons.Outlined.Star,
                            titleContent = {
                                headline2_tyler(
                                    text = stringResource(Res.string.how_are_the_prizes_distributed),
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 12.dp)
                                )
                            },
                            onClick = {},
                            arrowRight = true,
                        )
                    },
                )
            )
            HorizontalDivider()
            headline1_tyler(
                stringResource(Res.string.community),
                Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
            )
            CellUniversalSection{
                HsRow(
                    icon = Icons.AutoMirrored.Outlined.Send,
                    titleContent = {
                        headline2_tyler(
                            text = stringResource(Res.string.chat),
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                    },
                    onClick = {},
                    arrowRight = true,
                )
            }

            HorizontalDivider()
            VSpacer(32.dp)
        }
    }
}


@Composable
@Preview
fun ProfileViewV_Preview() {
    AppTheme {
        ProfileViewV(viewState = ProfileViewState()) {}
    }
}
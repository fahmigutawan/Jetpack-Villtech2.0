package com.dkmkknub.villtech.component

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.dkmkknub.villtech.R
import com.dkmkknub.villtech.navigation.AppNavRoute
import com.dkmkknub.villtech.ui.theme.GreenLight
import com.dkmkknub.villtech.ui.theme.Light

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppBottomBar(
    currentRoute: String,
    onItemClicked: (String) -> Unit
) {
    BottomAppBar(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp)),
        backgroundColor = Light,
        elevation = 16.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            AppBottomBarItem.values().forEach {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(color = Color.Black),
                            onClick = {
                                onItemClicked(it.route)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    AnimatedContent(
                        targetState = currentRoute,
                        transitionSpec = { fadeIn(tween(200)) with fadeOut(tween(200)) }
                    ) { currRoute ->
                        when (currRoute) {
                            it.route -> {
                                Box(
                                    modifier = Modifier
                                        .background(GreenLight)
                                        .width(72.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(8.dp),
                                        painter = rememberAsyncImagePainter(
                                            model = it.selectedIconId
                                        ),
                                        contentDescription = it.name,
                                        tint = Color.Unspecified
                                    )
                                }
                            }

                            else -> {
                                Icon(
                                    modifier = Modifier.padding(8.dp),
                                    painter = rememberAsyncImagePainter(
                                        model = it.unselectedIconId
                                    ),
                                    contentDescription = it.name,
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}

enum class AppBottomBarItem(
    val selectedIconId: Int,
    val unselectedIconId: Int,
    val route: String
) {
    Home(
        R.drawable.ic_botnavbar_home_click,
        R.drawable.ic_botnavbar_home_unclick,
        AppNavRoute.HomeScreen.name
    ),
    Search(
        R.drawable.ic_botnavbar_search_click,
        R.drawable.ic_botnavbar_search_unclick,
        AppNavRoute.SearchScreen.name
    ),
    Favorite(
        R.drawable.ic_botnavbar_favorite_click,
        R.drawable.ic_botnavbar_favorite_unclick,
        AppNavRoute.FavoriteScreen.name
    ),
    About(
        R.drawable.ic_botnavbar_about_click,
        R.drawable.ic_botnavbar_about_unclick,
        AppNavRoute.AboutScreen.name
    )
}
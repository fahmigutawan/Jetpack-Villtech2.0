package com.dkmkknub.villtech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dkmkknub.villtech.component.AppBottomBar
import com.dkmkknub.villtech.navigation.AppNavRoute
import com.dkmkknub.villtech.ui.theme.VilltechSidomulyoTheme
import com.dkmkknub.villtech.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VilltechSidomulyoTheme {
                val mainViewModel by viewModels<MainViewModel>()
                val navController = rememberNavController()

                navController.addOnDestinationChangedListener { _, destination, _ ->
                    destination.route?.let { route ->
                        mainViewModel.currentRoute.value = route
                    }
                }

                Scaffold(bottomBar = {
                    AppBottomBar(
                        currentRoute = mainViewModel.currentRoute.value,
                        onItemClicked = { route ->
                            navController.navigate(route = route)
                        }
                    )
                }) {
                    VilltechNavHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun VilltechNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppNavRoute.SplashScreen.name){
        composable(route = AppNavRoute.SplashScreen.name){

        }

        composable(route = AppNavRoute.HomeScreen.name){

        }

        composable(route = AppNavRoute.SearchScreen.name){

        }

        composable(route = AppNavRoute.FavoriteScreen.name){

        }

        composable(route = AppNavRoute.AboutScreen.name){

        }
    }
}

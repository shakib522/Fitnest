package com.example.fitnest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fitnest.ui.BottomNavItem
import com.example.fitnest.ui.Navigation
import com.example.fitnest.ui.theme.FitnestTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FitnestTheme {

                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                val uiController: SystemUiController = rememberSystemUiController()
                navController.addOnDestinationChangedListener { _: NavController, navDestination: NavDestination, _: Bundle? ->
                    println(navDestination.route)
                    println(navDestination.label)
                    println(navDestination.id)
                    uiController.isNavigationBarVisible =
                        !(navDestination.route == "home_screen" || navDestination.route == "profile" || navDestination.route == "workout" || navDestination.route == "sleep")
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenView(navController)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreenView(navController: NavHostController) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route?.substringBeforeLast("/")
        Scaffold(
            bottomBar = {
                BottomNavigations(navController = navController)
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    Navigation(navController)
                }
            }
        )
    }

    @Composable
    fun BottomNavigations(navController: NavController) {
        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.Workout,
            BottomNavItem.Sleep,
            BottomNavItem.Profile
        )
        val showBottomBar =
            navController.currentBackStackEntryAsState().value?.destination?.route in items.map { it.screen_route }
        if (showBottomBar) {
            NavigationBar(
                modifier = Modifier
                    .padding(bottom = 5.dp),
                contentColor = colorResource(R.color.gray_2),
                containerColor = colorResource(R.color.white)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach {
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colorResource(R.color.purple_linear_1),
                            unselectedIconColor = colorResource(R.color.gray_2),
                            indicatorColor = Color.White
                        ),
                        icon = {
                            Icon(
                                ImageVector.vectorResource(id = it.icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                            )
                        },
                        selected = currentRoute == it.screen_route,
                        onClick = {
                            navController.navigate(it.screen_route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )


                }
            }
        }

    }

}
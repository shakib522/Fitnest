package com.example.fitnest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnest.ui.home.HomeScreen
import com.example.fitnest.ui.intro.IntroScreen
import com.example.fitnest.ui.onBoarding.OnBoardingScreen
import com.example.fitnest.ui.profile.ProfileScreen
import com.example.fitnest.ui.signUp.SignUpScreen
import com.example.fitnest.ui.sleep.SleepScreen
import com.example.fitnest.ui.workout.WorkoutScreen

@Composable
fun Navigation(navController:NavHostController) {
    NavHost(navController = navController, startDestination = Screen.IntroScreen.route) {
        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(navController = navController)
        }

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.OnBoarding.route
        ) {
            OnBoardingScreen(navController)
        }
        composable(route = Screen.IntroScreen.route) {
            IntroScreen(navController)
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }

        composable(route = Screen.Sleep.route) {
            SleepScreen()
        }
        composable(route = Screen.Workout.route) {
            WorkoutScreen()
        }
    }
}
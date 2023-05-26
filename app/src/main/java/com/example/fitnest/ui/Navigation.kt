package com.example.fitnest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnest.ui.home.HomeScreen
import com.example.fitnest.ui.onBoarding.OnBoardingScreen
import com.example.fitnest.ui.signUp.SignUpScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.OnBoarding.route){
        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController = navController)
        }

        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.OnBoarding.route
        ){
            OnBoardingScreen()
        }
    }
}
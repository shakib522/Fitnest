package com.example.fitnest.ui

sealed class Screen(val route: String) {
    object SignUp : Screen("sign_up_screen")
    object Home : Screen("home_screen")

    object OnBoarding:Screen("on_boarding")
}

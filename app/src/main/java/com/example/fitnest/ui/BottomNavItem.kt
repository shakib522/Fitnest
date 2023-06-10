package com.example.fitnest.ui

import com.example.fitnest.R

sealed class BottomNavItem( var icon:Int , var screen_route :String){

    object Home : BottomNavItem( R.drawable.ic_home,"home_screen")
    object Profile : BottomNavItem(R.drawable.ic_profile,"profile")
    object Workout : BottomNavItem (R.drawable.ic_workout,"workout")
    object Sleep : BottomNavItem(R.drawable.ic_sleep,"sleep")
}

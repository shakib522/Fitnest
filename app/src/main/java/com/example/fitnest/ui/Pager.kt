package com.example.fitnest.ui

sealed class Pager {
    object First : Pager()
    object Second : Pager()
    object Third : Pager()
    object Fourth : Pager()
}

val pages = listOf(
    Pager.First, Pager.Second, Pager.Third, Pager.Fourth
)
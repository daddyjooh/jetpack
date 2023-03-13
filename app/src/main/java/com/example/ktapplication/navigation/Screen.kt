package com.example.ktapplication.navigation



sealed class Screen(val route: String) {
    object OnBoarding : Screen(route ="onBoarding")
    object CourseDetails : Screen(route ="CourseDetails")
    object Dashboard : Screen(route ="dashboard")

}
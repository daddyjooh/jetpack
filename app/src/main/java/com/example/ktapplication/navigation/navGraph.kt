package com.example.ktapplication.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ktapplication.OnBoarding.OnBoarding
import com.example.ktapplication.OnBoarding.onDashboardView
import com.example.ktapplication.dashboard.CourseDetails
import com.example.ktapplication.dashboard.Dashboard
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@ExperimentalMaterialApi
@Composable
fun SetUpNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = Screen.OnBoarding.route) {


        //OnBoarding Screen
        composable(
            route=Screen.OnBoarding.route)
        {
            OnBoarding()
        }

        //Dashboard
        composable(
            route = Screen.Dashboard.route)
        {
            Dashboard()
        }

        //CourseDetails
        composable(
            route= Screen.CourseDetails.route) {
            CourseDetails()
        }
    }
}
package com.example.ktapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ktapplication.OnBoarding.OnBoarding
import com.example.ktapplication.navigation.SetUpNavGraph
import com.example.ktapplication.ui.theme.KTApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {


   private lateinit var navController: NavHostController
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KTApplicationTheme {




                window.statusBarColor = MaterialTheme.colors.background.toArgb()
                window.navigationBarColor = MaterialTheme.colors.background.toArgb()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    navController = rememberNavController()
                    SetUpNavGraph(navController = navController)

                }
            }
        }
    }



}




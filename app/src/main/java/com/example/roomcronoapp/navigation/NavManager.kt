package com.example.roomcronoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomcronoapp.viewModels.CronometroViewModel
import com.example.roomcronoapp.views.AddView
import com.example.roomcronoapp.views.EditView
import com.example.roomcronoapp.views.HomeView

@Composable
fun NavManager(cronometroVM: CronometroViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController)
        }
        composable("AddView"){
            AddView(navController, cronometroVM)
        }
        composable("EditView"){
            EditView(navController)
        }
    }
}

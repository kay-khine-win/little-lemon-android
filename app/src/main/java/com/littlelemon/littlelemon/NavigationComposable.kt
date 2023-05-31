package com.littlelemon.littlelemon


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationComposable(navController: NavHostController,  isLoggedIn: Boolean) {
    val navController = rememberNavController()
    val startDestination = if (isLoggedIn) "Home" else "Onboarding"

   // NavHost(navController = navController, startDestination = Home.route) {
    NavHost(navController = navController, startDestination) {

        composable("Onboarding") {
            Onboarding(navController)
        }

        composable(Home.route) {
            Home(navController)
        }

        composable(Profile.route) {
            Profile(navController)
        }
    }
}






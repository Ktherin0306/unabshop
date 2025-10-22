package me.angiesuarez.unabshop

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navigationController(){
    val navController = rememberNavController()
    val startDestination = "login"

    NavHost(navController, startDestination) {
        composable(route ="login"){
            LoginScreen(onClickRegister = {
                navController.navigate("register")
            })
        }
        composable(route ="register") {
            RegisterScreen(onClickRetturn = {
                navController.popBackStack()
            })
        }
        composable(route ="home") {
            HomeScreen()
        }
    }
}
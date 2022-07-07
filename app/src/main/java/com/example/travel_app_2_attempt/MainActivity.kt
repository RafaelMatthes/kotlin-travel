package com.example.travel_app_2_attempt

import com.example.travel_app.ScreenManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travel_app_2_attempt.ui.theme.TravelappTheme
import com.example.travel_app_2_attempt.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp();
                }
            }
        }
    }
}

@Composable
fun LoginNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = ScreenManager.Login.route) {
        composable(ScreenManager.Login.route) { LoginView(navController) }
        composable(ScreenManager.About.route) { AboutView(navController) }
        composable(ScreenManager.Register.route) { RegisterUserView(navController) }
        composable(ScreenManager.Home.route) { HomeView(navController) }
        composable(ScreenManager.Travel.route) { TravelView(navController) }
        composable(ScreenManager.RegisterTravel.route) { RegisterTravelView(navController) }
        composable(ScreenManager.Spent.route + "/" + "{travelId}",
            arguments = listOf(
                navArgument("travelId") {
                    type = NavType.IntType
                })
        )
        {
            val id = it.arguments?.getInt ("travelId")
            SpentView(navController, id)
        }
        composable(ScreenManager.RegisterSpent.route + "/" + "{travelId}",
            arguments = listOf(
                navArgument("travelId") {
                    type = NavType.IntType
                })
        )
        {
            val id = it.arguments?.getInt ("travelId")
            RegisterSpentView(navController, id)
        }
    }
}

//@Composable
//fun RegisterUserView(navController: NavHostController) {
//
//}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    LoginNavigation(navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TravelappTheme {
        MyApp();
    }
}
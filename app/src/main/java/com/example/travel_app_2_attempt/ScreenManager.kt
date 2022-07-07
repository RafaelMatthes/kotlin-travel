package com.example.travel_app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenManager(val route: String,
                           val name: String,
                           val icon: ImageVector) {

    object Home : ScreenManager("home", "Home", Icons.Filled.Home)
    object Travel : ScreenManager("travel", "Viagens", Icons.Filled.Email)
    object About : ScreenManager("about", "Sobre", Icons.Filled.Face)

    object Login : ScreenManager("login", "Login", Icons.Filled.Face)
    object Register : ScreenManager("register", "Register", Icons.Filled.Face)
    object RegisterTravel : ScreenManager("registerTravel", "RegisterTravel", Icons.Filled.Face)

    object Spent: ScreenManager("spent", "Spent", Icons.Filled.Face)
    object RegisterSpent: ScreenManager("registerSpent", "RegisterSpent", Icons.Filled.Face)

}
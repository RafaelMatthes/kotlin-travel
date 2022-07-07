package com.example.travel_app_2_attempt.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.travel_app_2_attempt.components.BottomMenu

@Composable
fun AboutView(navController: NavController) {


    Scaffold(
        topBar = {
            Column() {
                Text(text = "Aqui devem ser adicionadas informações sobre o Autor")
            }
        },
        bottomBar = {
            BottomMenu(navController = navController)
        }
    ) { }

}
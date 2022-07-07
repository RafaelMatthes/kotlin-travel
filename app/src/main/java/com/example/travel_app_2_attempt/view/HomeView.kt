package com.example.travel_app_2_attempt.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.travel_app.ScreenManager
import com.example.travel_app_2_attempt.components.BottomMenu
import androidx.compose.material.OutlinedButton as OutlinedButton

@Composable
fun HomeView(navController: NavHostController ) {
    Scaffold(
        content = {
//            OutlinedButton(modifier = Modifier.padding(all = 5.dp), onClick = {
//                navController.navigate(ScreenManager.RegisterTravel.route) {
//
//                }
//            }) {
//                Text(text = "Cadastrar Viagem")
//            }
        },
        bottomBar = {
            BottomMenu(navController = navController)
        }
    )
}
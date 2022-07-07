package com.example.travel_app_2_attempt.view

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.ScreenManager
import com.example.travel_app_2_attempt.components.PasswordField
import com.example.travel_app_2_attempt.viewModel.UserFactory
import com.example.travel_app_2_attempt.viewModel.UserViewModel

@Composable
fun RegisterUserView(navController: NavController) {
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application

    val user: UserViewModel = viewModel(factory = UserFactory(app))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.padding(all = 60.dp)) {
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = user.name,
                label = {
                    Text(text = "Nome completo")
                },
                onValueChange = { user.name = it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = user.userName,
                label = {
                    Text(text = "Usuario")
                },
                onValueChange = { user.userName = it; })
            PasswordField(
                value = user.password,
                onChange = { user.password = it },
                modifier = Modifier.padding(10.dp)
            )
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = user.email,
                label = {
                    Text(text = "Email")
                },
                onValueChange = { user.email = it; })

//            Row(Modifier.padding(all = 60.dp)) {
                OutlinedButton(modifier = Modifier.padding(all = 5.dp), onClick = {
                    navController.navigate(ScreenManager.Login.route) {

                    }
                }) {
                    Text(text = "Voltar")
                }

                OutlinedButton(modifier = Modifier.padding(all = 5.dp), onClick = {
                    user.register()
                    navController.navigate(ScreenManager.Login.route) {

                    }
                }) {
                    Text(text = "Cadastrar")
                }
            }
        }
    }

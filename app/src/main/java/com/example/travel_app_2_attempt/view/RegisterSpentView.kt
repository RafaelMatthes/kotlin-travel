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
import com.example.travel_app_2_attempt.viewModel.SpentFactory
import com.example.travel_app_2_attempt.viewModel.SpentViewModel

@Composable
fun RegisterSpentView(navController: NavController, id: Int?) {
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application

    val spent: SpentViewModel = viewModel(factory = SpentFactory(app))
    

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(Modifier.padding(all= 60.dp)) {
            Text(text = "Cadastro de Despesas")
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = spent.date,
                label = {
                    Text(text = "Data")
                },
                onValueChange = { spent.date =it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = spent.value.toString(),
                label = {
                    Text(text = "Valor da despesa")
                },
//                onValueChange = { spent.value = Integer.parseInt(it).toDouble(); })
                onValueChange = { spent.value = 50.0 })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = spent.description,
                label = {
                    Text(text = "Descrição")
                },
                onValueChange = { spent.description = it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = spent.local,
                label = {
                    Text(text = "Local da despesa")
                },
                onValueChange = { spent.local = it; })
        }
        Row(Modifier.padding(all= 60.dp)) {
            OutlinedButton(modifier = Modifier.padding(all= 5.dp),onClick =  {
                navController.navigate(ScreenManager.Spent.route + "/" + id) { }
            }) {
                Text(text = "Voltar")
            }

            OutlinedButton(modifier = Modifier.padding(all= 5.dp), onClick =  {
                navController.navigate(ScreenManager.Spent.route + "/" + id) {
                    if (id != null) {
                        spent.travelId = id
                    }
                    spent.register()
                }
            }) {
                Text(text = "Cadastrar")
            }
        }
    }
}
package com.example.travel_app_2_attempt.view

import android.app.Application
import android.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.ScreenManager
import com.example.travel_app_2_attempt.entity.TipoViagem
import com.example.travel_app_2_attempt.viewModel.TravelFactory
import com.example.travel_app_2_attempt.viewModel.TravelViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.remember

@Composable
fun RegisterTravelView(navController: NavController) {
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application
    var selectedOption = remember { mutableStateOf("") }

    val travel: TravelViewModel = viewModel(factory = TravelFactory(app))

    Row(Modifier.padding(all = 25.dp)) {
        Text(text = "Cadastro de Viagens")
    }
    
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.padding(all = 60.dp)) {
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.destiny,
                label = {
                    Text(text = "Destino")
                },
                onValueChange = { travel.destiny = it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.budget.toString(),
                label = {
                    Text(text = "Valor da viagem")
                },
//                onValueChange = { travel.budget = Integer.parseInt(it).toDouble(); })
                onValueChange = { travel.budget = 100.0 })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.comingDate,
                label = {
                    Text(text = "Data de chegada")
                },
                onValueChange = { travel.comingDate = it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.departureDate,
                label = {
                    Text(text = "Data de partida")
                },
                onValueChange = { travel.departureDate = it; })
            Row(Modifier.padding(start = 10.dp)) {
                Text(text = "Lazer")
                RadioButton(modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    selected = selectedOption.value == "Viagem de lazer",
                    onClick = {
                        selectedOption.value = "Viagem de lazer"
                    })
                Text(text = "Negócios")
                RadioButton(modifier = Modifier.padding(start = 10.dp),
                    selected = selectedOption.value == "Viagem a negócios",
                    onClick = {
                        selectedOption.value = "Viagem a negócios"
                    })
            }
            Row(Modifier.padding(all = 60.dp)) {
                OutlinedButton(modifier = Modifier.padding(all = 1.dp), onClick = {
                    navController.navigate(ScreenManager.Travel.route) { }
                }) {
                    Text(text = "Voltar")
                }

                OutlinedButton(modifier = Modifier.padding(all = 1.dp), onClick = {
                    navController.navigate(ScreenManager.Travel.route) {
                        if (selectedOption.value == "Viagem de lazer") {
                            travel.type = TipoViagem.LAZER
                        } else {
                            travel.type = TipoViagem.NEGOCIO
                        }
                        travel.register()
                    }
                }) {
                    Text(text = "Cadastrar")
                }
            }
        }
    }
}

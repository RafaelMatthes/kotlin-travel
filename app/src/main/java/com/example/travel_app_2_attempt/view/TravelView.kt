package com.example.travel_app_2_attempt.view

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.DisabledByDefault
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.ScreenManager
import com.example.travel_app_2_attempt.components.BottomMenu
import com.example.travel_app_2_attempt.entity.TipoViagem
import com.example.travel_app_2_attempt.entity.Travel
import com.example.travel_app_2_attempt.viewModel.TravelFactory
import com.example.travel_app_2_attempt.viewModel.TravelViewModel
import java.text.DecimalFormat

@Composable
fun TravelView(navController: NavController) {
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application
    val travelVM: TravelViewModel = viewModel(factory = TravelFactory(app))
    var travels: List<Travel> = ArrayList();

    travelVM.TravelFindAll(onSuccess = {
        travels = it
    })

    Scaffold(
        topBar = {
            LazyColumn(){
                items(items = travels) {
                        p -> TravelCard(p, navController)
                }
            }
        },
        bottomBar = {
            BottomMenu(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(ScreenManager.RegisterTravel.route) {

                }
            }) {
                Icon(Icons.Filled.Add,"")
            }
        }
    ) { }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TravelCard(travel: Travel, navController: NavController) {
    val df = DecimalFormat("0.00")
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application
    val travelVM: TravelViewModel = viewModel(factory = TravelFactory(app))

    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 8.dp),
        onClick = {
            navController.navigate(ScreenManager.Spent.route + "/" + travel.id) {

            }
        }
    ) {
        Row() {
            Column(modifier = Modifier
                .padding(16.dp)
                .weight(1f)
            ) {
                Text(text = "Viagem para ${travel.destiny}")
            }
            Column(modifier = Modifier
                .padding(16.dp)
                .weight(1f)
            ) {
                Text(text = "Chegada: ${travel.comingDate}")
                Text(text = "Saída: ${travel.departureDate}")
            }
            Text(
                text = "R$ ${df.format(travel.budget)}", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            )
            Button(onClick = {
                travelVM.delete(travel)
                navController.navigate(ScreenManager.Travel.route) {

                }
            }) {
                Icon(Icons.Rounded.DisabledByDefault, contentDescription = "Localized description")
            }
        }
    }
}
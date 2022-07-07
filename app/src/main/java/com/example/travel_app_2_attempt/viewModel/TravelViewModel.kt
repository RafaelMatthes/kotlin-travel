package com.example.travel_app_2_attempt.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travel_app_2_attempt.entity.TipoViagem
import com.example.travel_app_2_attempt.entity.Travel
import com.example.travel_app_2_attempt.repository.TravelRepository
import kotlinx.coroutines.launch

class TravelViewModel(
    private val repository: TravelRepository
): ViewModel()  {

    var id by mutableStateOf(0)

    var destiny by mutableStateOf("")

    var type by mutableStateOf(TipoViagem.LAZER)

    var comingDate by mutableStateOf("")

    var departureDate by mutableStateOf("")

    var budget by mutableStateOf(0.0)

    var user by mutableStateOf("")

    fun register() {
        val travel = Travel(destiny, TipoViagem.LAZER, comingDate, departureDate, 1, 0.0)
        viewModelScope.launch {
            repository.save(travel)
        }
    }

    fun TravelFindAll(onSuccess: (travelQry: List<Travel>) -> Unit) {
        viewModelScope.launch {
            val travelQry = repository.findAll()
            onSuccess(travelQry)
        }
    }

    fun delete(travel: Travel) {
        viewModelScope.launch {
            repository.delete(travel)
        }
    }
}
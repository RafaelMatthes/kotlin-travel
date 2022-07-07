package com.example.travel_app_2_attempt.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.travel_app_2_attempt.entity.User
import com.example.travel_app_2_attempt.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var userName by mutableStateOf("")

    var password by mutableStateOf("")

    var name by mutableStateOf("")

    var email by mutableStateOf("")

    fun register() {
        val user = User(userName, password, name, email)
        viewModelScope.launch {
            repository.save(user)
        }
    }

    fun login(onSuccess: () -> Unit, onFail: () -> Unit) {
        viewModelScope.launch {
            val userFound = repository.findUserByUsernameAndPassword(userName, password)
            if (userFound == null) {
                onFail()
            }
            else {
                onSuccess()
            }
        }
    }
}
package com.example.travel_app_2_attempt.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.travel_app_2_attempt.repository.SpentRepository

class SpentFactory(val app: Application): ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = SpentRepository(app)
        val model = SpentViewModel(repository)
        return model as T
    }
}
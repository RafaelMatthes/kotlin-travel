package com.example.travel_app_2_attempt.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val userName: String,
    val password: String,
    val name: String,
    val email: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
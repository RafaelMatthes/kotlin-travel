package com.example.travel_app_2_attempt.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE)
])
data class Travel(
    val destiny: String,
    val type: TipoViagem,
    val comingDate: String,
    val departureDate: String,
    val userId: Int,
    val budget: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

enum class TipoViagem {
    LAZER,
    NEGOCIO
}
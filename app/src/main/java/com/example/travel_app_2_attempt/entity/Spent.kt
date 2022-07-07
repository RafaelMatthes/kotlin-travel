package com.example.travel_app_2_attempt.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(foreignKeys = [
    ForeignKey(entity = Travel::class,
        parentColumns = ["id"],
        childColumns = ["travelId"],
        onDelete = ForeignKey.CASCADE)
])
data class Spent(
    val date: String,
    val value: Double,
    val description: String,
    val local: String,
    val travelId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
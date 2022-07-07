package com.example.travel_app_2_attempt.dao

import androidx.room.*
import com.example.travel_app_2_attempt.entity.Spent

@Dao
interface SpentDao {

    @Insert()
    suspend fun insert(spent: Spent)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(spent: Spent)

    @Delete
    suspend fun delete(spent: Spent)

    @Query("select * from Spent s where s.travelId = :travelId  order by description")
    suspend fun findAllByTravel(travelId: Int): List<Spent>

    @Query("select * from Spent s where s.id = :id")
    suspend fun findById(id: Int): Spent?

}
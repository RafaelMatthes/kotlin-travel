package com.example.travel_app_2_attempt.dao

import androidx.room.*
import com.example.travel_app_2_attempt.entity.Travel

@Dao
interface TravelDao {

    @Insert()
    suspend fun insert(travel: Travel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(travel: Travel)

    @Delete
    suspend fun delete(travel: Travel)

    @Query("select * from Travel order by destiny")
    suspend fun findAll(): List<Travel>

    @Query("select * from Travel c where c.id = :id")
    suspend fun findById(id: Int): Travel?

}
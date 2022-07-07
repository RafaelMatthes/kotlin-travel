package com.example.travel_app_2_attempt.dao

import androidx.room.*
import com.example.travel_app_2_attempt.entity.User

@Dao
interface UserDao {

    @Insert()
    suspend fun insert(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("select * from User order by userName")
    suspend fun findAll(): List<User>

    @Query("select * from User c where c.id = :id")
    suspend fun findById(id: Int): User?

    @Query("select * from User u where u.userName = :userName and u.password = :password")
    suspend fun findUserByUsernameAndPassword(userName: String, password: String): User?;
}
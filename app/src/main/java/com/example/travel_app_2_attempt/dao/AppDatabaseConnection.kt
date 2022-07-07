package com.example.travel_app_2_attempt.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.travel_app_2_attempt.entity.Spent
import com.example.travel_app_2_attempt.entity.Travel
import com.example.travel_app_2_attempt.entity.User

@Database(entities = arrayOf(User::class, Travel::class, Spent::class), version = 6 )
abstract class AppDatabaseConnection: RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun spentDao(): SpentDao

    abstract fun travelDao(): TravelDao

    // Desing Pattern - Singleton
    companion object {
        var connection: AppDatabaseConnection? = null

        fun getDB(context: Context): AppDatabaseConnection {
            val temp = connection
            if (temp != null) {
                return temp
            }
            else {
                // conectar o banco
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabaseConnection::class.java,
                    "meu-database"
                ).fallbackToDestructiveMigration()
                .build()
                connection = instance
                return instance
            }
        }

    }
}
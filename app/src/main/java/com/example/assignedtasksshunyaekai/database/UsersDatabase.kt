package com.example.assignedtasksshunyaekai.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignedtasksshunyaekai.dao.UserDataDao
import com.example.assignedtasksshunyaekai.data.UsersData

@Database(entities = [UsersData::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun UserDataDao(): UserDataDao

    companion object {

        @Volatile
        private var INSTANCE: UsersDatabase? = null

        fun getDatabase(context: Context): UsersDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, UsersDatabase::class.java,
                    "emp_DataBase"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }


}
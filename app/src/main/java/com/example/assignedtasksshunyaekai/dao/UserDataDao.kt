package com.example.assignedtasksshunyaekai.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignedtasksshunyaekai.data.UsersData

@Dao
interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsersDetails(usersData: UsersData)

    @Delete
    suspend fun deleteUser(usersData: UsersData)

    @Query("SELECT * FROM User_Table ORDER BY id ASC")
    fun readAllUserData(): LiveData<List<UsersData>>
}
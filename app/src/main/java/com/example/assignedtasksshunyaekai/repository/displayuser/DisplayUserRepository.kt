package com.example.assignedtasksshunyaekai.repository.displayuser

import androidx.lifecycle.LiveData
import com.example.assignedtasksshunyaekai.dao.UserDataDao
import com.example.assignedtasksshunyaekai.data.User
import com.example.assignedtasksshunyaekai.data.UsersData

class DisplayUserRepository(private val dao: UserDataDao)
{
    val readAllUserData: LiveData<List<UsersData>> = dao.readAllUserData()


    suspend fun deleteUserData(usersData: UsersData)
    {
        dao.deleteUser(usersData)

    }



}
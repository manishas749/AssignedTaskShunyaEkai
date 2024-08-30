package com.example.assignedtasksshunyaekai.repository.adduser

import androidx.lifecycle.LiveData
import com.example.assignedtasksshunyaekai.dao.UserDataDao
import com.example.assignedtasksshunyaekai.data.User
import com.example.assignedtasksshunyaekai.data.UsersData

class AddUserRepository(private val dao: UserDataDao)
{


    suspend fun addUserData(usersData: UsersData)
    {
        dao.addUsersDetails(usersData)

    }



}
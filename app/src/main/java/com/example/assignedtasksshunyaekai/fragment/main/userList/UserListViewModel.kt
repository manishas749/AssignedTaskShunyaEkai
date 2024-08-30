package com.example.assignedtasksshunyaekai.fragment.main.userList

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignedtasksshunyaekai.data.UsersData
import com.example.assignedtasksshunyaekai.database.UsersDatabase
import com.example.assignedtasksshunyaekai.navigator.UsersListNavigator
import com.example.assignedtasksshunyaekai.repository.adduser.AddUserRepository
import com.example.assignedtasksshunyaekai.repository.displayuser.DisplayUserRepository
import com.example.assignedtasksshunyaekai.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel(private val usersListNavigator: UsersListNavigator,application: Application):ViewModel()
{
    private val repository: DisplayUserRepository
    val readAllUsersData: LiveData<List<UsersData>>


    init {
        val dao = UsersDatabase.getDatabase(application).UserDataDao()
        repository = DisplayUserRepository(dao)
        readAllUsersData= repository.readAllUserData

    }

    fun onActionButtonClick()
    {
        usersListNavigator.onFabButtonClick()
    }

    fun deleteUsersData(usersData: UsersData) {
        viewModelScope.launch(Dispatchers.IO) {

            repository.deleteUserData(usersData)
        }
    }

}
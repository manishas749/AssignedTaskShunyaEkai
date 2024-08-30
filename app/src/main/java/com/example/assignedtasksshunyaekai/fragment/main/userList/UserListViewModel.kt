package com.example.assignedtasksshunyaekai.fragment.main.userList

import androidx.lifecycle.ViewModel
import com.example.assignedtasksshunyaekai.navigator.UsersListNavigator

class UserListViewModel(private val usersListNavigator: UsersListNavigator):ViewModel()
{


    fun onActionButtonClick()
    {
        usersListNavigator.onFabButtonClick()
    }

}
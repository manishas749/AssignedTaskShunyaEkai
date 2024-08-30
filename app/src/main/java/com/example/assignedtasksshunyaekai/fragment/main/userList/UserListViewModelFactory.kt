package com.example.assignedtasksshunyaekai.fragment.main.userList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignedtasksshunyaekai.navigator.UsersListNavigator
import com.example.assignedtasksshunyaekai.repository.auth.AuthRepository

class UserListViewModelFactory(
    private val usersListNavigator: UsersListNavigator,private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(usersListNavigator, application) as T
    }

}
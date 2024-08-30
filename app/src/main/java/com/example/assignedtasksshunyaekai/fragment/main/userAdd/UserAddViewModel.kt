package com.example.assignedtasksshunyaekai.fragment.main.userAdd

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignedtasksshunyaekai.data.UsersData
import com.example.assignedtasksshunyaekai.database.UsersDatabase
import com.example.assignedtasksshunyaekai.repository.adduser.AddUserRepository
import com.example.assignedtasksshunyaekai.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserAddViewModel(application: Application) : ViewModel() {
    private val repository: AddUserRepository
    val userLiveData = MutableLiveData<DataState<UsersData>>()


    init {
        val dao = UsersDatabase.getDatabase(application).UserDataDao()
        repository = AddUserRepository(dao)
    }

    fun onAddButtonClick(email: String, password: String, name: String) {
        userLiveData.value = DataState.Loading()
        val userData = UsersData(0, email, password, name)
        checkFields(userData)


    }

    private fun checkFields(userData: UsersData) {
        if (userData.isSignInFieldEmpty()) {
            userLiveData.value = DataState.Error("Fields can not be empty")
            return
        }

        if (!userData.isValidEmail()) {
            userLiveData.value = DataState.Error("Please enter a valid email id")
            return
        }
        signIn(userData)


    }

    private fun signIn(userData: UsersData) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("userData", "signIn: $userData")
            repository.addUserData(userData)
        }
        userLiveData.value = DataState.Success(userData)


    }


}
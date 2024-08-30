package com.example.assignedtasksshunyaekai.fragment.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignedtasksshunyaekai.utils.DataState
import com.example.assignedtasksshunyaekai.R
import com.example.assignedtasksshunyaekai.data.User
import com.example.assignedtasksshunyaekai.repository.auth.AuthRepository

class LoginViewModel(private val authRepository: AuthRepository) :ViewModel()
{
    val userLiveData = MutableLiveData<DataState<User>>()
    val loginResult = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()



    fun onSignInClicked(email: String, password: String){

        userLiveData.value = DataState.Loading()
        val user = User(email, password)
        checkFields(user)

    }

    private fun checkFields(user: User){

        if(user.isSignInFieldEmpty()){
            userLiveData.value = DataState.Error("Fields can not be empty")
            return
        }

        if(!user.isValidEmail()){
            userLiveData.value = DataState.Error("Please enter a valid email id")
            return
        }

        signIn(user)

    }

    private fun signIn(user: User){
        val result = authRepository.signIn(user)
        if (result)
        {
            userLiveData.value = DataState.Success(user)

        }
        else
        {
            userLiveData.value = DataState.Error("Invalid email or password")

        }


    }
}
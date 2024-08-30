package com.example.assignedtasksshunyaekai.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignedtasksshunyaekai.repository.auth.AuthRepository

class LoginViewModelFactory(private val authRepository: AuthRepository
):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(authRepository) as T
    }

}
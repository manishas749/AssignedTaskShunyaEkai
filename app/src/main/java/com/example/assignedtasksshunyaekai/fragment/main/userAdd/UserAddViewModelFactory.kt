package com.example.assignedtasksshunyaekai.fragment.main.userAdd

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignedtasksshunyaekai.repository.auth.AuthRepository

class UserAddViewModelFactory(private val application: Application
):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserAddViewModel(application) as T
    }

}
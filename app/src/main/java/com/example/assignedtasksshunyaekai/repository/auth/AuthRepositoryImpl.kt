package com.example.assignedtasksshunyaekai.repository.auth

import com.example.assignedtasksshunyaekai.data.User

class AuthRepositoryImpl : AuthRepository {
    override fun signIn(user: User): Boolean {
        return user.email == "test@gmail.com" && user.password == "123456"

    }
}
package com.example.assignedtasksshunyaekai.repository.auth

import com.example.assignedtasksshunyaekai.data.User

interface AuthRepository {

fun signIn(user: User):Boolean


}
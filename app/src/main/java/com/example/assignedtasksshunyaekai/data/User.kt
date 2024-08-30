package com.example.assignedtasksshunyaekai.data

import android.text.TextUtils
import android.util.Patterns

data class User(
    var email: String? = "",
    var password: String? = "",
) {


    fun isSignInFieldEmpty(): Boolean {
        return TextUtils.isEmpty(email) || TextUtils.isEmpty(password)
    }

    fun isValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email!!).matches()
    }
}
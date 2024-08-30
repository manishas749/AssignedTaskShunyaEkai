package com.example.assignedtasksshunyaekai.data

import android.text.TextUtils
import android.util.Patterns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_Table")
data class UsersData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "name") var name: String,


    ) {
    fun isSignInFieldEmpty(): Boolean {
        return TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(name)
    }

    fun isValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email!!).matches()
    }
}
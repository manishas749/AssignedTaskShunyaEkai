package com.example.assignedtasksshunyaekai.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_Table")
data class UsersData(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password:String,

    )
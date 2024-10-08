package com.example.assignedtasksshunyaekai.utils


sealed class DataState<T> {
    class Success<T>(val data: T) : DataState<T>()
    class Error<T>(val message: String) : DataState<T>()
    class Loading<T> : DataState<T>()
}
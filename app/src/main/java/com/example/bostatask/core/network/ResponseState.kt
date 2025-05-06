package com.example.bostatask.core.network

sealed class ResponseState<out T> {
    data class Success<out T>(val data: T) : ResponseState<T>()
    data class Error(val message: String) : ResponseState<Nothing>()
    object NoInternetS : ResponseState<Nothing>()
    object Loading : ResponseState<Nothing>()
}
package com.davidups.starwars.core.extensions

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
    inline fun fold(
        crossinline ifLoading: () -> Unit = {},
        crossinline ifError: (String) -> Unit = {},
        crossinline ifSuccess: (R) -> Unit = {}
    ) {
        when (this) {
            is Loading -> ifLoading()
            is Error -> ifError(error)
            is Success -> ifSuccess(data)
        }
    }
    inline fun <C> map(crossinline f: (R) -> C): C? {
        return when (this) {
            is Success -> f(data)
            else -> null
        }
    }
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[error=$error]"
            Loading -> "Loading"
        }
    }
    val succeeded
        get() = this is Success && data != null
}
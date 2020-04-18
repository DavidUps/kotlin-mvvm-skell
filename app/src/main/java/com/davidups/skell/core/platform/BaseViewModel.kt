package com.davidups.skell.core.platform

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidups.skell.core.exception.Failure
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<String> = MutableLiveData()
    var showSpinner: MutableLiveData<Boolean> = MutableLiveData()

    protected fun handleFailure(failure: String) {
        this.failure.value = failure
    }

    protected fun showSpinner(show: Boolean) {
        this.showSpinner.value = show
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        Log.e("", "CoroutineExceptionHandler handled crash $exception ->")
        Log.e("", "${exception.stackTrace.map { stackTraceElement ->
            "\n${stackTraceElement.className}: ${stackTraceElement.methodName} at line ${stackTraceElement.lineNumber}"
        }}")
    }

    internal val viewModelScope = CoroutineScope(Dispatchers.IO + SupervisorJob() + coroutineExceptionHandler)

    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
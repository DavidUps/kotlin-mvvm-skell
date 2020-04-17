package com.davidups.skell.core.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidups.skell.core.exception.Failure

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<String> = MutableLiveData()
    var showSpinner: MutableLiveData<Boolean> = MutableLiveData()

    protected fun handleFailure(failure: String) {
        this.failure.value = failure
    }

    protected fun showSpinner(show: Boolean) {
        this.showSpinner.value = show
    }
}
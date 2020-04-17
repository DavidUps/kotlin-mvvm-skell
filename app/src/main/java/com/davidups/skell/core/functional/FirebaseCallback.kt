package com.davidups.skell.core.functional

import java.lang.Exception

interface FirebaseCallback {
    fun onSuccess(result: Any)
    fun onFailure(e:Exception)
}
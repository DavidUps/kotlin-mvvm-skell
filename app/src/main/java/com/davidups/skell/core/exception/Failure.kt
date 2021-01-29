package com.davidups.skell.core.exception

sealed class Failure {
    object NetworkConnection : Failure()
    class ServerError(private val errorCode: Int) : Failure() {
        companion object {
            const val BAD_REQUEST = 400
            const val UNAUTHORIZED = 401
            const val FORBIDDEN = 403
            const val RESOURCE_NOT_FOUND = 404
            const val METHOD_NOT_ALLOWED = 405
            const val TIMED_OUT = 408
            const val CONFLICT = 409
            const val GONE = 410
            const val REQUEST_ENTITY_TOO_LONG = 413
            const val REQUEST_URI_TOO_LONG = 414
            const val UNSUPPORTED_MEDIA_TYPE = 415
            const val TOO_MANY_REQUESTS = 429
            const val INTERNAL_SERVER_ERROR = 500
            const val NOT_IMPLEMENTED = 501
            const val SERVICE_UNAVAILABLE = 503
        }
    }

    data class Throwable(val throwable: kotlin.Throwable) : Failure()
    data class CustomError(val errorCode: Int, val errorMessage: String?) : Failure()
}
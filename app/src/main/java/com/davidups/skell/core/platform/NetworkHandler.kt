package com.davidups.skell.core.platform

import android.content.Context
import com.davidups.skell.core.extensions.networkInfo


class NetworkHandler
(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnected
}
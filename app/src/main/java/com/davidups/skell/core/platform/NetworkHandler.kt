package com.davidups.skell.core.platform

import android.content.Context
import com.davidups.starwars.core.extensions.networkInfo


class NetworkHandler
(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnected
}
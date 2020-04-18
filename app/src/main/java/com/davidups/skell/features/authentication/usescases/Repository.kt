package com.davidups.skell.features.authentication.usescases

import com.davidups.skell.core.platform.NetworkHandler
import kotlinx.coroutines.CoroutineDispatcher

interface Repository {

    class Network(
        private val networkHandler: NetworkHandler,
        private val ioDispatcher: CoroutineDispatcher
    ) : Repository {}
}
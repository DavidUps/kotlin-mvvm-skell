package com.davidups.skell.features.authentication.usescases

import com.davidups.skell.core.platform.NetworkHandler
import com.davidups.skell.features.authentication.services.Service
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface Repository {

    fun getHoli(): Flow<String>

    class Network(
        private val networkHandler: NetworkHandler,
        private val ioDispatcher: CoroutineDispatcher
    ) : Repository {

        override fun getHoli(): Flow<String> {
            return flow {
                emit("pollas")
            }
                .flowOn(ioDispatcher)
        }

    }
}
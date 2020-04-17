package com.davidups.skell.features.authentication.usescases

import com.davidups.skell.core.platform.NetworkHandler
import com.davidups.skell.features.authentication.services.Service

interface Repository {

    class Network(
        private val networkHandler: NetworkHandler,
        private val service: Service
    ) : Repository {
    }
}
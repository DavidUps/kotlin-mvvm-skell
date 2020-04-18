package com.davidups.skell.core.di

import com.davidups.skell.features.authentication.usescases.Repository
import org.koin.dsl.module


val repositoryModule = module {

    factory<Repository> { Repository.Network(get(), get()) }

}
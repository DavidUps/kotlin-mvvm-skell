package com.davidups.skell.core.di

import com.davidups.skell.features.authentication.usescases.UseCaseExample
import org.koin.dsl.module

val useCaseModule = module {

    factory { UseCaseExample(get()) }
}
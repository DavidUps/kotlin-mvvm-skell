package com.davidups.skell.core.di

import android.content.Context
import android.content.SharedPreferences
import com.davidups.skell.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sharedModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            BuildConfig.APPLICATION_ID + "-" + BuildConfig.ENVIRONMENT,
            Context.MODE_PRIVATE
        )
    }
}

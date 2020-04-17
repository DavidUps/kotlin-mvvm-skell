package com.davidups.skell

import android.app.Application

class AndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        /*startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(listOf(
                networkModule,
                applicationModule,
                viewModelModule,
                useCaseModule,
                repositoryModule,
                dataSourceModule,
                databaseModule
            ))
        }*/
    }
}

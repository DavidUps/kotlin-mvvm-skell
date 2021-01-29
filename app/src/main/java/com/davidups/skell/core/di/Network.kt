package com.davidups.skell.core.di

import com.davidups.skell.BuildConfig
import com.davidups.skell.core.platform.ContextHandler
import com.davidups.skell.core.platform.NetworkHandler
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    val networkModule = module {
        factory { ContextHandler(get()) }
        factory { NetworkHandler(get()) }
        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.ENVIRONMENT_URL)
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single {
            Retrofit.Builder()
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
        }

        factory {
            Dispatchers.IO
        }
    }




}

private fun createClient(): OkHttpClient {
    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
    }
    return okHttpClientBuilder.build()
}

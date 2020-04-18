package com.davidups.skell.core.di

import com.davidups.skell.features.authentication.views.viewmodel.ViewModelTest
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { ViewModelTest(get()) }
}

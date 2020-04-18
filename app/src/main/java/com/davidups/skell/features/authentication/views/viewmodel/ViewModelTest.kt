package com.davidups.skell.features.authentication.views.viewmodel

import androidx.lifecycle.MutableLiveData
import com.davidups.skell.core.interactor.UseCase
import com.davidups.skell.core.platform.BaseViewModel
import com.davidups.skell.features.authentication.usescases.UseCaseExample
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewModelTest(private val useCaseExample: UseCaseExample) : BaseViewModel() {}
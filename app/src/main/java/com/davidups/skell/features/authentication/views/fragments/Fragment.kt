package com.davidups.skell.features.authentication.views.fragments

import android.os.Bundle
import android.util.Log
import com.davidups.skell.R
import com.davidups.skell.core.platform.BaseFragment
import com.davidups.skell.features.authentication.usescases.Repository
import com.davidups.skell.features.authentication.views.viewmodel.ViewModelTest
import org.koin.android.ext.android.inject

class Fragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_start

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
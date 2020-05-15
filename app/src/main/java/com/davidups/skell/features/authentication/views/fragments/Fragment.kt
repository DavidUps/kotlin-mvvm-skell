package com.davidups.skell.features.authentication.views.fragments

import android.os.Bundle
import com.davidups.skell.R
import com.davidups.skell.core.platform.BaseFragment
import com.davidups.skell.databinding.FragmentStartBinding
import com.davidups.starwars.core.platform.viewBinding.viewBinding

class Fragment: BaseFragment(R.layout.fragment_start) {

    val binding by viewBinding(FragmentStartBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
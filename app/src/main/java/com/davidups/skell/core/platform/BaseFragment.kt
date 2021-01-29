package com.davidups.skell.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.davidups.skell.core.extensions.navOptions
import com.davidups.skell.core.navigation.MainActivity
import kotlinx.android.synthetic.main.navigation_activity.*

abstract class BaseFragment(layout: Int) : Fragment() {

    val layouID = layout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layouID, container, false)

    internal fun showProgress() = progressStatus(View.VISIBLE)

    internal fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) {
            if (this is MainActivity) {
                this.progress.visibility = viewStatus
            }
        }

    internal fun showSpinner(show: Boolean) {
        when (show) {
            true -> showProgress()
            false -> hideProgress()
        }
    }

    internal fun navigate(action: Int) {
        requireView().findNavController().navigate(action, null, navOptions())
    }

    internal fun navigate(action: Int, bundle: Bundle) {
        requireView().findNavController().navigate(action, bundle, navOptions())
    }

    internal fun navigateUp() {
        requireView().findNavController().navigateUp()
    }

    internal fun showCommonError() {

    }

    internal open fun handleShowSpinner(show: Boolean?) {
        showSpinner(show ?: false)
    }
}
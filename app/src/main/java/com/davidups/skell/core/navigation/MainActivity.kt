package com.davidups.skell.core.navigation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.davidups.skell.R
import kotlinx.android.synthetic.main.navigation_activity.*

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)

        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->

            toolbar.title = when (destination.id) {
                else -> ""
            }
            toolbar.visibility = when (destination.id) {
                else -> View.VISIBLE
            }

            bottom_navigation.visibility = when (destination.id) {
                else -> View.VISIBLE
            }

            toolbar.visibility = when (destination.id) {
                else -> View.VISIBLE
            }

            //Controlamos que al cambiar de fragment no siga nuestro progress activo
            if (progress.visibility == View.VISIBLE) progress.visibility = View.GONE

        }

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.btnAccesibility -> {
                    true
                }
                R.id.btnEvents -> {
                    true
                }
                R.id.btnNews -> {
                    true
                }

                R.id.btnSpecialist -> {
                    true
                }
                R.id.btnProfile -> {
                    true
                }
                else -> true
            }
        }
    }

    public fun toolbarText(text: String) {
        toolbar.title = text
    }
}

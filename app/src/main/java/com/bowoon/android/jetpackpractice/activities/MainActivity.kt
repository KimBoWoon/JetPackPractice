package com.bowoon.android.jetpackpractice.activities

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.jetpackpractice.base.BaseActivityWithViewModel
import com.bowoon.android.jetpackpractice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivityWithViewModel<ActivityMainBinding, MainActivityViewModel>(
    R.layout.activity_main, MainActivityViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        initNavigation()
    }

    fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottom, navController)
    }
}
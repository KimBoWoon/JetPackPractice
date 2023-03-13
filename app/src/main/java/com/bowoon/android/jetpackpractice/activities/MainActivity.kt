package com.bowoon.android.jetpackpractice.activities

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.jetpackpractice.base.BaseActivityWithViewModel
import com.bowoon.android.jetpackpractice.databinding.ActivityMainBinding
import com.google.android.play.core.review.ReviewManagerFactory
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
        askReview()
    }

    fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottom, navController)
        binding.bottom.selectedItemId = R.id.home
    }

    private fun askReview() {
        val manager = ReviewManagerFactory.create(this)
        manager.requestReviewFlow().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("리뷰", "리뷰 인포 가져오기 성공")
                val reviewInfo = task.result
                manager.launchReviewFlow(this, reviewInfo).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("리뷰", "리뷰 쓰기 성공")
                    }
                }
            } else {
                Log.d("리뷰", "리뷰 쓰기 실패")
            }
        }
    }
}
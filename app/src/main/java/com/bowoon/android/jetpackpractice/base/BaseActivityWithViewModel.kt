package com.bowoon.android.jetpackpractice.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class BaseActivityWithViewModel<V : ViewDataBinding, ACT_VM : ViewModel>(
    @LayoutRes val layoutId: Int,
    private val viewModelClass: Class<ACT_VM>
) : AppCompatActivity() {
    protected val activityVM by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }
    protected lateinit var binding: V

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    open fun initBinding() {}
    open fun initLiveData() {}
}
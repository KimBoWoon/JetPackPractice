package com.bowoon.android.jetpackpractice.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class BaseFragmentWithViewModel<V : ViewDataBinding, VM : ViewModel, ACT_VM : ViewModel>(
    @LayoutRes
    private val layoutId: Int,
    private val fragmentVMClass: Class<VM>,
    private val activityVMClass: Class<ACT_VM>
) : Fragment() {
    protected val fragmentVM by lazy {
        ViewModelProvider(this).get(fragmentVMClass)
    }
    protected val activityVM by lazy {
        ViewModelProvider(this).get(activityVMClass)
    }
    protected lateinit var binding: V

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    open fun initBinding() {}
    open fun initLiveData() {}
}
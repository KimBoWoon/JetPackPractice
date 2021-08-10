package com.bowoon.android.jetpackpractice.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {
    override fun onCleared() {
        super.onCleared()
    }
}
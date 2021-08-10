package com.bowoon.android.jetpackpractice.fragment.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.jetpackpractice.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingFragmentViewModel @Inject constructor() : BaseViewModel() {
    val removeAllWish = MutableLiveData<Unit>()

    fun removeAllWish() {
        removeAllWish.value = Unit
    }
}
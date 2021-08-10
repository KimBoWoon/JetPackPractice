package com.bowoon.android.jetpackpractice.dialogs.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.jetpackpractice.base.BaseViewModel

class RemoveAllWishDialogViewModel : BaseViewModel() {
    val content = MutableLiveData<String>()
    val confirmContent = MutableLiveData<String>()
    val confirmClicked = MutableLiveData<Unit>()
    val cancelContent = MutableLiveData<String>()
    val cancelClicked = MutableLiveData<Unit>()

    fun init(content: String, confirmContent: String, cancelContent: String) {
        this.content.value = content
        this.confirmContent.value = confirmContent
        this.cancelContent.value = cancelContent
    }

    fun onConfirm() {
        confirmClicked.value = Unit
    }

    fun onCancel() {
        cancelClicked.value = Unit
    }
}
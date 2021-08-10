package com.bowoon.android.jetpackpractice.paging.viewholders

import androidx.core.view.isVisible
import androidx.paging.LoadState
import com.bowoon.android.jetpackpractice.base.BaseViewHolder
import com.bowoon.android.jetpackpractice.databinding.ViewholderLoadBinding

class LoadStateViewHolder(
    private val binding: ViewholderLoadBinding,
    private val retry: (() -> Unit)? = null
) : BaseViewHolder<LoadState>(binding.root) {
    override fun bind(loadState: LoadState) {
        binding.tvLoadText.isVisible = loadState is LoadState.Loading
        binding.pbNextLoading.isVisible = loadState is LoadState.Loading
        binding.bRetry.isVisible = loadState is LoadState.Error
    }

    fun retry() {
        retry?.invoke()
    }
}
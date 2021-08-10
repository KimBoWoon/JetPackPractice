package com.bowoon.android.jetpackpractice.paging.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.databinding.ViewholderLoadBinding
import com.bowoon.android.jetpackpractice.paging.viewholders.LoadStateViewHolder

class PokemonLoadPagingAdapter(
    private val retry: (() -> Unit)? = null
) : LoadStateAdapter<LoadStateViewHolder>() {
    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder =
        LoadStateViewHolder(ViewholderLoadBinding.inflate(LayoutInflater.from(parent.context), parent, false), retry)
}
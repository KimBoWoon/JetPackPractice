package com.bowoon.android.jetpackpractice.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<I>(
    private val binding: View
) : RecyclerView.ViewHolder(binding) {
    open fun bind(item: I) {}
}
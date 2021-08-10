package com.bowoon.android.jetpackpractice.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:loadImage")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view)
            .load(url)
            .fitCenter()
            .into(view)
    }
}
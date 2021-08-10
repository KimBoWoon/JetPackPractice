package com.bowoon.android.jetpackpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Pokemon(
    val name: String? = null,
    val url: String? = null
) : Parcelable {
    fun getImageUrl(): String {
        val index = url?.split("/".toRegex())?.dropLast(1)?.last()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }
}
package com.bowoon.android.jetpackpractice.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
//@Serializable
data class Pokemon(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null,
) : Parcelable {
    fun getImageUrl(): String {
        val index = url?.split("/".toRegex())?.dropLast(1)?.last()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }
}
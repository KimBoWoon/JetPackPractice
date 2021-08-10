package com.bowoon.android.jetpackpractice.util

import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.roundToInt

val Int.px: Int get() = (this.toFloat() * Resources.getSystem().displayMetrics.density).roundToInt()

fun Float.toPx(): Int {
    val r: Resources = Resources.getSystem()
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, r.displayMetrics).roundToInt()
}

val Float.px: Float get() = (this * Resources.getSystem().displayMetrics.density)
package com.bowoon.android.jetpackpractice.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ListItemDecoration : RecyclerView.ItemDecoration() {
    var rectMap = mutableMapOf<Int, Rect>()
    var defaultRect: Rect? = null
    var lastRect: Rect? = null

    fun add(pos: Int, rect: Rect) {
        rectMap[pos] = rect
    }

    fun others(rect: Rect) {
        defaultRect = rect
    }

    fun first(rect: Rect) {
        add(0, rect)
    }

    fun last(rect: Rect) {
        lastRect = rect
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        rectMap[pos]?.let {
            outRect.set(it)
        } ?: kotlin.run {
            defaultRect?.let {
                outRect.set(it)
            }
            lastRect?.let {
                if (pos == state.itemCount - 1) {
                    outRect.set(it)
                }
            }
        }
    }
}
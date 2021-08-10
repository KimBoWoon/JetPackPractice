package com.bowoon.android.jetpackpractice.util

import androidx.recyclerview.widget.DiffUtil
import com.bowoon.android.jetpackpractice.model.Pokemon

class PokemonDiffUtil(
    private val oldList: List<Pokemon>? = null,
    private val newList: List<Pokemon>? = null
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList?.size ?: 0

    override fun getNewListSize(): Int = newList?.size ?: 0

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList?.get(oldItemPosition) == newList?.get(newItemPosition)

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList?.get(oldItemPosition)?.name == newList?.get(newItemPosition)?.name &&
        oldList?.get(oldItemPosition)?.name == newList?.get(newItemPosition)?.name
}
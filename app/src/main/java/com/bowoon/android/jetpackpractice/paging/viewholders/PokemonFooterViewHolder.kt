package com.bowoon.android.jetpackpractice.paging.viewholders

import com.bowoon.android.jetpackpractice.base.BaseViewHolder
import com.bowoon.android.jetpackpractice.databinding.ViewholderPokemonFooterBinding

class PokemonFooterViewHolder(
    private val binding: ViewholderPokemonFooterBinding,
) : BaseViewHolder<String>(binding.root) {
    override fun bind(item: String) {
        binding.dto = item
    }
}
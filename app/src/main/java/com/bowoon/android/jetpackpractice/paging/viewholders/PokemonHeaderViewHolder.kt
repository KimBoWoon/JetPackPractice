package com.bowoon.android.jetpackpractice.paging.viewholders

import com.bowoon.android.jetpackpractice.base.BaseViewHolder
import com.bowoon.android.jetpackpractice.databinding.ViewholderPokemonHeaderBinding

class PokemonHeaderViewHolder(
    private val binding: ViewholderPokemonHeaderBinding,
) : BaseViewHolder<String>(binding.root) {
    override fun bind(item: String) {
        binding.dto = item
    }
}
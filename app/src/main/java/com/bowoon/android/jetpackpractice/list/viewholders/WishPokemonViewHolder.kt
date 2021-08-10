package com.bowoon.android.jetpackpractice.list.viewholders

import com.bowoon.android.jetpackpractice.base.BaseViewHolder
import com.bowoon.android.jetpackpractice.base.WISH_POKEMON_DETAIL
import com.bowoon.android.jetpackpractice.databinding.ViewholderWishPokemonBinding
import com.bowoon.android.jetpackpractice.fragment.viewmodels.WishPokemonListViewModel
import com.bowoon.android.jetpackpractice.room.WishPokemon

class WishPokemonViewHolder(
    private val binding: ViewholderWishPokemonBinding,
    private val fragmentVM: WishPokemonListViewModel? = null
) : BaseViewHolder<WishPokemon>(binding.root) {
    override fun bind(pokemon: WishPokemon) {
        binding.vh = this
        binding.dto = pokemon
    }

    fun goToDetail(pokemon: WishPokemon) {
        fragmentVM?.goToDetail?.value = Pair(WISH_POKEMON_DETAIL, pokemon)
    }
}
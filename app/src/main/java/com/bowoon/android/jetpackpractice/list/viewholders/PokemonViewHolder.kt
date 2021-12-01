package com.bowoon.android.jetpackpractice.list.viewholders

import com.bowoon.android.jetpackpractice.base.BaseViewHolder
import com.bowoon.android.jetpackpractice.base.POKEMON_DETAIL
import com.bowoon.android.jetpackpractice.databinding.ViewholderPokemonBinding
import com.bowoon.android.jetpackpractice.fragment.viewmodels.PokemonListFragmentViewModel
import com.bowoon.android.jetpackpractice.model.PokemonModel

class PokemonViewHolder(
    private val binding: ViewholderPokemonBinding,
    private val fragmentVM: PokemonListFragmentViewModel? = null
) : BaseViewHolder<PokemonModel.Pokemon>(binding.root) {
    override fun bind(pokemon: PokemonModel.Pokemon) {
        binding.vh = this
        binding.dto = pokemon
    }

    fun goToDetail(pokemon: PokemonModel.Pokemon) {
        fragmentVM?.goToDetail?.value = Pair(POKEMON_DETAIL, pokemon)
    }
}
package com.bowoon.android.jetpackpractice.paging.utils

import androidx.recyclerview.widget.DiffUtil
import com.bowoon.android.jetpackpractice.model.Pokemon
import com.bowoon.android.jetpackpractice.room.WishPokemon

object PokemonComparator : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name
    }
}

object WishPokemonComparator : DiffUtil.ItemCallback<WishPokemon>() {
    override fun areItemsTheSame(oldItem: WishPokemon, newItem: WishPokemon): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WishPokemon, newItem: WishPokemon): Boolean {
        return oldItem.name == newItem.name
    }
}
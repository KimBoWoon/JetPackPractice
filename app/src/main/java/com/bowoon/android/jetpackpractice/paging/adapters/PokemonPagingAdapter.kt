package com.bowoon.android.jetpackpractice.paging.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.jetpackpractice.databinding.ViewholderPokemonBinding
import com.bowoon.android.jetpackpractice.databinding.ViewholderWishPokemonBinding
import com.bowoon.android.jetpackpractice.fragment.viewmodels.PokemonListFragmentViewModel
import com.bowoon.android.jetpackpractice.fragment.viewmodels.WishPokemonListViewModel
import com.bowoon.android.jetpackpractice.list.viewholders.PokemonViewHolder
import com.bowoon.android.jetpackpractice.list.viewholders.WishPokemonViewHolder
import com.bowoon.android.jetpackpractice.model.Pokemon
import com.bowoon.android.jetpackpractice.room.WishPokemon

class PokemonPagingAdapter(
    private val diffUtil: DiffUtil.ItemCallback<Pokemon>,
    private val activityVM: MainActivityViewModel,
    private val fragmentVM: PokemonListFragmentViewModel
) : PagingDataAdapter<Pokemon, PokemonViewHolder>(diffUtil) {
    companion object {
        const val LOAD_VIEW_HOLDER = 0
        const val ITEM_VIEW_HOLDER = 1
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(ViewholderPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false), fragmentVM)
    }

    override fun getItemViewType(position: Int): Int =
        if (position == itemCount) {
            LOAD_VIEW_HOLDER
        } else {
            ITEM_VIEW_HOLDER
        }
}

class WishPokemonPagingAdapter(
    private val diffUtil: DiffUtil.ItemCallback<WishPokemon>,
    private val activityVM: MainActivityViewModel,
    private val fragmentVM: WishPokemonListViewModel
) : PagingDataAdapter<WishPokemon, WishPokemonViewHolder>(diffUtil) {
    companion object {
        const val LOAD_VIEW_HOLDER = 0
        const val ITEM_VIEW_HOLDER = 1
    }

    override fun onBindViewHolder(holder: WishPokemonViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishPokemonViewHolder {
        return WishPokemonViewHolder(ViewholderWishPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false), fragmentVM)
    }

    override fun getItemViewType(position: Int): Int =
        if (position == itemCount) {
            LOAD_VIEW_HOLDER
        } else {
            ITEM_VIEW_HOLDER
        }
}
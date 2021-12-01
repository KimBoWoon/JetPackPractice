package com.bowoon.android.jetpackpractice.paging.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.jetpackpractice.databinding.ViewholderPokemonBinding
import com.bowoon.android.jetpackpractice.databinding.ViewholderPokemonFooterBinding
import com.bowoon.android.jetpackpractice.databinding.ViewholderPokemonHeaderBinding
import com.bowoon.android.jetpackpractice.databinding.ViewholderWishPokemonBinding
import com.bowoon.android.jetpackpractice.fragment.viewmodels.PokemonListFragmentViewModel
import com.bowoon.android.jetpackpractice.fragment.viewmodels.WishPokemonListViewModel
import com.bowoon.android.jetpackpractice.list.viewholders.PokemonViewHolder
import com.bowoon.android.jetpackpractice.list.viewholders.WishPokemonViewHolder
import com.bowoon.android.jetpackpractice.model.PokemonModel
import com.bowoon.android.jetpackpractice.paging.viewholders.PokemonFooterViewHolder
import com.bowoon.android.jetpackpractice.paging.viewholders.PokemonHeaderViewHolder
import com.bowoon.android.jetpackpractice.room.WishPokemon

class PokemonPagingAdapter(
    private val activityVM: MainActivityViewModel,
    private val fragmentVM: PokemonListFragmentViewModel
) : PagingDataAdapter<PokemonModel, RecyclerView.ViewHolder>(PokemonComparator) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            when (it) {
                is PokemonModel.Pokemon -> { (holder as? PokemonViewHolder)?.bind(it) }
                is PokemonModel.PokemonHeader -> { (holder as? PokemonHeaderViewHolder)?.bind(it.title ?: "PokemonHeader") }
                is PokemonModel.PokemonFooter -> { (holder as? PokemonFooterViewHolder)?.bind(it.title ?: "PokemonFooter") }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.viewholder_pokemon -> { PokemonViewHolder(ViewholderPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false), fragmentVM) }
            R.layout.viewholder_pokemon_header -> { PokemonHeaderViewHolder(ViewholderPokemonHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)) }
            R.layout.viewholder_pokemon_footer -> { PokemonFooterViewHolder(ViewholderPokemonFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)) }
            else -> throw UnsupportedOperationException("Unknown view")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position < itemCount) {
            return when (getItem(position)) {
                is PokemonModel.Pokemon -> R.layout.viewholder_pokemon
                is PokemonModel.PokemonHeader -> R.layout.viewholder_pokemon_header
                is PokemonModel.PokemonFooter -> R.layout.viewholder_pokemon_footer
                null -> throw UnsupportedOperationException("Unknown view")
            }
        }

        return R.layout.viewholder_load
    }
}

class WishPokemonPagingAdapter(
    private val activityVM: MainActivityViewModel,
    private val fragmentVM: WishPokemonListViewModel
) : PagingDataAdapter<WishPokemon, WishPokemonViewHolder>(WishPokemonComparator) {
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
            R.layout.viewholder_load
        } else {
            R.layout.viewholder_pokemon
        }
}

object PokemonComparator : DiffUtil.ItemCallback<PokemonModel>() {
    override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
        return (oldItem as? PokemonModel.Pokemon)?.name == (newItem as? PokemonModel.Pokemon)?.name
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
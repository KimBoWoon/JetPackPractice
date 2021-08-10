//package com.bowoon.android.jetpackpractice.list.factory
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.bowoon.android.jetpackpractice.R
//import com.bowoon.android.jetpackpractice.base.BaseViewModel
//import com.bowoon.android.jetpackpractice.fragment.viewmodels.PokemonListFragmentViewModel
//import com.bowoon.android.jetpackpractice.fragment.viewmodels.WishPokemonListViewModel
//import com.bowoon.android.jetpackpractice.paging.adapters.ListType
//import com.bowoon.android.jetpackpractice.list.viewholders.PokemonViewHolder
//import com.bowoon.android.jetpackpractice.list.viewholders.WishPokemonViewHolder
//import com.bowoon.android.jetpackpractice.model.Pokemon
//
//object ViewHolderFactory {
//    fun onCreateViewHolder(listType: ListType, parent: ViewGroup, activityVM: BaseViewModel? = null, fragmentVM: BaseViewModel? = null): RecyclerView.ViewHolder {
//        return when (listType) {
//            ListType.POKEMON_LIST -> {
//                PokemonViewHolder(
//                    DataBindingUtil.inflate(LayoutInflater.from(parent.context),
//                        R.layout.viewholder_pokemon,
//                        parent,
//                        false), fragmentVM as? PokemonListFragmentViewModel
//                )
//            }
//            ListType.WISH_POKEMON_LIST -> {
//                WishPokemonViewHolder(
//                    DataBindingUtil.inflate(LayoutInflater.from(parent.context),
//                        R.layout.viewholder_pokemon,
//                        parent,
//                        false), fragmentVM as? WishPokemonListViewModel
//                )
//            }
//        }
//    }
//
//    fun <T> onBindViewHolder(holder: RecyclerView.ViewHolder, item: T, position: Int) {
//        when (holder) {
//            is PokemonViewHolder -> {
//                holder.bind(item as Pokemon)
//            }
//            is WishPokemonViewHolder -> {
//                holder.bind(item as Pokemon)
//            }
//        }
//    }
//}
//package com.bowoon.android.jetpackpractice.adapters
//
//import androidx.recyclerview.widget.DiffUtil
//import com.bowoon.android.jetpackpractice.base.BaseRecyclerViewAdapter
//import com.bowoon.android.jetpackpractice.paging.adapters.ListType
//import com.bowoon.android.jetpackpractice.model.Pokemon
//import com.bowoon.android.jetpackpractice.util.PokemonDiffUtil
//
//class PokemonListAdapter : BaseRecyclerViewAdapter<Pokemon>() {
//    override fun getItemViewType(position: Int): Int = ListType.POKEMON_LIST.ordinal
//
//    fun updateList(newList: List<Pokemon>) {
//        val diffutil = PokemonDiffUtil(items, newList)
//        val result = DiffUtil.calculateDiff(diffutil)
//
//        (items as? MutableList<Pokemon>)?.clear()
//        (items as? MutableList<Pokemon>)?.addAll(newList)
//        result.dispatchUpdatesTo(this)
//    }
//}
//
//class WishPokemonListAdapter : BaseRecyclerViewAdapter<Pokemon>() {
//    override fun getItemViewType(position: Int): Int = ListType.WISH_POKEMON_LIST.ordinal
//
//    fun updateList(newList: List<Pokemon>) {
//        val diffutil = PokemonDiffUtil(items, newList)
//        val result = DiffUtil.calculateDiff(diffutil)
//
//        (items as? MutableList<Pokemon>)?.clear()
//        (items as? MutableList<Pokemon>)?.addAll(newList)
//        result.dispatchUpdatesTo(this)
//    }
//}
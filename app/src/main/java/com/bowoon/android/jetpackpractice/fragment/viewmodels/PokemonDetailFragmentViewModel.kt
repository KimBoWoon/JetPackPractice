package com.bowoon.android.jetpackpractice.fragment.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.jetpackpractice.base.BaseViewModel
import com.bowoon.android.jetpackpractice.room.WishPokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailFragmentViewModel @Inject constructor() : BaseViewModel() {
    val addWish = MutableLiveData<WishPokemon>()
    val removeWish = MutableLiveData<WishPokemon>()
}
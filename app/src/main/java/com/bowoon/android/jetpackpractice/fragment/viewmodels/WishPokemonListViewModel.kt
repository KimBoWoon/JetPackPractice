package com.bowoon.android.jetpackpractice.fragment.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.bowoon.android.jetpackpractice.base.BaseViewModel
import com.bowoon.android.jetpackpractice.room.RoomHelper
import com.bowoon.android.jetpackpractice.room.WishPokemon
import com.bowoon.android.jetpackpractice.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WishPokemonListViewModel @Inject constructor(
    private val roomHelper: RoomHelper
) : BaseViewModel() {
    val goToDetail = SingleLiveEvent<Pair<Int, WishPokemon>>()
    val pager = Pager(config = PagingConfig(pageSize = 20)) {
        roomHelper.roomPokemonDao().getWishPokemon()
    }.flow.cachedIn(viewModelScope)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }
}
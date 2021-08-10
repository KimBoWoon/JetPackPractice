package com.bowoon.android.jetpackpractice.fragment.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.bowoon.android.jetpackpractice.base.BaseViewModel
import com.bowoon.android.jetpackpractice.model.Pokemon
import com.bowoon.android.jetpackpractice.paging.source.PokemonRemoteMediator
import com.bowoon.android.jetpackpractice.room.RoomHelper
import com.bowoon.android.jetpackpractice.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListFragmentViewModel @Inject constructor(
    private val roomHelper: RoomHelper,
    private val pokemonApi: com.bowoon.android.jetpackpractice.api.Pokemon
) : BaseViewModel() {
    val goToDetail = SingleLiveEvent<Pair<Int, Pokemon>>()
    @OptIn(ExperimentalPagingApi::class)
    val pokemonPageFlow = Pager(
        PagingConfig(pageSize = 20),
        remoteMediator = PokemonRemoteMediator(roomHelper, pokemonApi)
    ) {
        roomHelper.roomPokemonDao().getPokemonList()
    }.flow.cachedIn(viewModelScope)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }
}
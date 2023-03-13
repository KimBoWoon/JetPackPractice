package com.bowoon.android.jetpackpractice.fragment.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.bowoon.android.jetpackpractice.base.BaseViewModel
import com.bowoon.android.jetpackpractice.model.PokemonModel
import com.bowoon.android.jetpackpractice.paging.source.PokemonSource
import com.bowoon.android.jetpackpractice.room.RoomHelper
import com.bowoon.android.jetpackpractice.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PokemonListFragmentViewModel @Inject constructor(
    private val roomHelper: RoomHelper,
    private val pokemonApi: com.bowoon.android.jetpackpractice.api.Pokemon
) : BaseViewModel() {
    val goToDetail = SingleLiveEvent<Pair<Int, PokemonModel.Pokemon>>()
    @OptIn(ExperimentalPagingApi::class)
    val pokemonPageFlow: Flow<PagingData<PokemonModel>> = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 20)
//        remoteMediator = PokemonRemoteMediator(roomHelper, pokemonApi)
    ) {
        PokemonSource(pokemonApi)
//        roomHelper.roomPokemonDao().getPokemonList()
    }.flow.map {
        it.insertHeaderItem(item = PokemonModel.PokemonHeader("PokemonHeader"))
            .insertFooterItem(item = PokemonModel.PokemonFooter("PokemonFooter"))
    }.cachedIn(viewModelScope)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        20
    }
}
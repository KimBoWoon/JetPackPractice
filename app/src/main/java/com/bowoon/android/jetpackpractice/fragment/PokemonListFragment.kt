package com.bowoon.android.jetpackpractice.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.jetpackpractice.base.BaseFragmentWithViewModel
import com.bowoon.android.jetpackpractice.databinding.FragmentPokemonListBinding
import com.bowoon.android.jetpackpractice.dialogs.PokemonDialog
import com.bowoon.android.jetpackpractice.fragment.viewmodels.PokemonListFragmentViewModel
import com.bowoon.android.jetpackpractice.paging.adapters.PokemonLoadPagingAdapter
import com.bowoon.android.jetpackpractice.paging.adapters.PokemonPagingAdapter
import com.bowoon.android.jetpackpractice.paging.utils.PokemonComparator
import com.bowoon.android.jetpackpractice.room.WishPokemon
import com.bowoon.android.jetpackpractice.util.px
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListFragment : BaseFragmentWithViewModel<FragmentPokemonListBinding, PokemonListFragmentViewModel, MainActivityViewModel>(
    R.layout.fragment_pokemon_list,
    PokemonListFragmentViewModel::class.java,
    MainActivityViewModel::class.java
) {
    private val pokemonAdapter by lazy {
        PokemonPagingAdapter(PokemonComparator, activityVM, fragmentVM).apply {
            addLoadStateListener {
                if (it.source.refresh is LoadState.Error) {
                    binding.rvPokemonList.isVisible = false
                    binding.tvEmpty.text = (it.source.refresh as? LoadState.Error)?.error?.message
                    binding.tvEmpty.isVisible = true
                    binding.pbLoading.isVisible = false
                    PokemonDialog(
                        "네트워크에 문제가 있는거 같습니다.\n다시 연결하시겠습니까?",
                        "예",
                        { retry() },
                        "아니오",
                        {}
                    ).show(childFragmentManager, PokemonListFragment::class.java.simpleName)
                } else if (it.source.refresh is LoadState.NotLoading && it.append.endOfPaginationReached && (binding.rvPokemonList.adapter?.itemCount ?: 0) < 1) {
                    binding.rvPokemonList.isVisible = false
                    binding.tvEmpty.isVisible = true
                    binding.pbLoading.isVisible = false
                } else {
                    binding.rvPokemonList.isVisible = true
                    binding.tvEmpty.isVisible = false
                    binding.pbLoading.isVisible = false
                }
                when (it.append) {
                    is LoadState.Loading -> {
                        binding.pbLoading.isVisible = true
                    }
                    is LoadState.NotLoading -> {
                        binding.pbLoading.isVisible = false
                    }
                    is LoadState.Error -> {
                        binding.pbLoading.isVisible = false
                    }
                }
                when (it.refresh) {
                    is LoadState.Loading -> {
                        binding.pbLoading.isVisible = true
                    }
                    is LoadState.Error -> {
                        binding.pbLoading.isVisible = false
                    }
                    is LoadState.NotLoading -> {
                        binding.pbLoading.isVisible = false
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@PokemonListFragment
        }
        lifecycle.addObserver(fragmentVM)

        initBinding()
        initLiveData()
    }

    override fun initBinding() {
        binding.rvPokemonList.apply {
            adapter = pokemonAdapter.withLoadStateHeaderAndFooter(
                PokemonLoadPagingAdapter { pokemonAdapter.retry() },
                PokemonLoadPagingAdapter { pokemonAdapter.retry() }
            )
            layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int =
                        if (pokemonAdapter.getItemViewType(position) == PokemonPagingAdapter.LOAD_VIEW_HOLDER) {
                            2
                        } else {
                            1
                        }
                }
            }
            if (itemDecorationCount == 0) {
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        val position = parent.getChildLayoutPosition(view)
                        val size = parent.adapter?.itemCount ?: 0
                        if (position in 0 .. size) {
                            when {
                                position % 2 == 0 -> {
                                    outRect.left = 10.px
                                    outRect.right = 5.px
                                }
                                position % 2 == 1 -> {
                                    outRect.left = 5.px
                                    outRect.right = 10.px
                                }
                            }
                            outRect.top = 10.px
                        }
                    }
                })
            }
        }
    }

    override fun initLiveData() {
        lifecycleScope.launch {
            fragmentVM.pokemonPageFlow.collectLatest { pagingData ->
                pokemonAdapter.submitData(pagingData)
                binding.pbLoading.isVisible = false
                binding.tvEmpty.isVisible = false
            }
        }
        fragmentVM.goToDetail.observe(viewLifecycleOwner) { (type, pokemon) ->
            findNavController().navigate(PokemonListFragmentDirections.actionHomeToDetail(WishPokemon(name = pokemon.name ?: "", url = pokemon.url ?: ""), type))
        }
    }
}
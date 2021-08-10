package com.bowoon.android.jetpackpractice.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.jetpackpractice.base.BaseFragmentWithViewModel
import com.bowoon.android.jetpackpractice.base.POKEMON_DETAIL
import com.bowoon.android.jetpackpractice.base.WISH_POKEMON_DETAIL
import com.bowoon.android.jetpackpractice.databinding.FragmentPokemonDetailBinding
import com.bowoon.android.jetpackpractice.fragment.viewmodels.PokemonDetailFragmentViewModel
import com.bowoon.android.jetpackpractice.room.RoomHelper
import com.bowoon.android.jetpackpractice.room.WishPokemon
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class PokemonDetailFragment : BaseFragmentWithViewModel<FragmentPokemonDetailBinding, PokemonDetailFragmentViewModel, MainActivityViewModel>(
    R.layout.fragment_pokemon_detail,
    PokemonDetailFragmentViewModel::class.java,
    MainActivityViewModel::class.java
) {
    @Inject
    lateinit var roomHelper: RoomHelper
    private val pokemon by navArgs<PokemonDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@PokemonDetailFragment
            vm = fragmentVM
        }
        lifecycle.addObserver(fragmentVM)

        initBinding()
        initLiveData()
    }

    override fun initBinding() {
        pokemon.type.let {
            when (it) {
                POKEMON_DETAIL -> {
                    binding.bRegisterWish.text = "위시 등록"
                    binding.bRegisterWish.setOnClickListener {
                        fragmentVM.addWish.value = pokemon.pokemon
                    }
                }
                WISH_POKEMON_DETAIL -> {
                    binding.bRegisterWish.text = "위시 제거"
                    binding.bRegisterWish.setOnClickListener {
                        fragmentVM.removeWish.value = pokemon.pokemon
                    }
                }
            }
        }
        pokemon.pokemon?.let { pokemon ->
            binding.dto = pokemon
            binding.pbHpProgress.progress = Random.nextInt(300)
            binding.pbAtkProgress.progress = Random.nextInt(300)
            binding.pbDefProgress.progress = Random.nextInt(300)
            binding.pbSpdProgress.progress = Random.nextInt(300)
        }
    }

    override fun initLiveData() {
        fragmentVM.addWish.observe(viewLifecycleOwner) { pokemon ->
            lifecycleScope.launch(Dispatchers.IO) {
                val toastMessage = roomHelper.roomPokemonDao().findPokemon(pokemon.name)?.let {
                    "이미 등록되어 있습니다."
                } ?: kotlin.run {
                    roomHelper.roomPokemonDao().insert(WishPokemon(name = pokemon.name, url = pokemon.url))
                    "등록됐습니다."
                }
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                }
            }
        }
        fragmentVM.removeWish.observe(viewLifecycleOwner) { pokemon ->
            lifecycleScope.launch(Dispatchers.IO) {
                val toastMessage = roomHelper.roomPokemonDao().findPokemon(pokemon.name)?.let {
                    roomHelper.roomPokemonDao().delete(it)
                    "성공적 으로 제거 했습니다."
                } ?: kotlin.run {
                    "알 수 없는 오류로 인해 제거하지 못했습니다."
                }
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                }
            }
        }
    }
}
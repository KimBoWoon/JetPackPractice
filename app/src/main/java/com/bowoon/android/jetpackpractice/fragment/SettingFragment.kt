package com.bowoon.android.jetpackpractice.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.jetpackpractice.base.BaseFragmentWithViewModel
import com.bowoon.android.jetpackpractice.databinding.FragmentSettingBinding
import com.bowoon.android.jetpackpractice.dialogs.RemoveAllWishDialog
import com.bowoon.android.jetpackpractice.fragment.viewmodels.SettingFragmentViewModel
import com.bowoon.android.jetpackpractice.room.RoomHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragmentWithViewModel<FragmentSettingBinding, SettingFragmentViewModel, MainActivityViewModel>(
        R.layout.fragment_setting,
        SettingFragmentViewModel::class.java,
        MainActivityViewModel::class.java
) {
    @Inject
    lateinit var roomHelper: RoomHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@SettingFragment
            vm = fragmentVM
        }
        lifecycle.addObserver(fragmentVM)

        initBinding()
        initLiveData()
    }

    override fun initBinding() {
        binding.tvRemoveAllWish.text = "위시 모두 제거"
    }

    override fun initLiveData() {
        fragmentVM.removeAllWish.observe(viewLifecycleOwner) {
            RemoveAllWishDialog(
                "위시 리스트에 저장된 모든 포켓몬들이 사라집니다.\n정말 삭제하시겠습니까?",
                "삭제",
                {
                    lifecycleScope.launch(Dispatchers.IO) {
                        roomHelper.roomPokemonDao().getWishPokemonList()?.let {
                            val toastMessage = if (it.isEmpty()) {
                                "위시 리스트에 저장된 포켓몬이 없습니다."
                            } else {
                                roomHelper.roomPokemonDao().wishDeleteAll()
                                "위시 리스트를 모두 삭제했습니다."
                            }
                            withContext(Dispatchers.Main) {
                                Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                },
                "취소",
                {}
            ).show(childFragmentManager, SettingFragment::class.java.simpleName)
        }
    }
}
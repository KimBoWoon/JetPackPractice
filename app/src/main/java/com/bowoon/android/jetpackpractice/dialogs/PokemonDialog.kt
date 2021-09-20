package com.bowoon.android.jetpackpractice.dialogs

import android.os.Bundle
import android.view.View
import com.bowoon.android.jetpackpractice.R
import com.bowoon.android.jetpackpractice.base.BaseDialogWithViewModel
import com.bowoon.android.jetpackpractice.databinding.DialogRemoveAllWishBinding
import com.bowoon.android.jetpackpractice.dialogs.viewmodels.PokemonDialogViewModel

class PokemonDialog(
    private val content: String,
    private val confirmContent: String,
    private val confirmClicked: (() -> Unit)? = null,
    private val cancelContent: String,
    private val cancelClicked: (() -> Unit)? = null,
) : BaseDialogWithViewModel<DialogRemoveAllWishBinding, PokemonDialogViewModel>(
    R.layout.pokemon_dialog, PokemonDialogViewModel::class.java, true, false
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@PokemonDialog
            vm = fragmentVM
        }

        fragmentVM.init(content, confirmContent, cancelContent)
        initBinding()
        initLiveData()
    }

    private fun initBinding() {

    }

    private fun initLiveData() {
        fragmentVM.confirmClicked.observe(viewLifecycleOwner) {
            confirmClicked?.invoke()
            dismissAllowingStateLoss()
        }
        fragmentVM.cancelClicked.observe(viewLifecycleOwner) {
            cancelClicked?.invoke()
            dismissAllowingStateLoss()
        }
    }
}
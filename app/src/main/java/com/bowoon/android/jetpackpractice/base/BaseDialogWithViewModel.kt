package com.bowoon.android.jetpackpractice.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.*
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.bowoon.android.jetpackpractice.util.toPx

open class BaseDialogWithViewModel<V : ViewDataBinding, VM: BaseViewModel>(
    @LayoutRes private val layoutId: Int,
    private val fragmentViewModelClass: Class<VM>,
    private val fullWidth: Boolean = true,
    private val fullHeight: Boolean = false
) : DialogFragment() {
    protected lateinit var binding: V
    protected val fragmentVM by lazy {
        ViewModelProvider(this).get(fragmentViewModelClass)
    }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.let { window ->
            if (fullWidth && fullHeight) {
                window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                window.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.WHITE

            } else if (fullWidth) {
                val back = ColorDrawable(Color.TRANSPARENT)
                val inset = InsetDrawable(back, 20f.toPx())
                window.setBackgroundDrawable(inset)

                window.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    if (fullHeight) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
                )
            } else {
                window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                window.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    if (fullHeight) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(true)
        return dialog
    }
}
package com.korol.myapplication.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.korol.myapplication.R
import com.korol.myapplication.app.App
import com.korol.myapplication.common.IsNotHomeData
import com.korol.myapplication.databinding.FragmentCartBinding
import com.korol.myapplication.ui.home.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CartFragment : Fragment(R.layout.fragment_cart) {
    private val viewBinding: FragmentCartBinding by viewBinding()

    @javax.inject.Inject
    lateinit var vmFactory: CartViewModelFactory
    private lateinit var viewModel: CartViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity?.applicationContext as App).appComponent.injectCartFragment(this)
        viewModel = ViewModelProvider(this, vmFactory).get(CartViewModel::class.java)

        viewBinding.apply {
            lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    launch {
                        viewModel.stateFlow.collect {
                            if (it.basket != null) {
                                Log.d("my_tag", "basket = ${it.basket}")
                            }
                        }
                    }

                    launch {
                        viewModel.sideEffect.collectLatest {
                            if (it is IsNotHomeData) {
                                writeError(view, it.errorMessage)
                            }
                        }
                    }
                }
            }
        }

    }

    private fun writeError(view: View, error: String) {
        val snackBarView =
            Snackbar.make(view, error, Snackbar.LENGTH_INDEFINITE)
                .setTextColor(ContextCompat.getColor(requireContext(), R.color.error_text))
                .setAction("Retry") {
                    viewModel.onRetryClick()
                }
        val sbView = snackBarView.view
        val params = sbView.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        sbView.layoutParams = params
        snackBarView.animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
        snackBarView.show()
    }
}
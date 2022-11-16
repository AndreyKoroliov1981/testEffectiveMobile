package com.korol.myapplication.ui.cart

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.korol.domain.cart.CartInteractor
import com.korol.myapplication.common.BaseViewModel
import com.korol.myapplication.common.IsNotCartData
import kotlinx.coroutines.launch

class CartViewModel(private val cartInteractor: CartInteractor) :
    BaseViewModel<CartState>(CartState()) {

    init {
        updateData()
    }

    private fun updateData() {
        viewModelScope.launch {
            try {
                val data = cartInteractor.getCart()
                updateState {
                    copy(
                        basket = data
                    )
                }
            } catch (e: Exception) {
                Log.d("my_tag", "cart data error = ${e.message}")
                sideEffectSharedFlow.emit(IsNotCartData(errorMessage = e.message.toString()))
            }
        }
    }

    fun onRetryClick() {
        updateData()
    }

}
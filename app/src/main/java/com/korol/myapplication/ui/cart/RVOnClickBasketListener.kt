package com.korol.myapplication.ui.cart

import com.korol.network.api.cart.model.Gadget

interface RVOnClickBasketListener {
    fun onClicked(item: Gadget)
}
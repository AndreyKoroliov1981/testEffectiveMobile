package com.korol.myapplication.ui.cart

import com.korol.network.api.cart.model.Gadget

interface RVOnClickCountListener {
    fun onClicked(item: Gadget, delta: Int)
}
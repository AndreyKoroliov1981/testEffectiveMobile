package com.korol.repository.cart

import com.korol.network.api.cart.model.Basket

interface CartRepository {
    suspend fun getCart(): Basket
}
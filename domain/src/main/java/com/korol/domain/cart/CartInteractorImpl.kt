package com.korol.domain.cart

import com.korol.network.api.cart.model.Basket
import com.korol.repository.cart.CartRepository

class CartInteractorImpl(
    private val cartRepository: CartRepository
) : CartInteractor {
    override suspend fun getCart(): Basket {
        return cartRepository.getCart()
    }
}
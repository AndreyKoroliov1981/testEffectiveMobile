package com.korol.domain.details

import com.korol.network.api.detail.model.ProductDetails

interface DetailsInteractor {
    suspend fun getDetails(id: Int): ProductDetails
}
package com.korol.repository.detail

import com.korol.network.api.detail.model.ProductDetails

interface DetailsRepository {
    suspend fun getDetails(id: Int) : ProductDetails
}
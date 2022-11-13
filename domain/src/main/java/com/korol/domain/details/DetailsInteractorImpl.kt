package com.korol.domain.details

import com.korol.network.api.detail.model.ProductDetails
import com.korol.repository.detail.DetailsRepository

class DetailsInteractorImpl(
    private val detailsRepository: DetailsRepository
): DetailsInteractor {
    override suspend fun getDetails(id: Int): ProductDetails {
        return detailsRepository.getDetails(id)
    }
}
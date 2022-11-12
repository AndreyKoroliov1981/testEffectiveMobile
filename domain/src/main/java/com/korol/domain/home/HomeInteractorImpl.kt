package com.korol.domain.home

import com.korol.network.api.home.model.HotSalesAndBestSeller
import com.korol.repository.home.HomeRepository

class HomeInteractorImpl(
    private val homeRepository: HomeRepository
): HomeInteractor {
    override suspend fun getHotSalesAndBestSeller(): HotSalesAndBestSeller {
        return homeRepository.getHotSalesAndBestSeller()
    }


}
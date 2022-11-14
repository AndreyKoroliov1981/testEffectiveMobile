package com.korol.repository.detail

import com.korol.network.api.detail.DetailsRetrofitServices
import com.korol.network.api.detail.model.ProductDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailsRepositoryImpl(
    private val detailsMapper: DetailsMapper,
    private val detailsRetrofitServices: DetailsRetrofitServices
) : DetailsRepository {
    override suspend fun getDetails(id: Int): ProductDetails =
        withContext(Dispatchers.IO) {
        val response = detailsRetrofitServices.getDetails().execute().body()
        val data = detailsMapper.mapDetailsFromNetwork(response!!)
        return@withContext data
    }
}
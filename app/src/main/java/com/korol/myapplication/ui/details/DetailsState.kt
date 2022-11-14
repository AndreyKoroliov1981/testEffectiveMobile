package com.korol.myapplication.ui.details

import com.korol.network.api.detail.model.ProductDetails

data class DetailsState(
    val currentImage: Int = 0,
    val detailsInfo: ProductDetails? = null,
    val initPager: Boolean = false
)
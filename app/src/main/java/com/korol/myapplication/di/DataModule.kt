package com.korol.myapplication.di

import com.korol.network.api.detail.DetailsCommon
import com.korol.network.api.detail.DetailsRetrofitServices
import com.korol.network.api.home.HomeCommon
import com.korol.network.api.home.HomeRetrofitServices
import com.korol.repository.detail.DetailsMapper
import com.korol.repository.detail.DetailsRepository
import com.korol.repository.detail.DetailsRepositoryImpl
import com.korol.repository.home.HomeMapper
import com.korol.repository.home.HomeRepository
import com.korol.repository.home.HomeRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideHomeRepository(
        homeMapper: HomeMapper,
        homeRetrofitServices: HomeRetrofitServices
    ): HomeRepository {
        return HomeRepositoryImpl(
            homeMapper = homeMapper,
            homeRetrofitServices = homeRetrofitServices
        )
    }

    @Provides
    fun provideHomeMapper(): HomeMapper {
        return HomeMapper()
    }

    @Provides
    fun provideHomeRetrofitServices(): HomeRetrofitServices {
        return HomeCommon.homeRetrofitService
    }

    @Provides
    fun provideDetailsRepository(
        detailsMapper: DetailsMapper,
        detailsRetrofitServices: DetailsRetrofitServices
    ): DetailsRepository {
        return DetailsRepositoryImpl(
            detailsMapper = detailsMapper,
            detailsRetrofitServices = detailsRetrofitServices
        )
    }

    @Provides
    fun provideDetailsMapper(): DetailsMapper {
        return DetailsMapper()
    }

    @Provides
    fun provideDetailsRetrofitServices(): DetailsRetrofitServices {
        return DetailsCommon.detailsRetrofitService
    }
}
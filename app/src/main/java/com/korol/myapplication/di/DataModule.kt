package com.korol.myapplication.di

import com.korol.network.api.home.HomeCommon
import com.korol.network.api.home.HomeRetrofitServices
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
}
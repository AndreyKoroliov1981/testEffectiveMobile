package com.korol.myapplication.di

import com.korol.domain.home.HomeInteractor
import com.korol.domain.home.HomeInteractorImpl
import com.korol.repository.home.HomeRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideHomeInteractor(homeRepository: HomeRepository): HomeInteractor {
        return HomeInteractorImpl(homeRepository = homeRepository)
    }
}
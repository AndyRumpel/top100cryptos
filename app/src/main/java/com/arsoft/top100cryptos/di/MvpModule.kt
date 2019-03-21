package com.arsoft.top100cryptos.di

import com.arsoft.top100cryptos.mvp.presenters.CurrenciesPresenter
import com.arsoft.top100cryptos.mvp.presenters.LatestChartPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): CurrenciesPresenter = CurrenciesPresenter()

    @Provides
    @Singleton
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()

}
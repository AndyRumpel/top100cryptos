package com.arsoft.top100cryptos.di

import com.arsoft.top100cryptos.activities.MainActivity
import com.arsoft.top100cryptos.fragments.CurrenciesListFragment
import com.arsoft.top100cryptos.mvp.presenters.CurrenciesPresenter
import com.arsoft.top100cryptos.mvp.presenters.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class, RestModule::class, MvpModule::class, ChartModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)
    fun inject(fragment: CurrenciesListFragment)

}
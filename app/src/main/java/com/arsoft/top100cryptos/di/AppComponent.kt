package com.arsoft.top100cryptos.di

import com.arsoft.top100cryptos.activities.ChartActivity
import com.arsoft.top100cryptos.activities.MainActivity
import com.arsoft.top100cryptos.chart.LatestChart
import com.arsoft.top100cryptos.fragments.CurrenciesListFragment
import com.arsoft.top100cryptos.mvp.presenters.CurrenciesPresenter
import com.arsoft.top100cryptos.mvp.presenters.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class, RestModule::class, MvpModule::class, ChartModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(activity: ChartActivity)
    fun inject(fragment: CurrenciesListFragment)
    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)
    fun inject(chart: LatestChart)
}
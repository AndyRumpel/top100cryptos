package com.arsoft.top100cryptos.di

import com.arsoft.top100cryptos.chart.LatestChart
import com.arsoft.top100cryptos.helpers.YearValueFormatter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ChartModule {

    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()

    @Provides
    @Singleton
    fun provideYearValueFormatter() = YearValueFormatter()

}
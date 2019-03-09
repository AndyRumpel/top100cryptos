package com.arsoft.top100cryptos.di

import com.arsoft.top100cryptos.activities.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}
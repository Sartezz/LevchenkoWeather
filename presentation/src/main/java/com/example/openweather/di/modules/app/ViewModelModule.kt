package com.example.openweather.di.modules.app

import com.example.domain.repository.WeatherInfoRepository
import com.example.openweather.ui.WeatherInfoViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModelFactory(weatherInfoRepository: WeatherInfoRepository): WeatherInfoViewModelFactory =
        WeatherInfoViewModelFactory(weatherInfoRepository)
}
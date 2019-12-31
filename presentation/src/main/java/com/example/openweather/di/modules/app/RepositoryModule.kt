package com.example.openweather.di.modules.app

import com.example.data.repository.WeatherInfoInfoRepositoryImpl
import com.example.domain.repository.WeatherInfoRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideRepository(weatherApi: WeatherInfoInfoRepositoryImpl): WeatherInfoRepository
}
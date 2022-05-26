package com.example.mywwatherapp.di

import com.example.mywwatherapp.data.datasource.WeatherDataSource
import com.example.mywwatherapp.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRequestDataSource(retrofit: Retrofit): WeatherDataSource {
        return retrofit.create(WeatherDataSource::class.java)
    }

    @Singleton
    @Provides
    fun provideRequestRepository(weatherDataSource: WeatherDataSource): WeatherRepository {
        return WeatherRepository(weatherDataSource)
    }
}
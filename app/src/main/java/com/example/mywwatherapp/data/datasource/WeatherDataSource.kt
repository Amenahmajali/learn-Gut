package com.example.mywwatherapp.data.datasource

import com.example.mywwatherapp.data.model.BaseWrapper
import com.example.mywwatherapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherDataSource {

    @GET("weather.ashx?tp=1&date=today&format=json&num_of_days=1?")
    suspend fun getWeather(
        @Query("q") q: String,
        @Query("key") key: String,

        ): BaseWrapper<WeatherResponse>

}
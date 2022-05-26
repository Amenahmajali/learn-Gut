package com.example.mywwatherapp.data.repository

import android.provider.Contacts.SettingsColumns.KEY
import com.example.mywwatherapp.data.datasource.WeatherDataSource
import com.example.mywwatherapp.data.model.WeatherCity
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
){
suspend fun getWeather(query:String):WeatherCity{

    val currentCondition = weatherDataSource.getWeather(query, KEY ).data.currentCondition[0]

return WeatherCity(query,"${currentCondition.tempC} C",currentCondition.observationTime)
}

    companion object{
        const val KEY="d5e964b0eb3949268a373148222303"
    }

}
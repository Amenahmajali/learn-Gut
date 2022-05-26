package com.example.mywwatherapp.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywwatherapp.data.model.WeatherCity
import com.example.mywwatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository )
    : ViewModel() {


    private val _loadingHomeLiveData = MutableLiveData(false)
    val loadingLiveData: LiveData<Boolean> = _loadingHomeLiveData

    private val _errorLiveData=MutableLiveData<Throwable>()
    val errorLiveData :LiveData<Throwable> =_errorLiveData

    private val _successCitiesLiveData=MutableLiveData<List<WeatherCity>>()
    val successCitiesLiveData:LiveData<List<WeatherCity>> = _successCitiesLiveData

 private val _successSearchLiveData=MutableLiveData<WeatherCity>()
    val successSearchLiveData:LiveData<WeatherCity> = _successSearchLiveData


    init {
        getWeathers()
    }

    fun getWeatherSearch(query:String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingHomeLiveData.postValue(true)
            try {
                _successSearchLiveData.postValue(weatherRepository.getWeather(query))
            } catch (e: Exception) {
                _errorLiveData.postValue(e)
            }
            _loadingHomeLiveData.postValue(false)
        }
    }

    private fun getWeathers() {
        val cities = listOf(AMMAN,IRBID,JARASH,AJLUN,ZARQA)

        viewModelScope.launch(Dispatchers.IO) {
            _loadingHomeLiveData.postValue(true)
            try {
                val weatherCities: ArrayList<WeatherCity> = ArrayList()

                for (city in cities) {
                    weatherCities.add(weatherRepository.getWeather(city))
                }
                _successCitiesLiveData.postValue(weatherCities)
            } catch (e: Exception) {
                _errorLiveData.postValue(e)
            }
            _loadingHomeLiveData.postValue(false)
        }
    }

    companion object{
        const val AMMAN ="AMMAN"
        const val IRBID ="IRBID"
        const val JARASH="JARASH"
        const val AJLUN="AJLUN"
        const val ZARQA="ZARQ"

    }


}
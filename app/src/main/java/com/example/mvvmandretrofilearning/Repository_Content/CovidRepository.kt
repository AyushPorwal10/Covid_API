package com.example.mvvmandretrofilearning.Repository_Content

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmandretrofilearning.MyModels.Covid_Country_Info
import com.example.mvvmandretrofilearning.MyModels.StatisticsModel
import com.example.mvvmandretrofilearning.Retrofit_Conent.Retrofit_Interface

class CovidRepository(private val retrofitInterface: Retrofit_Interface) {
    private val countriesmutableData = MutableLiveData<Covid_Country_Info>()
    private val statisticsmutableData = MutableLiveData<StatisticsModel>()

    val countriesLiveData : LiveData<Covid_Country_Info>
        get() = countriesmutableData
    val statisticsLiveData : LiveData<StatisticsModel>
        get() = statisticsmutableData



   suspend fun getCountriesList() : Covid_Country_Info {
        val covidCountryInfo =  retrofitInterface.getCountriesList()
        countriesmutableData.postValue(covidCountryInfo)
       return covidCountryInfo
    }

    suspend fun getStatistics() : StatisticsModel{
        val statistics = retrofitInterface.getStatistics()
        statisticsmutableData.postValue(statistics)
        return statistics
    }
}
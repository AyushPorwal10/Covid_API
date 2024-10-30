package com.example.mvvmandretrofilearning.ViewModel_Content

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmandretrofilearning.MyModels.Covid_Country_Info
import com.example.mvvmandretrofilearning.MyModels.StatisticsModel
import com.example.mvvmandretrofilearning.Repository_Content.CovidRepository
import kotlinx.coroutines.launch

class MainViewModel(private val covidRepository: CovidRepository) :ViewModel(){



    init {
        viewModelScope.launch{
            covidRepository.getCountriesList()
            covidRepository.getStatistics()
        }
    }
    val countriesList : LiveData<Covid_Country_Info>
        get() = covidRepository.countriesLiveData

    val statistics : LiveData<StatisticsModel>
        get() = covidRepository.statisticsLiveData
}
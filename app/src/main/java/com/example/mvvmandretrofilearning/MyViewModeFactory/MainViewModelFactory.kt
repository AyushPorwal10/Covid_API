package com.example.mvvmandretrofilearning.MyViewModeFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmandretrofilearning.Repository_Content.CovidRepository
import com.example.mvvmandretrofilearning.ViewModel_Content.MainViewModel

class MainViewModelFactory(private val covidRepository: CovidRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(covidRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
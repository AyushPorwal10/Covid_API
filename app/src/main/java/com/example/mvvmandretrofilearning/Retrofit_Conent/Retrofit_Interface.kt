package com.example.mvvmandretrofilearning.Retrofit_Conent

import com.example.mvvmandretrofilearning.MyModels.Covid_Country_Info
import com.example.mvvmandretrofilearning.MyModels.StatisticsModel
import retrofit2.http.GET


interface Retrofit_Interface {

    @GET("countries")
    suspend fun getCountriesList() : Covid_Country_Info

    @GET("statistics")
    suspend fun getStatistics() : StatisticsModel

}
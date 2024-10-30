package com.example.mvvmandretrofilearning

import com.example.mvvmandretrofilearning.MyModels.Cases
import com.example.mvvmandretrofilearning.MyModels.Deaths
import com.example.mvvmandretrofilearning.MyModels.Tests

data class Response(
    val cases: Cases,
    val continent: String,
    val country: String,
    val day: String,
    val deaths: Deaths,
    val population: Int,
    val tests: Tests,
    val time: String
)
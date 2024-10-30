package com.example.mvvmandretrofilearning.MyModels

import com.example.mvvmandretrofilearning.Response

data class StatisticsModel(
    val errors: List<Any>,
    val `get`: String,
    val parameters: List<Any>,
    val response: List<Response>,
    val results: Int
)
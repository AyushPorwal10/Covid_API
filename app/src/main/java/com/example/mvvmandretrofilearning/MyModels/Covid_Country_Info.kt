package com.example.mvvmandretrofilearning.MyModels

data class Covid_Country_Info(
    val errors: List<Any>,
    val `get`: String,
    val parameters: List<Any>,
    val response: List<String>,  // this is list of country
    val results: Int
)
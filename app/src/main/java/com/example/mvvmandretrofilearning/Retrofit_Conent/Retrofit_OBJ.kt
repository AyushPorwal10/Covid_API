package com.example.mvvmandretrofilearning.Retrofit_Conent

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_OBJ {

    val BASE_URL = "https://covid-193.p.rapidapi.com/"
    private val API_KEY = "958f1b2498mshd2549ec2620595cp1efabajsnda88dd1e9bb6"
    private const val API_HOST = "covid-193.p.rapidapi.com"
    fun getInstance(): Retrofit {

        val interceptor = Interceptor { chain ->
            val original: Request = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("x-rapidapi-key", API_KEY)
                .addHeader("x-rapidapi-host", API_HOST)

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }

        // Build the OkHttpClient with the interceptor
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        return Retrofit.Builder()
         .baseUrl(BASE_URL)
         .client(client)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
    }
}
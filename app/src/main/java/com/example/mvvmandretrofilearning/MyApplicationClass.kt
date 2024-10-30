package com.example.mvvmandretrofilearning

import android.app.Application
import com.example.mvvmandretrofilearning.Repository_Content.CovidRepository
import com.example.mvvmandretrofilearning.Retrofit_Conent.Retrofit_Interface
import com.example.mvvmandretrofilearning.Retrofit_Conent.Retrofit_OBJ

class MyApplicationClass : Application(){
    val db = Retrofit_OBJ.getInstance().create(Retrofit_Interface::class.java)
    val repository by lazy { CovidRepository(db)}
}
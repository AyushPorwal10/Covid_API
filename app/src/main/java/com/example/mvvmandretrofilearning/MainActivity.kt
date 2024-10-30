package com.example.mvvmandretrofilearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandretrofilearning.MyAdapters.CountryListAdapter
import com.example.mvvmandretrofilearning.MyViewModeFactory.MainViewModelFactory
import com.example.mvvmandretrofilearning.Repository_Content.CovidRepository
import com.example.mvvmandretrofilearning.Retrofit_Conent.Retrofit_Interface
import com.example.mvvmandretrofilearning.Retrofit_Conent.Retrofit_OBJ
import com.example.mvvmandretrofilearning.ViewModel_Content.MainViewModel
import com.example.mvvmandretrofilearning.databinding.ActivityMainBinding
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var countryListAdapter: CountryListAdapter
    lateinit var countryListRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mainViewModel : MainViewModel by viewModels{
            MainViewModelFactory((application as MyApplicationClass).repository)
        }
        countryListRecyclerView = binding.countryListRecylerView

        countryListAdapter = CountryListAdapter(this)
        countryListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.countryListRecylerView.adapter = countryListAdapter


        mainViewModel.countriesList.observe(this , Observer {
            Log.d("Testing","The number of countries is ${it.results}")

            countryListAdapter.submitList(it.response)
        })


    }
}
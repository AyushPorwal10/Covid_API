package com.example.mvvmandretrofilearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmandretrofilearning.MyViewModeFactory.MainViewModelFactory
import com.example.mvvmandretrofilearning.ViewModel_Content.MainViewModel
import com.example.mvvmandretrofilearning.databinding.ActivityShowCountryDetailsBinding

class ShowCountryDetails : AppCompatActivity() {
    lateinit var binding:ActivityShowCountryDetailsBinding
    lateinit var response: List<Response>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val country = intent.getStringExtra("country")
        Log.d("Testing","Showing information for $country")
         val viewModel: MainViewModel by viewModels {
            MainViewModelFactory((application as MyApplicationClass).repository)
        }
        viewModel.statistics.observe(this , Observer {
            //iterate through list of response

             response = it.response
              for(item in response){
                  // if resonse contry matches current country shows details
                  if(item.country.equals(country)){
                      binding.response = item
                      break
                  }
              }
        })
    }
}
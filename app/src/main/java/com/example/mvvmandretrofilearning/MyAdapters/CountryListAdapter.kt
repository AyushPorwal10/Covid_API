package com.example.mvvmandretrofilearning.MyAdapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mvvmandretrofilearning.ShowCountryDetails
import com.example.mvvmandretrofilearning.databinding.CountryListBinding

class CountryListAdapter(val context: Context) : ListAdapter<String,CountryListAdapter.CountryViewHolder >(StringDiffCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryListBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context , ShowCountryDetails::class.java)
            intent.putExtra("country",getItem(position))
            context.startActivity(intent)
        })
    }
    class CountryViewHolder(private val binding : CountryListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind( country : String){
            binding.country.text = country
        }

    }


    class StringDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem // Compare items by their content
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem // Compare items by their content
        }
    }

}
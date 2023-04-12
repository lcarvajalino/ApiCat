package com.prueba.apppp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.prueba.apppp.viewmodels.CatViewModel
import com.prueba.apppp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var userViewModel: CatViewModel? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel = ViewModelProvider(this).get(CatViewModel::class.java)
        userViewModel!!.getCats()?.observe(this) { listCats ->

            binding.rvBreeds.layoutManager = LinearLayoutManager(this)
            binding.rvBreeds.adapter = CatsAdapter(listCats)
        }
    }
}
package com.example.extratime

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.extratime.core.data.Resource
import com.example.extratime.databinding.ActivityMainBinding
import com.example.extratime.presentation.viewmodel.LeagueViewModel
import com.example.extratime.presentation.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        val leagueViewModel = ViewModelProvider(this, factory)[LeagueViewModel::class.java]

        leagueViewModel.getLeagues().observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.tvWelcome.text = "Loading"
                }
                is Resource.Success -> {
                    val leagues = resource.data ?: emptyList()
                    binding.tvWelcome.text = leagues.joinToString(",\n") { league ->
                        league.strLeague
                    }
                }
                is Resource.Error -> {
                    binding.tvWelcome.text = "Error"
                }
            }
        }
    }
}
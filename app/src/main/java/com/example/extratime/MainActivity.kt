package com.example.extratime

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.extratime.databinding.ActivityMainBinding
import com.example.extratime.domain.LeagueEntity
import com.example.extratime.presentation.viewmodel.LeagueViewModel
import com.example.extratime.presentation.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val leagues: List<LeagueEntity> = listOf(
        LeagueEntity("4328", "English Premier League", "Soccer"),
        LeagueEntity("4329", "English League Championship", "Soccer"),
        LeagueEntity("4331", "German Bundesliga", "Soccer")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance()
        val leagueViewModel = ViewModelProvider(this, factory)[LeagueViewModel::class.java]

        leagueViewModel.setLeagues(leagues)
        leagueViewModel.getLeagues().observe(this) { leagues ->
            binding.tvWelcome.text = leagues.joinToString(",\n") { league -> league.strLeague}
        }
    }
}
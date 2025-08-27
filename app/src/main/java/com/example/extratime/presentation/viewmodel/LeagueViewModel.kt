package com.example.extratime.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.extratime.domain.LeagueEntity
import com.example.extratime.domain.LeagueUseCase

class LeagueViewModel(private val leagueUseCase: LeagueUseCase) : ViewModel() {
    private val _leagues = MutableLiveData<List<LeagueEntity>>()

    fun getLeagues() : LiveData<List<LeagueEntity>> {
        return _leagues
    }

    fun setLeagues(leagues: List<LeagueEntity>) {
        _leagues.value = leagueUseCase.getLeagues()
    }
}
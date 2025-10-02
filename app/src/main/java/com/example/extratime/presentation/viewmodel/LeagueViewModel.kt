package com.example.extratime.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.extratime.core.data.Resource
import com.example.extratime.core.domain.model.League
import com.example.extratime.core.domain.usecase.LeagueUseCase

class LeagueViewModel(private val leagueUseCase: LeagueUseCase) : ViewModel() {

    fun getLeagues() : LiveData<Resource<List<League>>> {
        return leagueUseCase.getLeagues()
    }
}
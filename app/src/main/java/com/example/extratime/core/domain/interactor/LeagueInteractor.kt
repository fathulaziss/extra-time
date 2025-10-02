package com.example.extratime.core.domain.interactor

import androidx.lifecycle.LiveData
import com.example.extratime.core.data.Resource
import com.example.extratime.core.domain.model.League
import com.example.extratime.core.domain.repository.ILeagueRepository
import com.example.extratime.core.domain.usecase.LeagueUseCase

class LeagueInteractor(private val leagueRepository: ILeagueRepository) : LeagueUseCase {

    override fun getLeagues(): LiveData<Resource<List<League>>> {
        return leagueRepository.getLeagues();
    }

}
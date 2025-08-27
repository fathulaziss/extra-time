package com.example.extratime.domain

class LeagueInteractor(private val leagueRepository: ILeagueRepository) : LeagueUseCase {
    override fun getLeagues(): List<LeagueEntity> {
        return leagueRepository.getLeagues()
    }
}
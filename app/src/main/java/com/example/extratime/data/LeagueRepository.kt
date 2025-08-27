package com.example.extratime.data

import com.example.extratime.domain.ILeagueRepository
import com.example.extratime.domain.LeagueEntity

class LeagueRepository(private val leagueDataSource: ILeagueDataSource) : ILeagueRepository {
    override fun getLeagues(): List<LeagueEntity> {
        return leagueDataSource.getLeaguesFromSource()
    }
}
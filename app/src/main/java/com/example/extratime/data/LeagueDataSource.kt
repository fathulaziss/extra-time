package com.example.extratime.data

import com.example.extratime.domain.LeagueEntity

class LeagueDataSource : ILeagueDataSource {
    override fun getLeaguesFromSource(): List<LeagueEntity> {
        return listOf(
            LeagueEntity("4328", "English Premier League", "Soccer"),
            LeagueEntity("4329", "English League Championship", "Soccer"),
            LeagueEntity("4331", "German Bundesliga", "Soccer")
        )
    }
}
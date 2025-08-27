package com.example.extratime.data

import com.example.extratime.domain.LeagueEntity

interface ILeagueDataSource {
    fun getLeaguesFromSource() : List<LeagueEntity>
}
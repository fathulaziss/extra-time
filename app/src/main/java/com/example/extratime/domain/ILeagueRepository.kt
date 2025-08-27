package com.example.extratime.domain

interface ILeagueRepository {
    fun getLeagues() : List<LeagueEntity>
}
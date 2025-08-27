package com.example.extratime.domain

interface LeagueUseCase {
    fun getLeagues() : List<LeagueEntity>
}
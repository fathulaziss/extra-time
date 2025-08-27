package com.example.extratime.di

import com.example.extratime.data.ILeagueDataSource
import com.example.extratime.data.LeagueDataSource
import com.example.extratime.data.LeagueRepository
import com.example.extratime.domain.ILeagueRepository
import com.example.extratime.domain.LeagueInteractor
import com.example.extratime.domain.LeagueUseCase

object Injection {
    fun provideLeagueUseCase(): LeagueUseCase {
        val leagueRepository = provideLeagueRepository()
        return LeagueInteractor(leagueRepository)
    }

    private fun provideLeagueRepository(): ILeagueRepository {
        val leagueDataSource = provideLeagueDataSource()
        return LeagueRepository(leagueDataSource)
    }

    private fun provideLeagueDataSource(): ILeagueDataSource {
        return LeagueDataSource()
    }
}
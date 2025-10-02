package com.example.extratime.core.di

import android.content.Context
import com.example.extratime.core.data.repository.LeagueRepository
import com.example.extratime.core.data.source.local.LocalDataSource
import com.example.extratime.core.data.source.local.room.DatabaseApp
import com.example.extratime.core.data.source.remote.RemoteDataSource
import com.example.extratime.core.data.source.remote.network.ApiConfig
import com.example.extratime.core.domain.interactor.LeagueInteractor
import com.example.extratime.core.domain.repository.ILeagueRepository
import com.example.extratime.core.domain.usecase.LeagueUseCase
import com.example.extratime.core.utils.AppExecutors

object Injection {
    private fun provideLeagueRepository(context: Context): ILeagueRepository {
        val database = DatabaseApp.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideLeagueService())
        val localDataSource = LocalDataSource.getInstance(database.leagueDao())
        val appExecutors = AppExecutors()

        return LeagueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideLeagueUseCase(context: Context): LeagueUseCase {
        val repository = provideLeagueRepository(context)
        return LeagueInteractor(repository)
    }
}
package com.example.extratime.core.data.source.local

import androidx.lifecycle.LiveData
import com.example.extratime.core.data.source.local.dao.LeagueDao
import com.example.extratime.core.data.source.local.entity.LeagueEntity

class LocalDataSource private constructor(
    private val leagueDao: LeagueDao
) {
    // League-related functions
    fun getLeagues(): LiveData<List<LeagueEntity>> = leagueDao.getLeagues()

    fun getFavoriteLeagues(): LiveData<List<LeagueEntity>> = leagueDao.getFavoriteLeagues()

    fun insertLeagues(leagues: List<LeagueEntity>) {
        for (entity in leagues) {
            leagueDao.insert(entity)
        }
    }

    fun setFavoriteLeague(league: LeagueEntity, isFavorite: Boolean) {
        league.isFavorite = isFavorite
        leagueDao.update(league)
    }

    companion object {
        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(
            leagueDao: LeagueDao
        ): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(leagueDao).also { instance = it }
            }
    }
}
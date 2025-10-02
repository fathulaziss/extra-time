package com.example.extratime.core.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.extratime.core.data.NetworkBoundResource
import com.example.extratime.core.data.Resource
import com.example.extratime.core.data.source.local.LocalDataSource
import com.example.extratime.core.data.source.remote.RemoteDataSource
import com.example.extratime.core.data.source.remote.dto.LeagueDto
import com.example.extratime.core.data.source.remote.network.ApiResponse
import com.example.extratime.core.domain.model.League
import com.example.extratime.core.domain.repository.ILeagueRepository
import com.example.extratime.core.mapper.LeagueMapper
import com.example.extratime.core.utils.AppExecutors

class LeagueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ILeagueRepository {

    override fun getLeagues(): LiveData<Resource<List<League>>> =
        object : NetworkBoundResource<List<League>, List<LeagueDto>>(appExecutors) {

            override fun loadFromDB(): LiveData<List<League>> {
                return localDataSource.getLeagues().map {
                    LeagueMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldRequestFromApi(data: List<League>?): Boolean {
                // fetch data from api if data is empty on database is empty
//                return data.isNullOrEmpty()
                // always fetch data from api
                 return true
            }

            override fun fetchFromApi(): LiveData<ApiResponse<List<LeagueDto>>> {
                return remoteDataSource.getLeagues()
            }

            override fun saveApiResult(data: List<LeagueDto>) {
                val leagues = LeagueMapper.mapResponseToEntities(data)
                localDataSource.insertLeagues(leagues)
            }

        }.asLiveData()

    companion object {
        @Volatile
        private var instance: LeagueRepository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ) : LeagueRepository =
            instance ?: synchronized(this) {
                instance ?: LeagueRepository(remoteDataSource, localDataSource, appExecutors)
            }
    }

}
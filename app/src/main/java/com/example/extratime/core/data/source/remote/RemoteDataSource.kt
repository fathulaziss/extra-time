package com.example.extratime.core.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.extratime.core.data.source.remote.dto.LeagueDto
import com.example.extratime.core.data.source.remote.network.ApiResponse
import com.example.extratime.core.data.source.remote.response.LeagueResponse
import com.example.extratime.core.data.source.remote.services.LeagueService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val leagueService: LeagueService) {

    fun getLeagues(): LiveData<ApiResponse<List<LeagueDto>>> {
        val result = MutableLiveData<ApiResponse<List<LeagueDto>>>()

        val client = leagueService.getLeagues()

        client.enqueue(object : Callback<LeagueResponse> {
            override fun onResponse(
                call: Call<LeagueResponse?>,
                response: Response<LeagueResponse?>,
            ) {
                val leagues = response.body()?.leagues
                result.value = if (leagues != null) ApiResponse.Success(leagues) else ApiResponse.Empty
            }

            override fun onFailure(
                call: Call<LeagueResponse?>,
                response: Throwable,
            ) {
                result.value = ApiResponse.Error(response.message.toString())
            }
        })

        return result
    }

    companion object {
        private val TAG : String = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(
            leagueService: LeagueService
        ): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(leagueService).also { instance = it }
            }
    }
}
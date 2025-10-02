package com.example.extratime.core.data.source.remote.services

import com.example.extratime.core.data.source.remote.response.LeagueResponse
import retrofit2.Call
import retrofit2.http.GET

interface LeagueService {
    @GET("all_leagues.php")
    fun getLeagues(): Call<LeagueResponse>
}
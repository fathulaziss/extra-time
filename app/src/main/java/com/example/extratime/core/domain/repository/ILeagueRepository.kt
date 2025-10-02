package com.example.extratime.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.extratime.core.data.Resource
import com.example.extratime.core.domain.model.League

interface ILeagueRepository {

    fun getLeagues(): LiveData<Resource<List<League>>>

}
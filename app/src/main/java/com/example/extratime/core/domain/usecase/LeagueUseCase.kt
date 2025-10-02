package com.example.extratime.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.extratime.core.data.Resource
import com.example.extratime.core.domain.model.League

interface LeagueUseCase {

    fun getLeagues(): LiveData<Resource<List<League>>>

}
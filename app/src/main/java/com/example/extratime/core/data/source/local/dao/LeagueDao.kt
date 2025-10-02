package com.example.extratime.core.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.extratime.core.data.source.local.entity.LeagueEntity

@Dao
interface LeagueDao : BaseDao<LeagueEntity> {
    @Query("SELECT * FROM league")
    fun getLeagues() : LiveData<List<LeagueEntity>>

    @Query("SELECT * FROM league where isFavorite = 1")
    fun getFavoriteLeagues() : LiveData<List<LeagueEntity>>
}
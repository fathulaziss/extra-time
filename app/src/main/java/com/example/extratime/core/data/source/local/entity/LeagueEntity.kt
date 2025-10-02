package com.example.extratime.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "league",
    indices = [Index(value = ["id_league"])]
)
data class LeagueEntity(
    @PrimaryKey
    @ColumnInfo(name = "id_league")
    val idLeague : String,

    @ColumnInfo(name = "str_league")
    val strLeague : String,

    @ColumnInfo(name = "str_sport")
    val strSport : String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)

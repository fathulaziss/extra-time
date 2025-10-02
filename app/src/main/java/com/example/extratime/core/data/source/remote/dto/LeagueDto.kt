package com.example.extratime.core.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class LeagueDto(
    @field:SerializedName("idLeague")
    val idLeague: String,

    @field:SerializedName("strLeague")
    val strLeague: String,

    @field:SerializedName("strSport")
    val strSport: String
)

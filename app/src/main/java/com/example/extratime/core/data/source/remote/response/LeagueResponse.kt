package com.example.extratime.core.data.source.remote.response

import com.example.extratime.core.data.source.remote.dto.LeagueDto
import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("leagues")
    val leagues: List<LeagueDto>
)

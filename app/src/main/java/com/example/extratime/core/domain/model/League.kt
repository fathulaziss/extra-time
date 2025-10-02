package com.example.extratime.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    val idLeague : String,
    val strLeague : String,
    val strSport : String
) : Parcelable
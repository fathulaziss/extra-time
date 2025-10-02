package com.example.extratime.core.data.source.remote.network

import com.example.extratime.core.data.source.remote.services.LeagueService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiConfig {

    private val retrofit: Retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(12, TimeUnit.SECONDS)
            .readTimeout(12, TimeUnit.SECONDS)
            .writeTimeout(12, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://www.thesportsdb.com/api/v1/json/123/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideLeagueService(): LeagueService {
        return retrofit.create(LeagueService::class.java)
    }
}
package com.example.extratime.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.extratime.core.data.source.local.dao.LeagueDao
import com.example.extratime.core.data.source.local.entity.LeagueEntity

@Database(entities = [LeagueEntity::class], version = 1, exportSchema = false)
abstract class DatabaseApp : RoomDatabase() {

    abstract fun leagueDao() : LeagueDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseApp? = null

        fun getInstance(context: Context): DatabaseApp =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseApp::class.java,
                    "extra_time.db"
                ).fallbackToDestructiveMigration(false).build()
                INSTANCE = instance
                instance
            }
    }

}
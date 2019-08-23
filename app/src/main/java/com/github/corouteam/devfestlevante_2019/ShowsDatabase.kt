package com.github.corouteam.devfestlevante_2019

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.corouteam.devfestlevante_2019.models.Show

@Database(entities = arrayOf(Show::class), version = 1)
abstract class ShowsDatabase: RoomDatabase() {
    abstract fun showDao(): ShowDao


    companion object {
        @Volatile
        private var INSTANCE: ShowsDatabase? = null

        fun getDatabase(context: Context): ShowsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShowsDatabase::class.java,
                    "Wo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
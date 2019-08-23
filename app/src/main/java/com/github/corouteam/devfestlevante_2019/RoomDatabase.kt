package com.github.corouteam.devfestlevante_2019

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.corouteam.devfestlevante_2019.models.Show

@Database(entities = arrayOf(Show::class), version = 1)
abstract class ShowsDatabase: RoomDatabase() {
    abstract fun showDao(): ShowDao
}
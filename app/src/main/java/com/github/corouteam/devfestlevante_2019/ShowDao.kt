package com.github.corouteam.devfestlevante_2019

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.github.corouteam.devfestlevante_2019.models.Show

@Dao
interface ShowDao {
    @Insert
    fun insertShow(show: Show)

    @Update
    fun updateShow(show: Show)

    @Query("select * from shows where id = :id")
    fun getShow(id: Int): LiveData<Show>

    @Query("select * from shows")
    fun getShows(): LiveData<List<Show>>
}
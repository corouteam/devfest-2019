package com.github.corouteam.devfestlevante_2019

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.github.corouteam.devfestlevante_2019.models.Show

class ShowViewModel(application: Application): AndroidViewModel(application) {
    val dao = ShowsDatabase.getDatabase(application).showDao()
    val repo = ShowRepository(dao)

    fun getShow(): LiveData<Show> = repo.getShow()
}
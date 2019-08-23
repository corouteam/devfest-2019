package com.github.corouteam.devfestlevante_2019

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.corouteam.devfestlevante_2019.models.Show
import java.util.concurrent.Executor

class ShowViewModel(application: Application): AndroidViewModel(application) {
    val dao = ShowsDatabase.getDatabase(application)
    //val repo = ShowRepository(dao)

   // fun getShow(): LiveData<Show> = repo.getShow()
}
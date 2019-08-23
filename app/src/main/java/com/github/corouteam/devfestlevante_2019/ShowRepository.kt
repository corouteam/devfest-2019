package com.github.corouteam.devfestlevante_2019

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.room.RoomDatabase
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import com.github.corouteam.devfestlevante_2019.models.Show
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.concurrent.Executor

class ShowRepository(val showDao: ShowDao) {


    fun getShow() = liveData(Dispatchers.IO) {
        emitSource(showDao.getShow(43467))
        val show  = RetrofitClient.getWebservice().getShow("43467").execute().body()!!.tvShow
        showDao.insertShow(show)
    }





}
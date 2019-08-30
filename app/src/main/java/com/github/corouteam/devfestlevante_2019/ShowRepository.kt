package com.github.corouteam.devfestlevante_2019

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import java.net.UnknownHostException

class ShowRepository(val showDao: ShowDao) {


    fun getShow() = liveData(Dispatchers.IO) {
        emitSource(showDao.getShow(43467))

        // Retrofit will go UnknownHostException if there's no network
        try {

            val show = RetrofitClient.getWebservice().getShow("43467").execute().body()!!.tvShow
            showDao.insertShow(show)

        } catch (e: UnknownHostException) {
            e.printStackTrace()
        }
    }
}
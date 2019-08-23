package com.github.corouteam.devfestlevante_2019

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import com.github.corouteam.devfestlevante_2019.models.Show
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowRepository {
    val liveData = MutableLiveData<Show>()

    fun getShow(): LiveData<Show> {
        RetrofitClient.getWebservice().getShow("43467").enqueue(object: Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                liveData.value = response.body()!!.tvShow
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }
        })

        return liveData
    }
}
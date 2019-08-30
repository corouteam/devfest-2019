package com.github.corouteam.devfestlevante_2019

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import com.github.corouteam.devfestlevante_2019.models.Show
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowRepository {
    val showLiveData = MutableLiveData<Show>()

    fun getShow(): LiveData<Show> {
        val liveData = MutableLiveData<Show>()

        RetrofitClient.getWebservice().getShow(SHOW_ID).enqueue(object: Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                liveData.value = response.body()!!.tvShow
            }

        })

        return liveData
    }
}
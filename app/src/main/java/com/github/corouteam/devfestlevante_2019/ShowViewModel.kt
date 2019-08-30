package com.github.corouteam.devfestlevante_2019

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import com.github.corouteam.devfestlevante_2019.models.Show
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowViewModel: ViewModel() {
    val repository = ShowRepository()

    fun getShow(): LiveData<Show> = repository.getShow()


}
package com.github.corouteam.devfestlevante_2019

import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {

    @GET("/api/show-details")
    fun getShow(
        @Query(value = "q") showId: String
    ): Call<ApiResponse>
}
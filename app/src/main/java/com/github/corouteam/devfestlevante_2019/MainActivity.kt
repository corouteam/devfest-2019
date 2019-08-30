package com.github.corouteam.devfestlevante_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val SHOW_ID = "43467"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: Create data class for response
        // Ex: https://www.episodate.com/api/show-details?q={SHOW_ID}
        // Will respond with:
        /*
            {
                "tvShow":{
                    "id":43467,
                    "name":"Lucifer",
                    "permalink":"lucifer",
                    "url":"https:\/\/www.episodate.com\/tv-show\/lucifer",
                    "description":"The Devil has come to Los Angeles\u2026Based upon the characters created by Neil Gaiman, Sam Kieth and Mike Dringenberg for DC Entertainment's Vertigo imprint, Lucifer<\/b> is the story of the original fallen angel. Bored and unhappy as the Lord of Hell, Lucifer Morningstar has abandoned his throne and retired to L.A., where he owns Lux, an upscale nightclub",
                    "start_date":"2016-01-25",
                    "country":"US"
                }
            }

         */

        // TODO: Get data from webservice
        RetrofitClient.getWebservice().getShow(SHOW_ID).enqueue(object: Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                titleTextView.text = response.body()!!.tvShow.name
            }

        })



    }


}

package com.github.corouteam.devfestlevante_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import com.github.corouteam.devfestlevante_2019.models.Show
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitClient.getWebservice().getShow("43467").enqueue(object: Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                titleTextView.text = response.body()?.tvShow?.name
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }
        })
    }
}

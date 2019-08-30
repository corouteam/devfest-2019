package com.github.corouteam.devfestlevante_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import com.github.corouteam.devfestlevante_2019.models.Show
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val SHOW_ID = "43467"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData().observe(this, Observer {
            titleTextView.text = it.name
        })

    }

    fun getData(): LiveData<Show> {
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

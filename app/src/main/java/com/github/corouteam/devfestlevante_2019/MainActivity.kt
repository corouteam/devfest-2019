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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getShowAsLiveData().observe(this, Observer {
            titleTextView.text = it.name
        })
    }

    fun getShowAsLiveData(): LiveData<Show> {
        val liveData = MutableLiveData<Show>()

        RetrofitClient.getWebservice().getShow("43467").enqueue(object: Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                liveData.value = response.body()!!.tvShow
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }
        })

        return liveData
    }
}

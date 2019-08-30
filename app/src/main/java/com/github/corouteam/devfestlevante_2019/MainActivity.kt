package com.github.corouteam.devfestlevante_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.corouteam.devfestlevante_2019.models.ApiResponse
import com.github.corouteam.devfestlevante_2019.models.Show
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val SHOW_ID = "43467"

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ShowViewModel::class.java)



        viewModel.getShow().observe(this, Observer {
            titleTextView.text = it.name
        })

    }



}

package com.github.corouteam.devfestlevante_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewmodel = ViewModelProviders.of(this).get(ShowViewModel::class.java)

        viewmodel.getShow().observe(this, Observer {
            titleTextView.text = it.name
        })
    }


}

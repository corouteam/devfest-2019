package com.github.corouteam.devfestlevante_2019

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.github.corouteam.devfestlevante_2019.models.Show

class ShowViewModel: ViewModel() {
    val repo = ShowRepository()

    fun getShow(): LiveData<Show> = repo.getShow()
}
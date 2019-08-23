package com.github.corouteam.devfestlevante_2019.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shows")
data class Show(
    @PrimaryKey
    val id: Int,
    val name: String
)
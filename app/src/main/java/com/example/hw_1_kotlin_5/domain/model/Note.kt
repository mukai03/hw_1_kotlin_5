package com.example.hw_1_kotlin_5.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Note (
    val id : Int = DEFAULT_ID,
    val title : String,
    val text : String
){
    companion object {
        const val DEFAULT_ID = 0
    }
}
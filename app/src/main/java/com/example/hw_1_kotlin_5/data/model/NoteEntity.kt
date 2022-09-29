package com.example.hw_1_kotlin_5.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity (

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val text : String
)
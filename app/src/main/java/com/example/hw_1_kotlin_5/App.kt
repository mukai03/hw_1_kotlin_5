package com.example.hw_1_kotlin_5

import android.app.Application
import androidx.room.Room
import com.example.hw_1_kotlin_5.data.localdb.NoteDateBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){
    companion object{
        lateinit var roomNoteDatabase : NoteDateBase
    }

    override fun onCreate() {
        super.onCreate()
        roomNoteDatabase = Room.databaseBuilder(
            applicationContext,
            NoteDateBase::class.java,
            "note_db"
        ).allowMainThreadQueries()
            .build()
    }
}
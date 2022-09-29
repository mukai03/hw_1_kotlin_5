package com.example.hw_1_kotlin_5.data.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_1_kotlin_5.data.model.NoteEntity

@Database(entities = [NoteEntity :: class], version = 1)
abstract class NoteDateBase : RoomDatabase(){

    abstract fun noteDao() : NoteDao

}
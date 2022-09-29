package com.example.hw_1_kotlin_5.domain.repository

import com.example.hw_1_kotlin_5.domain.model.Note

interface NoteRepository {

    fun createNote(note : Note)

    fun editNote(note : Note)

    fun deleteNote(note : Note)

    fun getAllNotes()
}
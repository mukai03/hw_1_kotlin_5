package com.example.hw_1_kotlin_5.domain.repository

import com.example.hw_1_kotlin_5.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note : Note) : Flow<Unit>

    fun editNote(note : Note) : Flow<Unit>

    fun deleteNote(note : Note) : Flow<Unit>

    fun getAllNotes() : Flow<List<Note>>
}
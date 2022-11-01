package com.example.hw_1_kotlin_5.domain.repository

import com.example.hw_1_kotlin_5.domain.model.Note
import com.example.hw_1_kotlin_5.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun createNote(note : Note) : Flow<Resource<Unit>>
    fun editNote(note : Note) : Flow<Resource<Unit>>
    fun deleteNote(note : Note) : Flow<Resource<Unit>>
    fun getAll() : Flow<Resource<List<Note>>>
}
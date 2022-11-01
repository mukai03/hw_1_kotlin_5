package com.example.hw_1_kotlin_5.data.repository

import com.example.hw_1_kotlin_5.data.base.BaseRepository
import com.example.hw_1_kotlin_5.data.localdb.NoteDao
import com.example.hw_1_kotlin_5.data.mapper.noteEntityToNote
import com.example.hw_1_kotlin_5.data.mapper.noteToNoteEntity
import com.example.hw_1_kotlin_5.domain.model.Note
import com.example.hw_1_kotlin_5.domain.repository.NoteRepository
import com.example.hw_1_kotlin_5.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao :  NoteDao
) : NoteRepository, BaseRepository() {

    override  fun createNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.createNote(note.noteToNoteEntity())
    }

    override  fun editNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.edit(note.noteToNoteEntity())
    }

    override  fun deleteNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.deleteNote(note.noteToNoteEntity())
    }

    override fun getAll(): Flow<Resource<List<Note>>> = doRequest {
        noteDao.getAllNotes().map { it.noteEntityToNote() }
    }
}
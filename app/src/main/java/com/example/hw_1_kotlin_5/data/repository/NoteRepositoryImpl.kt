package com.example.hw_1_kotlin_5.data.repository

import com.example.hw_1_kotlin_5.App
import com.example.hw_1_kotlin_5.data.mapper.noteToNoteEntity
import com.example.hw_1_kotlin_5.domain.model.Note
import com.example.hw_1_kotlin_5.domain.repository.NoteRepository

class NoteRepositoryImpl : NoteRepository {

    private val noteDao = App.roomNoteDatabase.noteDao()

    override fun createNote(note: Note) {
        noteDao.createNote(note.noteToNoteEntity())
    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.noteToNoteEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.createNote(note.noteToNoteEntity())
    }

    override fun getAllNotes() {
        noteDao.getAllNotes()
    }
}
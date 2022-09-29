package com.example.hw_1_kotlin_5.data.mapper

import com.example.hw_1_kotlin_5.data.model.NoteEntity
import com.example.hw_1_kotlin_5.domain.model.Note

fun Note.noteToNoteEntity() = NoteEntity(
    id=id,
    title=title,
    text=text
)

fun NoteEntity.noteEntityToNote() = Note(
    id=id,
    title=title,
    text=text
)
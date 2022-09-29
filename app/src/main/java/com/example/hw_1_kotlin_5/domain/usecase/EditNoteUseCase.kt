package com.example.hw_1_kotlin_5.domain.usecase

import com.example.hw_1_kotlin_5.domain.model.Note
import com.example.hw_1_kotlin_5.domain.repository.NoteRepository

class EditNoteUseCase(
    private val noteRepository: NoteRepository) {

    fun editNote(note: Note) = noteRepository.editNote(note)

}
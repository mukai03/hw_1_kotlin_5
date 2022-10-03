package com.example.hw_1_kotlin_5.domain.usecase

import com.example.hw_1_kotlin_5.domain.model.Note
import com.example.hw_1_kotlin_5.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository) {

    fun createNote(note: Note) = noteRepository.createNote(note)

}
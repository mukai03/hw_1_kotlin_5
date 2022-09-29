package com.example.hw_1_kotlin_5.domain.usecase

import com.example.hw_1_kotlin_5.domain.repository.NoteRepository

class GetAllNotesUseCase(
    private val noteRepository: NoteRepository) {

    fun getAllNotes() = noteRepository.getAllNotes()

}
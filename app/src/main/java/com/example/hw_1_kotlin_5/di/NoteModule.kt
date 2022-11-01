package com.example.hw_1_kotlin_5.di

import android.content.Context
import androidx.room.Room
import com.example.hw_1_kotlin_5.data.localdb.NoteDao
import com.example.hw_1_kotlin_5.data.localdb.NoteDateBase
import com.example.hw_1_kotlin_5.data.repository.NoteRepositoryImpl
import com.example.hw_1_kotlin_5.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) : NoteDateBase =
        Room.databaseBuilder(
            context,
            NoteDateBase::class.java,
            "note_db"
        ).allowMainThreadQueries()
            .build()


    @Singleton
    @Provides
    fun provideNoteDao(noteDateBase: NoteDateBase) : NoteDao = noteDateBase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao : NoteDao) : NoteRepository = NoteRepositoryImpl(noteDao)

}
package com.example.hw_1_kotlin_5.data.localdb

import androidx.room.*
import com.example.hw_1_kotlin_5.data.model.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("Select * from notes order by title ASC")
    suspend fun getAllNotes() : List<NoteEntity>

    @Update
    suspend fun edit(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}
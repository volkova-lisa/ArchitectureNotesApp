package com.example.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.data.entities.NoteBody

@Dao
interface AppRoomDao {
    @Query("SELECT * from notes_tables")
    fun getAllNotes():LiveData<List<NoteBody>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteBody)

    @Delete
    suspend fun delete(note: NoteBody)
}
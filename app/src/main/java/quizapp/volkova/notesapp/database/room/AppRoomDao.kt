package quizapp.volkova.notesapp.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import quizapp.volkova.notesapp.models.NoteBody

@Dao
interface AppRoomDao {
    @Query("SELECT * from notes_tables")
    fun getAllNotes():LiveData<List<NoteBody>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteBody)

    @Delete
    suspend fun delete(note: NoteBody)
}
package com.example.data.repository

import androidx.lifecycle.LiveData
import com.example.data.entities.NoteBody

interface DataBaseRepository {
    //should:
    //get list of all notes
    //add note to db
    //remove note from db
    //suspend for separate coroutines
    val allNotes: LiveData<List<NoteBody>>
    suspend fun insert(noteBody: NoteBody, onSuccess:()->Unit)
    suspend fun delete(noteBody: NoteBody, onSuccess:()->Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}
    fun signOut(){}
}
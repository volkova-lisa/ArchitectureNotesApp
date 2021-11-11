package quizapp.volkova.notesapp.database

import androidx.lifecycle.LiveData
import quizapp.volkova.notesapp.models.NoteBody

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
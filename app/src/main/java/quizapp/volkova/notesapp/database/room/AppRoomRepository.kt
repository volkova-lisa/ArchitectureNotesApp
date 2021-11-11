package quizapp.volkova.notesapp.database.room

import androidx.lifecycle.LiveData
import quizapp.volkova.notesapp.database.DataBaseRepository
import quizapp.volkova.notesapp.models.NoteBody

class AppRoomRepository(private val appRoomDao: AppRoomDao): DataBaseRepository {


    override val allNotes: LiveData<List<NoteBody>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(noteBody: NoteBody, onSuccess: () -> Unit) {

        appRoomDao.insert(noteBody)
        onSuccess()
    }

    override suspend fun delete(noteBody: NoteBody, onSuccess: () -> Unit) {
        appRoomDao.delete(noteBody)
        onSuccess()
    }

    override fun signOut() {
        super.signOut()
    }
}
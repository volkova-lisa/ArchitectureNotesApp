package quizapp.volkova.notesapp.database.room

import androidx.lifecycle.LiveData
import com.example.data.db.dao.AppRoomDao
import com.example.data.repository.DataBaseRepository
import com.example.data.entities.NoteBody

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
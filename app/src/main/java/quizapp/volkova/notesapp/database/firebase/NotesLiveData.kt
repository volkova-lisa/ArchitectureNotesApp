package quizapp.volkova.notesapp.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.REF_DATABASE

class NotesLiveData: LiveData<List<NoteBody>>() {
    private val listener = object : ValueEventListener{
        override fun onCancelled(p0: DatabaseError) {
        }

        override fun onDataChange(p0: DataSnapshot) {
            value = p0.children.map {
                it.getValue(NoteBody::class.java)?: NoteBody()
            }
        }
    }

    override fun onInactive() {
        REF_DATABASE.removeEventListener(listener)
        super.onInactive()
    }

    override fun onActive() {
        REF_DATABASE.addValueEventListener(listener)
        super.onActive()
    }
}
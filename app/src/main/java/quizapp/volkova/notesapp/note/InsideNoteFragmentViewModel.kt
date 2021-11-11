package quizapp.volkova.notesapp.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.REPOSITORY

class InsideNoteFragmentViewModel(app: Application): AndroidViewModel(app) {
    fun delete(note : NoteBody, onSuccess: ()->Unit){
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.delete(note){
                onSuccess()
            }
        }
    }
}
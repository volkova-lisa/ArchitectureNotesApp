package quizapp.volkova.notesapp.screen.create_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.REPOSITORY

class CreateNoteFragmentViewModel(app: Application) : AndroidViewModel(app) {

    fun insertNote(note:NoteBody, onSuccess:()-> Unit) =
        //coroutines special for lifecycle
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(note){
                onSuccess()
            }
        }
}
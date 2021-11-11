package quizapp.volkova.notesapp.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import quizapp.volkova.notesapp.utils.REPOSITORY

class MainFragmentViewModel(app: Application): AndroidViewModel(app) {
    val allNotes = REPOSITORY.allNotes
    fun signOut(){
        REPOSITORY.signOut()
    }
}
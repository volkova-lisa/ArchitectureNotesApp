package quizapp.volkova.notesapp.utils

import android.widget.Toast

fun showToast(text: String){
    Toast.makeText(APP_ACTIVITY, text, Toast.LENGTH_SHORT).show()
}
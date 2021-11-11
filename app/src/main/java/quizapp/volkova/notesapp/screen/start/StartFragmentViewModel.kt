package quizapp.volkova.notesapp.screen.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import quizapp.volkova.notesapp.database.firebase.FirebaseRepository
import quizapp.volkova.notesapp.database.room.AppRoomDatabase
import quizapp.volkova.notesapp.database.room.AppRoomRepository
import quizapp.volkova.notesapp.utils.REPOSITORY
import quizapp.volkova.notesapp.utils.TYPE_FIREBASE
import quizapp.volkova.notesapp.utils.TYPE_ROOM
import quizapp.volkova.notesapp.utils.showToast

class StartFragmentViewModel(app: Application) : AndroidViewModel(app) {
    private val mContext = app

    fun initDataBase(type: String, onSuccess:()->Unit) {
         when(type){
             TYPE_ROOM -> {
                 val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                 REPOSITORY = AppRoomRepository(dao)
                 onSuccess()
             }

             TYPE_FIREBASE -> {
                 REPOSITORY = FirebaseRepository()
                 REPOSITORY.connectToDatabase({onSuccess()},{ showToast(it)})
             }
         }
    }
}
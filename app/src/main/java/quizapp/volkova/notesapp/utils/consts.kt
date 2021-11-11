package quizapp.volkova.notesapp.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import quizapp.volkova.notesapp.MainActivity
import quizapp.volkova.notesapp.database.DataBaseRepository

lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_ID: String
lateinit var REF_DATABASE: DatabaseReference
lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY:DataBaseRepository
const val TYPE_DATABASE = "type database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val ID_FIREBASE = "id_firebase"
const val NAME = "name"
const val TEXT = "text"
lateinit var EMAIL: String
lateinit var PASS: String
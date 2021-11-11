package quizapp.volkova.notesapp.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.prefs.AbstractPreferences

object Preference {
    private const val INIT_USER = "init_user"
    private const val TYPE_DATABASE = "type_db"
    private const val NAME_PREF = "pref"

    private lateinit var mPreferences: SharedPreferences

    fun getPreference(context: Context) : SharedPreferences {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun setInitUser(init: Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    fun setDBType(type : String) {
        mPreferences.edit()
            .putString(TYPE_DATABASE, type)
            .apply()
    }

    fun getInitUser():Boolean {
        return mPreferences.getBoolean(INIT_USER, false)
    }

    fun getDBType():String{
        return mPreferences.getString(TYPE_DATABASE, TYPE_ROOM).toString()
    }
}
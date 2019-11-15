package com.example.to_do.model

import android.content.Context
import android.content.SharedPreferences.Editor

class SharedPreferences {

    val PREFS_NAME = "USER_PREF"
    val PREFS_KEY = "USER_PREF_id"

    fun save(context: Context, id: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor: Editor
        editor = prefs.edit()
        editor.putInt(PREFS_KEY, id)
        editor.apply()
    }

    fun getId(context: Context): Int? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val id: Int?
        id = prefs.getInt(PREFS_KEY, 0)
        return id
    }

    fun clearSharedPreference(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor: Editor
        editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

}
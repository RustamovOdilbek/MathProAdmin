package com.mathpro.admin.helper

import android.content.Context


class SharedPref (context: Context) {
    val sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    fun saveLogIn(key: String, data: Boolean) {
        sharedPref.edit().putBoolean(key, data).apply()
    }

    fun getLogIn(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }
}
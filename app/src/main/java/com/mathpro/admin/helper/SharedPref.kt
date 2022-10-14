package com.mathpro.admin.helper

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class SharedPref @Inject constructor(@ApplicationContext val context: Context)  {
    val sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    fun saveUserToken(key: String, data: String) {
        sharedPref.edit().putString(key, data).apply()
    }

    fun getUserToken(key: String, data: String): String {
        return sharedPref.getString(key, data)!!
    }
}
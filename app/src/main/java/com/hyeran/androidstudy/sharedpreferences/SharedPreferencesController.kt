package com.hyeran.androidstudy.sharedpreferences

import android.content.Context

object SharedPreferencesController {
    private const val FILE_NAME: String = "android study"

    /** KEY **/
    const val KEY_DATA: String = "data"
    const val KEY_NAME: String = "name"

    fun saveString(context: Context, key: String, input: String) {
        val editor = getPreferences(context).edit()
        editor.putString(key, input)
        editor.apply()
    }

    fun getString(context: Context, key: String): String? {
        return getPreferences(context).getString(key, null)
    }

    fun removeString(context: Context, key: String) {
        val editor = getPreferences(context).edit()
        editor.remove(key)
        editor.apply()
    }

    fun clearAll(context: Context) {
        val editor = getPreferences(context).edit()
        editor.clear();
        editor.apply()
    }

    private fun getPreferences(context: Context) = context.getSharedPreferences(
        FILE_NAME, Context.MODE_PRIVATE
    )
}
package com.example.wsw.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.listitem_apply_study.view.*

class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences
    = context.getSharedPreferences("pref_name", Context.MODE_PRIVATE)

    fun getInt(key:String, defValue: Int):Int{
        return prefs.getInt(key, defValue)
    }
    fun setInt(key:String, value:Int){
        prefs.edit().putInt(key, value).apply()
    }

    fun getString(key: String, defValue: String):String{
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key:String, str:String){
        prefs.edit().putString(key, str).apply()
    }
}
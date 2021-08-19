package com.example.wsw.data

import android.app.Application

class AppData :Application() {
    companion object{
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()
        prefs = PreferenceUtil(applicationContext)
    }
}
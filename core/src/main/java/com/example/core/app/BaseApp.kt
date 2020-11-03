package com.example.core.app

import android.app.Application
import android.content.Context

open class BaseApp:Application() {
    override fun onCreate() {
        super.onCreate()
        getAppContext(this)
    }

    companion object{
        lateinit var appContext: Context
        fun getAppContext(_context:Context){
            appContext=_context
        }
    }
}
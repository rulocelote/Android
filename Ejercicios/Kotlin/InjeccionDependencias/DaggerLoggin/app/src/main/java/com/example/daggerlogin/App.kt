package com.example.daggerlogin

import android.app.Application
import dagger.internal.DaggerCollections

class App: Application() {

    val component:ApplicationComponent by lazy{
        Dagger
    }


    override fun onCreate() {
        super.onCreate()
    }
}


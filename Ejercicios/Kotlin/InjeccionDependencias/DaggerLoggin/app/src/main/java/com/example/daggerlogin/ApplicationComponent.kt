package com.example.daggerlogin

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModel::class))
interface ApplicationComponent {
    fun inject(application:Application)
}
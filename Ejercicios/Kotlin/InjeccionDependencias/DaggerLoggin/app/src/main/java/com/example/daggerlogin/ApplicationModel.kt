package com.example.daggerlogin

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Modulo para llevar un tracking de todas las dependencias
@Module class ApplicationModel(private val application: Application) {

    //funcion de retorno de tipo contexto
    //por que solo se instanciara una vez
    @Provides @Singleton
    fun provideContext() = application
}
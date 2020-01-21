package com.sem.empresasappandcmal.view.registro

import android.content.Context

interface RegistroView {
    fun enviaDatos()
    fun onRegistroSucces(descripcion:String)
    fun onFailIdExist(descripcion: String)
    fun onFailConexionError(descripcion: String)
    fun showProgres()
    fun hideProgres()
}
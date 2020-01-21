package com.sem.empresasappandcmal.view.pass_olvidado

interface OlvidoPassView {
    fun enviarDatos()
    fun requestSuccess(descripcion: String)
    fun requestFail(descripcion: String)
    fun errorConexion()
    fun showProgres()
    fun hideProgres()
}
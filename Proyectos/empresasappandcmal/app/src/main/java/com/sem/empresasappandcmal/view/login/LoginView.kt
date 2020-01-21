package com.sem.empresasappandcmal.view.login

interface LoginView {
    fun onLoginSucces(descripcion:String,idEmpleado:String)
    fun numEmpleadoFail(descripcion: String)
    fun passwordFail(descripcion: String)
    fun conexionFail()
    fun showProgres()
    fun hideProgres()
}
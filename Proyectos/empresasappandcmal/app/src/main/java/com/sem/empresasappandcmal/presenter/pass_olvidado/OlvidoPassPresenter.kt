package com.sem.empresasappandcmal.presenter.pass_olvidado

interface OlvidoPassPresenter {
    fun enviarDatos(numEmpleado:String,correo:String,password:String)
    fun requestSuccess(codigo:String,descripcion: String)
    fun requestFail()

}
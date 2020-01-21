package com.sem.empresasappandcmal.model.pass_olvidado

interface OlvidoPassModel {
    fun cambiarPassword(numEmpleado:String, correo:String, password:String)
}
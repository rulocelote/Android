package com.sem.empresasappandcmal.model.registro

interface RegistroModel {
    fun validaRegistro(
        idEmpleado:String,
        nombre:String,
        apPaterno:String,
        apMaterno:String,
        fechaNacimiento:String,
        celular:String,
        correo:String,
        contrasena:String,
        foto:String
    )
}
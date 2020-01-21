package com.sem.empresasappandcmal.model.perfil

interface PerfilModel {
    fun recuperarAsistencia(numEmpleado:String)
    fun recuperarDatos(numEmpleado: String)
    fun registraAsistencia(
        idEmpleado:String,
        foto:String,
        fechaAsistencia:String,
        latitud:Double,
        longitud:Double
    )
}
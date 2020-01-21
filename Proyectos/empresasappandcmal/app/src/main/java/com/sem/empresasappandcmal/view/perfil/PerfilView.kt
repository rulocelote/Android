package com.sem.empresasappandcmal.view.perfil

import com.sem.empresasappandcmal.data.perfil.ListaAsistencia


interface PerfilView {
    fun requestSucces(asistencia:ArrayList<ListaAsistencia> = arrayListOf())
    fun requestFail(descripcion:String)
    fun failConexion()
    fun requestAsistencia(descripcion: String)
    fun requestDatos(idEmpleado: String, nombre: String, apellido: String, foto: String)
    fun asistenciaRegistrada(fecha:String, hora:String)
    fun sinAsistencia(fecha: String)
    fun showProgres()
    fun hideProgres()
}
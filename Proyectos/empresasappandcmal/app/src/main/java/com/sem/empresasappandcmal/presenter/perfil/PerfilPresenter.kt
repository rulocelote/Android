package com.sem.empresasappandcmal.presenter.perfil

import android.content.Context
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import com.sem.empresasappandcmal.data.perfil.ListaAsistencia

interface PerfilPresenter {
    fun enviarAsistencia(numEmpleado: String)
    fun enviarDatos(numEmpleado:String)
    fun requestAsistencia(codigoOperacion:String, descripcion:String, listaAsistencia: ArrayList<ListaAsistencia>)
    fun requestData(idEmpleado:String,nombre:String,apellido:String,foto:String)
    fun requestFail()
    fun requestFailAsistencia()
    fun permisos(context: Context): Boolean
    fun mostrarAsistencia(dia:String, mes:String, anio:String, asistencia: ArrayList<ListaAsistencia>)
    fun comparaHora(hora:String):String
    fun decoderImage(foto:String): RoundedBitmapDrawable
    fun proveedorLocation()
    fun confirmacionEnviarAsistencia(numEmpleado: String,encoder:String,fechaAsitencia:String,latitud:Double,lontigutd:Double)
    fun asistenciaRequest(descripcion:String)
}
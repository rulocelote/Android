package com.sem.empresasappandcmal.presenter.registro

import android.content.Context
import java.io.File

interface RegistroPresenter {
    fun createImageFile(): File
    fun enviarDatos(numEmpleado:String, name:String, apPaterno:String, apMaterno:String = "", fechaNacimiento:String, telefono:String, correo:String, pass:String, passCOnfirm:String)
    fun retornaRespuesta(codigo:String, descripcion:String)
    fun onFailConection()
    fun permisos(context: Context): Boolean
    fun dispatchTakePictureIntent()
    fun encoderPicture(path:String):String
}
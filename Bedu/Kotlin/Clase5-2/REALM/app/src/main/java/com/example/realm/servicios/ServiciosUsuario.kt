package com.example.realm.servicios

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Environment
import com.example.realm.model.Usuario
import io.realm.Realm
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ServiciosUsuario(val realm:Realm) {
    //Obtener usuarios
    fun obtenerUsuarios():List<Usuario>{
        var usuarios = realm.where(Usuario::class.java).findAll()
        return usuarios
    }

    //Crear usuario
    fun crearUsuario(id:Int, nombre:String, telefono:String){
        realm.beginTransaction()

        val user:Usuario = realm.createObject(Usuario::class.java, id)
        user.nombre = nombre
        user.telefono = telefono

        realm.commitTransaction()

    }

    fun obtenerUltimoid():Int{
       val id = realm.where(Usuario::class.java).max("id")
       val ultimoId = id?.toInt()?.plus(1) ?: 1
        //if(id == null) 1 else (id.toInt().plus(1))
        return ultimoId
    }

    fun actualizaDatosUsuario(usuario:Usuario, nombre:String, telefono: String){
        realm.beginTransaction()
        usuario.nombre = nombre
        usuario.telefono = telefono
        realm.commitTransaction()
    }

    fun obtenerUsuarioPorId(id:Int):Usuario?{
        val usuario = realm.where(Usuario::class.java).equalTo("id",id).findFirst()
        return usuario
    }

    fun eliminarUsuario(id:Int){
        val usuario = obtenerUsuarioPorId(id)
        if(usuario != null){
            realm.beginTransaction()
            usuario.deleteFromRealm()
            realm.commitTransaction()
        }
    }


}
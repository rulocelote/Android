package com.sem.empresasappandcmal.model.realm

import io.realm.Realm

class RealmUsers(private val realm:Realm){
    fun crearUsuario(numEmpleado:String, nombre: String, apellido: String, foto:String){
        realm.beginTransaction()
        val user: Usuario = realm.createObject(Usuario::class.java, 1)
        user.numEmpleado = numEmpleado
        user.nombre = nombre
        user.apellido = apellido
        user.foto = foto
        realm.commitTransaction()
    }

    fun obtenerUsuario(): Usuario?{
        val usuario = realm.where(Usuario::class.java).findFirst()
        return usuario
    }

    fun eliminarUsuario(){
        val usuario = obtenerUsuario()
        if(usuario != null){
            realm.beginTransaction()
            usuario.deleteFromRealm()
            realm.commitTransaction()
        }
    }
}
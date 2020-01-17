package com.example.demoapichofer.servicios

import com.example.demoapichofer.modelos.Chofer
import io.realm.Realm

class ServisiosChofer(val realm:Realm) {

    //obtenerChofer
    fun obtenerChofer():List<Chofer>{
        var listaChofer = realm.where(Chofer::class.java).findAll()
        return listaChofer
    }


    //Crear Chofer
    fun insertarChofer(id:Int,nombre:String,apellidos:String, telefono:String,latitud:String,longitud:String,calificacion:Double){

        realm.beginTransaction()
        val chofer:Chofer = realm.createObject(Chofer::class.java, id)
        chofer.nombre = nombre
        chofer.apellidos = apellidos
        chofer.telefono = telefono
        chofer.latitud = latitud
        chofer.longitud= longitud
        chofer.calificacion= calificacion

        realm.commitTransaction()
    }

    //obtener ultimo id
    fun obtenerUltimoId():Int{
        val id = realm.where(Chofer::class.java).max("idChofer")
        val ultimoId = if(id == null) 1 else (id.toInt() +1)
        return ultimoId
    }
}
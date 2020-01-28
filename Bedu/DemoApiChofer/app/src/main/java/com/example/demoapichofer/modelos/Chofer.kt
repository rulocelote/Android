package com.example.demoapichofer.modelos

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Chofer:RealmObject() {

    @PrimaryKey
    var idChofer=0
    lateinit var nombre:String
    lateinit var apellidos:String
    lateinit var telefono:String
    lateinit var latitud:String
    lateinit var longitud:String
    var calificacion:Double =0.0
}
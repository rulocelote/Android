package com.example.firebasebd

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object BaseDatos {
    val RUTA_PRODUCTOS = "PRODUCTOS"

    fun obtenerInstanciaProductos():DatabaseReference{
        val db = FirebaseDatabase.getInstance()
        val reference = db.getReference(RUTA_PRODUCTOS)
        return reference
    }


}
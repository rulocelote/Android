package com.example.registromvp.model.data

import com.google.gson.annotations.SerializedName

data class Datos(
    @SerializedName("correo") var correo:String,
    @SerializedName("nombre") var nombre:String,
    @SerializedName("telefono") var telefono:String,
    @SerializedName("cuentas") var cuenta:List<Cuentas>
)

data class Cuentas(
    @SerializedName("numero") var numero:String,
        @SerializedName("saldo") var saldo:String
)
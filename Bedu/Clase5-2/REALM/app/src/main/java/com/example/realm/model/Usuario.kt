package com.example.realm.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Usuario:RealmObject() {
    @PrimaryKey
    var id:Int = 0
    var nombre:String = ""
    var telefono:String = ""
}
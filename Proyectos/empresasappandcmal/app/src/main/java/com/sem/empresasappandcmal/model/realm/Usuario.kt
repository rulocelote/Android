package com.sem.empresasappandcmal.model.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Usuario:RealmObject() {
    @PrimaryKey
    var id:Int = 0
    var numEmpleado:String = ""
    var nombre:String = ""
    var apellido:String = ""
    var foto:String = ""
}

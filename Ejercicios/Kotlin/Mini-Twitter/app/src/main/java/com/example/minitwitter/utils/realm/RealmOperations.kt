package com.example.minitwitter.utils.realm

import io.realm.Realm

class RealmOperations(val realm:Realm) {
    fun crearToken(token:String){
        realm.beginTransaction()
        val realmData = realm.createObject(RealmData::class.java,2)
        realmData.token = token
        realm.commitTransaction()
    }

    fun obtenerToken():RealmData?{
        val data = realm.where(RealmData::class.java).findFirst()
        return data
    }

    fun eliminarData(){
        val data = obtenerToken()
        if(data != null){
            realm.beginTransaction()
            data.deleteFromRealm()
            realm.commitTransaction()
        }
    }
}
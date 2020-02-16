package com.example.minitwitter.utils.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmData : RealmObject(){
    @PrimaryKey
    var id:Int = 0
    var token:String = ""
}
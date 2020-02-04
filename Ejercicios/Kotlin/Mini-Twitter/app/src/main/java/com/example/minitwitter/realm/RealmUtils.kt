package com.example.minitwitter.realm

import android.content.Context
import com.example.minitwitter.utils.Constantes.DATA_BASE
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmUtils {
    companion object{
        private lateinit var realmBD:RealmOperations

        fun realmData(context: Context):RealmOperations{
            Realm.init(context)
            val config:RealmConfiguration = RealmConfiguration.Builder()
                .name(DATA_BASE)
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build()
            Realm.setDefaultConfiguration(config)
            realmBD = RealmOperations(Realm.getDefaultInstance())
            return realmBD

        }
    }
}
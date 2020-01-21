package com.sem.empresasappandcmal.model.realm

import android.content.Context
import com.sem.empresasappandcmal.utils.Constants.DATA_BASE
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmUtils{

    companion object{
        private lateinit var realmDB: RealmUsers

        fun realmUser(context:Context): RealmUsers {
            Realm.init(context)
            val config: RealmConfiguration = RealmConfiguration.Builder()
                .name(DATA_BASE)
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build()
            Realm.setDefaultConfiguration(config)
            realmDB = RealmUsers(Realm.getDefaultInstance())
            return realmDB
        }
    }
}
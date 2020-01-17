package com.example.demoapichofer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapichofer.adaptadores.ChoferesAdapter
import com.example.demoapichofer.servicios.ServisiosChofer
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var servisiosChofer:ServisiosChofer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "App chofer"

        Realm.init(this)

        val config: RealmConfiguration = RealmConfiguration.Builder()
            .name(getString(R.string.conductores))
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(1)
            .build()

        Realm.setDefaultConfiguration(config)
        servisiosChofer= ServisiosChofer(Realm.getDefaultInstance())

        var ultimoId = servisiosChofer.obtenerUltimoId()

        servisiosChofer.insertarChofer(ultimoId,"Carlos","Arteaga","5513851763","-89","20", 5.0)

        var listaChoferes = servisiosChofer.obtenerChofer()

        listaChoferes.forEach{
            Log.d("Mensaje", "Chofer ${it.idChofer} = ${it.nombre} ${it.apellidos}")
        }

        recyclarChofer.layoutManager = LinearLayoutManager(this)
        var miAdaptador = ChoferesAdapter(listaChoferes)
        recyclarChofer.adapter= miAdaptador

    }
}

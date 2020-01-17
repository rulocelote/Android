package com.example.realm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.realm.servicios.ServiciosUsuario
import io.realm.Realm
import io.realm.RealmConfiguration

class MainActivity : AppCompatActivity() {
    lateinit var serviciosUsuario:ServiciosUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //C CREATE
        //R READ
        //U UPDATE
        //D DELETE

        Realm.init(this)

        val config:RealmConfiguration = RealmConfiguration.Builder()
            .name(getString(R.string.db_name))
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(1)
            .build()

        Realm.setDefaultConfiguration(config)
        serviciosUsuario = ServiciosUsuario(Realm.getDefaultInstance())
        val obtenerUltimoId = serviciosUsuario.obtenerUltimoid()

        serviciosUsuario.crearUsuario(obtenerUltimoId, "Andrea", "56459787")

        mostrarUsuarios()

        //Modificando usuario
        /*var user = serviciosUsuario.obtenerUsuarioPorId(3)
        if(user != null){
            serviciosUsuario.actualizaDatosUsuario(user,"andrea","423423423")

        }*/
        serviciosUsuario.eliminarUsuario(3)
        mostrarUsuarios()

    }

    fun mostrarUsuarios(){
        val usuariosList = serviciosUsuario.obtenerUsuarios()
        usuariosList.forEach {
            Log.d("Mensaje", "Usuario ${it.id} = ${it.nombre}, Telefono: ${it.telefono}")
        }
    }
}

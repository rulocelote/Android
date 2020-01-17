package com.example.permisos

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var permisos: Map<String,String>  = mapOf("camara" to  Manifest.permission.CAMERA,"contactos" to Manifest.permission.READ_CONTACTS, "leerMensaje" to Manifest.permission.READ_SMS, "enviarMensjae" to Manifest.permission.SEND_SMS,"calendario" to Manifest.permission.READ_CALENDAR)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun permiso(view:View){
        var version = Build.VERSION.SDK_INT
        var tag = view.tag.toString()

        if(version>=Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(applicationContext,permisos[tag].toString()) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(permisos[tag]),5000)
                requestCameraPermission(tag)
            }else{
                Toast.makeText(applicationContext, "Ya cuenta con permisos", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(applicationContext, "No es necesario pedir permisos", Toast.LENGTH_SHORT).show()
        }
    }

    fun requestCameraPermission(tag:String) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permisos[tag].toString())) {
            Toast.makeText(applicationContext, "El usuario ya ha rechazado el permiso anteriormente, debemos informarle que vaya a ajustes.", Toast.LENGTH_SHORT).show()
            //El usuario ya ha rechazado el permiso anteriormente, debemos informarle que vaya a ajustes.
        } else {
            //El usuario nunca ha aceptado ni rechazado, así que le pedimos que acepte el permiso.
            Toast.makeText(applicationContext, "El usuario nunca ha aceptado ni rechazado, así que le pedimos que acepte el permiso.", Toast.LENGTH_SHORT).show()

        }
    }
}

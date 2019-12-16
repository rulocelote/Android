package com.example.fragmentpermisoskotlin

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var permisos: Map<String,String>  = mapOf("camara" to  Manifest.permission.CAMERA, "mensaje" to Manifest.permission.READ_SMS, "contactos" to Manifest.permission.READ_CONTACTS, "calendario" to Manifest.permission.READ_CALENDAR)
    var fragment: Map<String,Fragment> = mapOf("camara" to CamaraFragment(), "mensaje" to MensajesFragment(), "contactos" to ContactosFragment(), "calendario" to CalendarioFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Cambio(view:View){
        //contenedor.removeAllViews()
        val fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        var tag = view.getTag().toString()
        if(permisos(tag)){
            fragmentTransaction.remove(fragment[tag]!!)
            fragmentTransaction.add(R.id.contenedor, fragment[tag]!!,"f1")
            fragmentTransaction.addToBackStack("f1")
            fragmentTransaction.commit()
        }
    }

    fun permisos(tag:String):Boolean{
        var version = Build.VERSION.SDK_INT

        if(version>=Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(applicationContext, permisos.get(tag).toString()) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permisos[tag]), 1000)
                return false
            }else{ return true }
        } else {
            Toast.makeText(applicationContext, "No es necesario pedir permisos", Toast.LENGTH_SHORT).show()
            return true
        }
    }
}

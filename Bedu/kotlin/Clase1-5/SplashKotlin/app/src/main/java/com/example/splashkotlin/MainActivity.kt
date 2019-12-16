package com.example.splashkotlin

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMostrar.setOnClickListener{
            if(permiso("contactos") && permiso("calendario")){
                var fragmentManager = supportFragmentManager
                var fragmentTransaction = fragmentManager.beginTransaction()
                var fragment:UnoFragment = UnoFragment()
                fragmentTransaction.add(R.id.contenedor,fragment,"f1")
                fragmentTransaction.addToBackStack("f1")
                fragmentTransaction.commit()
            }
        }
    }

    fun permiso(tag:String):Boolean{
        var permisos:Map<String,String> = mapOf("contactos" to Manifest.permission.READ_CONTACTS, "calendario" to Manifest.permission.READ_CALENDAR)
        var version = Build.VERSION.SDK_INT

        if(version>=Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this, permisos.get(tag).toString()) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,  arrayOf(permisos.get(tag)), 0)
                return false
            }else{return true}
        }else{
            Toast.makeText(this, "No es necesario pedir permisos", Toast.LENGTH_SHORT).show()
            return true
        }
    }

    fun onRequestPermissionsResult(requestCode:Int,permission: Array<String>,grantResult: Array<Int>){
        when(requestCode){
            0 ->{
                for(i in 0..grantResult.size){
                    if(grantResult[i] == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(applicationContext, "Gracias por darme permisos: " + permission[i].get(i), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext, "La aplicacion se cerrara ahroa", Toast.LENGTH_SHORT).show()
                    }
                }
                return
            }
        }
    }
}

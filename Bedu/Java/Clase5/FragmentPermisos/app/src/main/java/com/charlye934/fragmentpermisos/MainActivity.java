package com.charlye934.fragmentpermisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String,String> permisos = new HashMap<>();
    String tipo[] = {"camara","mensaje","contactos","calendario"};
    String tipoPermiso[] = {Manifest.permission.CAMERA,Manifest.permission.READ_SMS,Manifest.permission.READ_CONTACTS, Manifest.permission.READ_CALENDAR};

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         for(int i=0; i<tipo.length; i++)
             permisos.put(tipo[i],tipoPermiso[i]);
    }

    public void Cambio(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        String tag = String.valueOf(view.getTag());
        Fragment fragment = null;

        if(Permisos(tag)){
            switch(tag){
                case "camara":
                    fragment = new CamaraFragment();
                    break;
                case "contactos":
                    fragment = new ContactosFragment();
                    break;
                case "mensaje":
                    fragment = new MensajesFragment();
                    break;
                case "calendario":
                    fragment = new CalendarioFragment();
                    break;
            }
            fragmentTransaction.add(R.id.contenedor, fragment, "f1");
            fragmentTransaction.addToBackStack("f1");
            fragmentTransaction.commit();
        }
    }

    public boolean Permisos(String tag){
        int version = Build.VERSION.SDK_INT;

        if(version >= Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(getApplicationContext(), permisos.get(tag)) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permisos.get(tag)}, 1000);
                return false;
            }else
                return true;
        }else{
            Toast.makeText(getApplicationContext(),"No es necesario pedir permisos",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}

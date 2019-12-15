package com.charlye934.splashdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto = getApplicationContext();

        int version = Build.VERSION.SDK_INT;
        Log.d("TAG", "VERSION: " +version);
        if(version >= Build.VERSION_CODES.M){
            Toast.makeText(getApplicationContext(),"Es necesrio pedir permisos", Toast.LENGTH_SHORT).show();

            // Here, thisActivity is the current activity
            if ((ContextCompat.checkSelfPermission(contexto, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            || (ContextCompat.checkSelfPermission(contexto,Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)
                || (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CALENDAR))){
                    Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                }

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS,Manifest.permission.READ_CALENDAR},
                        0);

            } else {
                Toast.makeText(getApplicationContext(),"Permiso concedido",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getApplicationContext(),"No es necesario pedir permisos",Toast.LENGTH_SHORT).show();
        }

        //FRAGMENTOS
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        UnoFragment fragment = new UnoFragment();
        fragmentTransaction.add(R.id.contenedor, fragment,"f1");
        fragmentTransaction.addToBackStack("f1");
        fragmentTransaction.commit();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
        String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 0: {
                for(int i = 0; i<grantResults.length; i++){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(getApplicationContext(),"Gracias por darme permisos: " + permissions[i],Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"La aplicacion se cerrara ahroa",Toast.LENGTH_SHORT).show();
                    }
                }

                return;
            }
        }
    }

    public void mostrarFragmentDos(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DosFragment fragment = new DosFragment();
        fragmentTransaction.add(R.id.contenedor, fragment,"f2");
        fragmentTransaction.addToBackStack("f1");
        fragmentTransaction.commit();
    }
}

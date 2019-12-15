package com.charlye934.sharescroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void compartir(View view) {
        //Recurso que vamos a compartir
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Texto a compartir");
        sendIntent.setType("text/plain");

        //Por donde lo vamos a compartir
        Intent shareIntent = Intent.createChooser(sendIntent,null);
        startActivity(shareIntent);
    }
}
